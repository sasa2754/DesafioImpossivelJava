import SaNiDuCollections.collections.Hash;
import SaNiDuCollections.collections.List;
import SaNiDuCollections.exceptions.IteratorException;

public class Main {
    public static void main(String[] args) {
        // Cria uma nova instância do objeto Hash, que armazenará objetos do tipo "Pessoa"
        Hash<Pessoa> hash = new Hash<>();

        // Adiciona elementos ao hash 
    	hash.add(1, new Pessoa("Don", 14, true));
    	hash.add(2, new Pessoa("Trevis", 25, false));
    	hash.add(3, new Pessoa("Queila", 23, true));
    	hash.add(4, new Pessoa("Alisson", 26, false));
    	hash.add(5, new Pessoa("Raissa", 21, true));
        
        try {
            // Cria uma lista "dados" Stream a partir do hash, sendo possível utilizar funções do tipo "filter", "map" e "collect"
            List<String> dados = hash.stream()

                // Faz um filtro para apenas pessoas maiores de 17 anos e que são ex aprendizes
                .filter(p -> p.getAge() > 17)
                .filter(p -> p.isExApprentice())

                // Usa o "map" para pegar o nome de todas as pessoas que atendem aos requisitos que filtro, transforma a coleção de "Pessoas" em uma coleção de "String"
                .map(p -> p.getNome())

                // Coleta os resultados filtrados e mapeados em uma lista do collect
                .collect();

            // Imprime cada valor dentro da lista "dados", pegando o tamanho dela pelo "get.size()"
            for(int i = 0; i < dados.getSize(); ++i)
            {
                System.out.print("\n" + dados.get(i));
            }
        } catch (IteratorException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
