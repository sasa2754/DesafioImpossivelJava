package SaNiDuCollections.collections;

public class Queue<T> extends LinkedList<T>  {
    public Queue() {
        super();
    }

    // Adiciona um elemento na lista
    public void enqueue(T value) {
        super.add(value);
    }

    // Remove o último elemento da lista
    public T dequeue() {
        if (head == null) {
            return null;
        }

        --size;

        Node<T> Node = head;

        // Se o "head" for o único elemento, ele transforma o head e o tail em null
        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }

        return Node.getValue();
        
    }
}