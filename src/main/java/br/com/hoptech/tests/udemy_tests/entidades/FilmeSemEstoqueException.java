package br.com.hoptech.tests.udemy_tests.entidades;

public class FilmeSemEstoqueException extends RuntimeException{
    public FilmeSemEstoqueException(String message) {
        super(message);
    }
}
