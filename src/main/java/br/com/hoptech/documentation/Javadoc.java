package br.com.hoptech.documentation;

import java.net.MalformedURLException;
import java.net.URL;

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

}
