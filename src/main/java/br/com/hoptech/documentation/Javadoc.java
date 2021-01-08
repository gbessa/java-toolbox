package br.com.hoptech.documentation;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_MONTH;

// This is a single line comment

/*
 * This is a regular multi-line comment
 */

/**
 * This is a Javadoc
 * Javadoc style comments may contain HTML tags as well.
 * https://www.baeldung.com/javadoc
 *
 *
 * Please see the {@link br.com.hoptech.documentation.Javadoc} class for true identity
 * @author gbessa
 */
public class Javadoc {

    /**
     *
     * @param a
     * @return
     */
    public int method(int a) {
        int b = 1;
        return b;
    }

    public Javadoc() {}
    public Javadoc(String withParameter) {
    }

    /**
     * Retorna a data enviada por parametro com a adição dos dias desejado
     * 	a Data pode estar no futuro (dias > 0) ou no passado (dias < 0)
     *
     * @param data
     * @param dias
     * @return
     */
    public static Date adicionarDias(Date data, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(DAY_OF_MONTH, dias);
        return calendar.getTime();
    }

}
