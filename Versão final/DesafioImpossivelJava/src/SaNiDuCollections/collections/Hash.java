package SaNiDuCollections.collections;

import SaNiDuCollections.Stream;
import SaNiDuCollections.collections.iterators.HashIterator;

public class Hash<T> implements Iterable<T> {
    // Declara uma variável que é uma lista de listas encadeadas, onde cada lista encadeada armazena itens HashItem do tipo T
    ArrayList<LinkedList<HashItem<T>>> data;

    public Hash() {
        // Inicializa "data" como uma lista de listas encadeadas vazias
        data = new ArrayList<LinkedList<HashItem<T>>>();

        // Loop para adicionar 10 listas encadeadas vazias a "data"
        for (int i = 0; i < 10; ++i) {
            data.add(new LinkedList<HashItem<T>>());
        }
    }

    // Construtor que faz a mesma coisa do anterior, mas tem um tamanho específico para iniciar
    public Hash(int size) {
        data = new ArrayList<LinkedList<HashItem<T>>>(size);

        for (int i = 0; i < size; ++i) {
            data.add(new LinkedList<HashItem<T>>());
        }
    }

    // Método para adicionar um novo valor ao hash
    public void add(int key, T value) {

        // Cria um novo item "HashItem" com a chave a o valor fornecido
        HashItem<T> hashItem = new HashItem<T>(key, value);

        // Verifica se a lista encadeada correspondente está cheia, se estiver, ele aumenta o tamanho do arraylist e redistribui os valores dentro dele
        if (data.get(key % data.getSize()).getSize() == 10) {

            Hash<T> NewHash = new Hash<T>(data.getSize() * 2);

            for (int i = 0; i < data.getSize(); ++i) {
                LinkedList<HashItem<T>> LL = data.get(i);

                for (int j = 0; j < LL.getSize(); ++j) {
                    NewHash.add(LL.get(i).hashCode(), LL.get(i).getValue());
                }
            }

        }
        // Adiciona o novo valor ao final da lista
        data.get(key % data.getSize()).add(hashItem);
    }

    // Método para obtet um valor pela sua chave
    public T get(int key) {
        // Obtém a lista encadeada correspondente à chave informada
        LinkedList<HashItem<T>> list = data.get(key % data.getSize());

        // Loop para procurar pelo item correspondente
        for (int i = 0; i < list.getSize(); ++i) {

            // Obtém o item da lista
            HashItem<T> HI = list.get(i);

            // Verifica se a chave daquele item corresponde a chave informada, se sim, ele retorna o valor dentro da chave
            if (HI.getKey() == key) {
                return HI.getValue();
            }
        }

        // Se ele não encontrar nada, retorna null
        return null;
    }

    // Método para saber se certo valor existe dentro do hash
    public boolean contains(T value) {

        // Primeiro é pego o hash code do valor informado
        int key = value.hashCode();
        
        // Usa o key para calcular o índice no hash
        int index = key % data.getSize();

        // Pega o linked list no índice calculado
        LinkedList<HashItem<T>> list = data.get(index);

        // Verifica se o valor informado é igual ao valor existente, se for retorna true
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getValue().equals(value)) {
                return true;
            }
        }
        
        // Se não, retorna false
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashIterator<T>(data);
    }

    @Override
    public Stream<T> stream() {
        return new Stream<>(this);
    }
}
