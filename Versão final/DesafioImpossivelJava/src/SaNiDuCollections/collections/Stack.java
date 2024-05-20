package SaNiDuCollections.collections;

public class Stack<T> extends ArrayList<T>
{
    // Construtor da classe, é o mesmo do ArrayList
    public Stack()
    {
        super();
    }

    // Construtor caso seja passado algum parâmetro
    public Stack(int size)
    {
        super(size);
    }

    // Adiciona um novo elemento na lista
    public void push(T value)
    {
        super.add(value);
    }

    // Tira o último elemento da lista
    public T pop()
    {
        T value = data[--size];
        data[size] = null;

        return value;
    }
}