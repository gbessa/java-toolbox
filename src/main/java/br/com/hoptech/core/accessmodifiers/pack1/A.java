package br.com.hoptech.core.accessmodifiers.pack1;

/**
 * - private:
 *      só é acessado dentro da classe
 * - public
 *      publico
 * - Default
 *      visível dentro do package
 * - protected
 *      visível dentro do package
 *      visível fora do package se for de uma subclasse
 *
 */
public class A {
    private String attAPrivate;
    public String attAPublic;
    String attADefault;
    protected String attAProtected;
}
