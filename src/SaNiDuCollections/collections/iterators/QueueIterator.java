package SaNiDuCollections.collections.iterators;

import SaNiDuCollections.collections.Iterator;
import SaNiDuCollections.collections.Queue;
import SaNiDuCollections.exceptions.IteratorException;

public class QueueIterator<E> implements Iterator<E>
{
    Queue<E> queue;

    public QueueIterator(Queue<E> queue) {
        super();

        this.queue = queue;
    }

    @Override
    public E next() throws IteratorException {
        E value = queue.dequeue();

        if (value == null) {
            throw new IteratorException();
        }

        return value;
    }


    @Override
    public boolean hasNext() {
        return queue.getSize() > 0;
    }
    
}