package SaNiDuCollections.collections.iterators;

import SaNiDuCollections.collections.Iterator;
import SaNiDuCollections.exceptions.IteratorException;
import SaNiDuCollections.collections.ArrayList;
import SaNiDuCollections.collections.LinkedList;
import SaNiDuCollections.collections.HashItem;

public class HashIterator<T> implements Iterator<T>
{
    ArrayList<LinkedList<HashItem<T>>> data; //Armazena a referência do array de listas encadeadas (hash)
    Iterator<LinkedList<HashItem<T>>> arrayIterator; //Iterador para percorrer o array de listas encadeadas
    Iterator<HashItem<T>> linkedListIterator; //Iterador para percorrer uma lista encadeada específica

    // Construtor da classe, ele recebe como parâmetro uma lista de listas encadeadas
    public HashIterator(ArrayList<LinkedList<HashItem<T>>> data) {
        this.data = data;
        arrayIterator = this.data.iterator();
    }

    @Override
    // A função "next" retorna cada valor presente em todas as listas encadeadas, um após o outro, até que todos os elementos tenham sido percorridos
    public T next() throws IteratorException {

        // Se o linkedList for igual a null, ele passa para a próxima casinha do array
        if (linkedListIterator == null) {
            linkedListIterator = arrayIterator.next().iterator();
        }

        // Loop para encontrar uma lista encadeada que tem elementos dentro
        while (!linkedListIterator.hasNext()) {
            // Verifica senão tem mais listas encadeadas no array, se não tiver, ele lança um erro
            if (!arrayIterator.hasNext()) {
                throw new IteratorException();
            }
            // Inicializa o iterador para a próxima lista encadeada
            linkedListIterator = arrayIterator.next().iterator();
        }
        // Retorna o próximo valor na lista encadeada
        return linkedListIterator.next().getValue();
    }

    @Override
    // Confere se ele tem um próximo elemento
    public boolean hasNext() {

        if (linkedListIterator != null && linkedListIterator.hasNext()) {
            return true;
        }

        while (arrayIterator.hasNext()) {
            try {
                linkedListIterator = arrayIterator.next().iterator();

                if (linkedListIterator.hasNext()) {
                    return true;
                }
            } catch (IteratorException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    
}