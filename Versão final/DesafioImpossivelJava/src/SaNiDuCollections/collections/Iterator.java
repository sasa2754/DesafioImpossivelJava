package SaNiDuCollections.collections;

import SaNiDuCollections.exceptions.IteratorException;
// O iterador é uma ferramenta fundamental para percorrer uma coleção de elementos, permitindo acessar cada item um de cada vez sem expor a estrutura interna da coleção
// O iterador permite acessar cada elemento da coleção um de cada vez, sem necessidade de conhecer a estrutura interna de uma coleção
public interface Iterator<T>
{
    // Retorna o próximo elemento na iteração
    public T next() throws IteratorException;
    
    // Retorna true se houver um próximo elemento na iteração
    public boolean hasNext();

}