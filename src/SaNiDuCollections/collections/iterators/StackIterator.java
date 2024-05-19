package SaNiDuCollections.collections.iterators;

import SaNiDuCollections.collections.Iterator;
import SaNiDuCollections.collections.Stack;
import SaNiDuCollections.exceptions.IteratorException;

public class StackIterator<T> implements Iterator<T>
{
    Stack<T> stack;
    public StackIterator(Stack<T> stack) {
        super();

        this.stack = stack;
    }

    @Override
    public T next() throws IteratorException {
        T value = stack.pop();

        if (value == null)
            throw new IteratorException();

        return value;
    }

    @Override
    public boolean hasNext() {
        return stack.getSize() > 0;
    }
    
}