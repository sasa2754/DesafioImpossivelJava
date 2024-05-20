package SaNiDuCollections.collections;

public class HashItem<T>
{
    private int key;
    private T value;

    // Construtor da classe, inicializa um novo objeto com uma chave e um valor
    public HashItem(int key, T value)
    {
        this.key = key;
        this.value = value;
    }

    // Métodos de get e set
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    
}
