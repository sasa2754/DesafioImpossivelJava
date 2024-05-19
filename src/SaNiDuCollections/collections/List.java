package SaNiDuCollections.collections;

public abstract class List<T> extends Base
{
    abstract T get(int index);
    abstract void set(int index, T value);
    abstract void add(T value);
}