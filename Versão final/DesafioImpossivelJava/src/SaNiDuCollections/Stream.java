package SaNiDuCollections;

import java.util.function.Function;

import SaNiDuCollections.collections.ArrayList;
import SaNiDuCollections.collections.Iterator;
import SaNiDuCollections.collections.LinkedList;
import SaNiDuCollections.exceptions.IteratorException;
import SaNiDuCollections.collections.Iterable;;

// Nos métodos "map", "filter" e "collect", o iterador é usado para aplicar funções a cada elemento ("map"), filtrar elementos ("filter") e coletar elementos em uma nova lista ("collect")
public class Stream<E>
{
    // Declara uma instância "iterable" do tipo "Iterable<E>"
    Iterable<E> iterable;

    // Construtor da classe "Stream" que inicializa a variável "iterable" com o valor passado como argumento
    public Stream(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    // Define um método genérico "map" que aceita uma função "Function <E, R> e retorna um novo "Stream<R>". Cria uma lista encadeada "data" para armazenar os resultados da função aplicada
    public <R> Stream<R> map(Function<E, R> function) throws IteratorException {
        LinkedList<R> data = new LinkedList<>();
        
        // Obtém um iterador para a coleção "iterable"
        Iterator<E> iterator = iterable.iterator();

        // Faz um while enquanto o iterator tiver um next
        while (iterator.hasNext()) {
            // Itera sobre cada elemento da coleção, aplica a função a cada elemento e adiciona o resultado a lista
            // A função "apply" é uasada para transformar cada elemento da coleção, aplicando a função sobre cada um
            data.add(function.apply(iterator.next()));
        }

        // Retorna um novo "Stream<R>" contendo os elementos transformados
        return new Stream<R>(data);
    }

    // Cria o método filter que recebe como parâmetro uma função <E> e retorna um boolean, ele precisa ser aplicado com o try except, por isso tem o throws, que obriga o programador a fazer isso
    public Stream<E> filter(Function<E, Boolean> function) throws IteratorException {

        // Cria uma nova lista chamada "data" para armazenar os resultados
        LinkedList<E> data = new LinkedList<>();
        
        // Cria um iterador para a coleção "iterable"
        Iterator<E> iterator = iterable.iterator();

        // Cria um loop enquanto o iterator tiver um próximo
        while (iterator.hasNext()) {

            // Cria uma variável do tipo E chamada e
            E e = iterator.next();

            // Aplica a função passada para cada um dos elementos, se o elementos atender aos parâmetros, ele retorna "true" e é adicionado na lista
            if (function.apply(e)) {
                data.add(e);
            }
        }
        
        // Retorna um novo "Stream<E>" contendo os dados de "data"
        return new Stream<E>(data);
    }

    // Define o método "collect()" que vai retornar um "ArrayList<E>" contendo todos os elementos do Stream
    public ArrayList<E> collect() throws IteratorException {

        // Cria uma nova lista dinâmica chamada "list" para armazenar os elementos
        ArrayList<E> list = new ArrayList<>();

        // Cria um iterador para a coleção "iterable"
        Iterator<E> iterator = iterable.iterator();

        // Cria um loop enquanto o iterador tiver um next
        while (iterator.hasNext()) {
            // Adiciona na "list" o próximo elemento do iterador
            list.add(iterator.next());
        }

        // Retorna a lista
        return list;
    }  
}
