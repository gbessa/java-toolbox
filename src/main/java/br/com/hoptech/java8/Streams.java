package br.com.hoptech.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

	List<Curso> cursos = new ArrayList<Curso>();
	cursos.add(new Curso("Python", 45));
	cursos.add(new Curso("JavaScript", 150));
	cursos.add(new Curso("Java 8", 113));
	cursos.add(new Curso("C", 55));
	
	cursos.sort(Comparator.comparing(Curso::getAlunos));
	
	cursos.forEach(System.out::println); // Aqui tem uma limitação, pois ele só conseguiria dar print no toString da classe.
	cursos.forEach(c -> System.out.println(c.getNome())); // Ou implementamos o toString ou fazemos com Lambda mesmo
	
	/* Ao invés de colocarem um monte de novos métodos na interface List, foi implementado o stream(),
	que retorna um stream de dados e no stream temos muitas novas opções de métodos
	o filter não vai alterar a lista (imutabilidade), apenas o stream. Pois isso é que trabalhamos com o stream, após filtrá-lo
	O stream também tem vantagens sobre o for padrão em termos de concorrrência e paralelismo */
	
	//FILTER
	cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));;
	
	//MAP
	cursos.stream().map(c -> c.getAlunos()).forEach(System.out::println);
	
	//REDUCE e ENCADEAÇÃO (Vantagem também do stream é que podemos encadear - Interface Fluente)
	Optional<Integer> totalFinal = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.map(c -> c.getAlunos())
		.reduce((num,total) -> num+total);
	System.out.println("totalFinal: " + totalFinal.get());
	
	//OUTROS
	Integer sum = cursos.stream()
        	.mapToInt(c -> c.getAlunos())
        	.sum();
        System.out.println("Total de alunos: " + sum);
        
        OptionalDouble media = cursos.stream()
		.mapToInt(c -> c.getAlunos())
		.average();
        System.out.println("Média de Alunos por turma: " + media.getAsDouble());
        
        
        //O Optional tb é uma classe nova do Java 8, para trabalharmos melhor com o Null
        Optional<Curso> curso = cursos.stream()
        	.filter(c -> c.getAlunos() >= 100)
        	.findAny();
        curso.ifPresent(System.out::println); //Nesse caso, só printa se tiver o curso, evitando o nullpointer exception
        
        //Como estamos alterando a Stream e não a lista, Temos que coletar os elementos da Stream para colocar em uma lista
        cursos = cursos.stream()
        	.filter(c -> c.getAlunos() >= 100)
        	.collect(Collectors.toList());
        System.out.println(cursos);
        
        //Gerando um HashMap a partir de uma lista de objetos
        Map<String, Integer> mapa = cursos.stream()
        	.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
        System.out.println(mapa);
        
        //Paralelismo - Dependendo do caso e tamanho da lista, o paralelismo pode dar mais performance
        cursos = cursos.parallelStream()
        	.filter(c -> c.getAlunos() >= 100)
        	.collect(Collectors.toList());
        System.out.println("Paralelizada: " + cursos);
        
    }

}

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}
