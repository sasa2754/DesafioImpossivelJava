package SaNiDuCollections.collections;

import SaNiDuCollections.Stream;
import SaNiDuCollections.collections.iterators.LinkedListIterator;

public class LinkedList<T> extends List<T> implements Iterable<T> {
    Node<T> head = null;
    Node<T> tail = null;

    // Adiciona novos dados no final da lista encadeada
    public void add(T value) {
        Node<T> item = new Node<T>(value);

        // Se for o primeiro elemento da lista, ele coloca o head e o tail igual ao valor passado
        if (head == null && tail == null) {
            head = item;
            tail = item;

        // Se não, ele coloca o valor no próximo nó e muda o valor de tail para o último elemento 
        } else {
            tail.setNext(item);
            tail = item;
        }
        // Aumenta o size
        ++size;
    }

    // Método para retornar um valor pelo index informado
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        // Cria uma variável chamada "current" para armazenar o nó atual, ele começa no primeiro item "head"
        Node<T> current = head;

        // Cria um loop até chegar no index informado
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        // Retorna o valor armazenado no current
        return current.getValue();
    }

    // Muda o valor em um certo index, faz praticamente a mesma coisa que a função anterior, mas ele seta o valor no index informado
    public void set(int index, T value) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setValue(value);
    }

    // getter e setters
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    @Override
    public Stream<T> stream() {
        return new Stream<T>(this);
    }
}
