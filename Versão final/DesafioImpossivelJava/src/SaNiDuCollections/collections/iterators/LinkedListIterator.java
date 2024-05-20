package SaNiDuCollections.collections.iterators;

import SaNiDuCollections.collections.Iterator;
import SaNiDuCollections.collections.LinkedList;
import SaNiDuCollections.collections.Node;
import SaNiDuCollections.exceptions.IteratorException;

public class LinkedListIterator<T> implements Iterator<T> {
    private LinkedList<T> list;
    private Node<T> node = null;

    // Construtor da classe, ele recebe a lista encadeada como parâmetro passa para a variável list
    public LinkedListIterator(LinkedList<T> list) {
        this.list = list;
    }

    @Override
    public T next() throws IteratorException {
        // Se o nó for null, o que vai acontecer na primeira interação, ele coloca o node como valendo o primeiro elemento da lista encadeada
        if (node == null) {
            node = list.getHead();

        // Se não, ele transforma o node no próximo nó
        } else {
            node = node.getNext();

            // Se o nó ainda estiver vazio, ele chama o erro
            if (node == null) {
                throw new IteratorException();
            }
        }
        // Retorna o valor do nó
        return node.getValue();
    }

    @Override
    public boolean hasNext() {
        // Se o nó for igual a null e o size da lista for maior do que 0, significa que ainda tem elementos a serem visitados, então retorna true
        if (node == null && list.getSize() > 0) {
            return true;
        }

        // Se o node for diferente do tail (variável que armazena o último elemento da lista encadeada), ele retorna true, pq quer dizer que o node ainda tem elementos a serem visitados
        // Caso contrário, retorna false, pois eles terão o mesmo valor
        return node != list.getTail(); 
    }

}