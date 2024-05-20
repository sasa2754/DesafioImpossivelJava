package SaNiDuCollections.collections.iterators;

import SaNiDuCollections.collections.ArrayList;
import SaNiDuCollections.collections.Iterator;
import SaNiDuCollections.exceptions.IteratorException;

public class ArrayListIterator<T> implements Iterator<T>
{
    private ArrayList<T> list;
    private int index;

    // Construtor da classe, ele recebe a lista e inicializa o index em -1
    public ArrayListIterator(ArrayList<T> list)
    {
        this.list = list;
        this.index = -1;
    }

    @Override
    public T next() throws IteratorException
    {
        // Cria uma variável do tipo T, que armazena o próximo index de list
        // (++index) é um operador de incremento preximo, ele incrementa +1 a variável antes de usá-la na operação
        T value = list.get(++index);

        // Se value for "null", ele chama um erro
        if (value == null) {
            throw new  IteratorException();
        }
        
        // No final, retorna o valor
        return value;
    }

    @Override
    public boolean hasNext()
    {
        // Se index for menor do que o último elemento da lista, ele retorna true, pq significa que ainda tem elementos que não foram visitados, caso contrário, ele retorna false
        return index < list.getSize()-1;
    }
}