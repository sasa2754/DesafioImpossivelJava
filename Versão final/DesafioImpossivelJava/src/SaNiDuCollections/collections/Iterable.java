package SaNiDuCollections.collections;

import SaNiDuCollections.Stream;

public interface Iterable<E>{

    //Declaração de métodos, o corpo deve estar nos arquivos que usam a interface
    public Iterator<E> iterator();
    public Stream<E> stream();
}
