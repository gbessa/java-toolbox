package br.com.hoptech.formatting;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsefa.Serializer;
import net.sf.jsefa.flr.FlrIOFactory;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Date;

/*
    http://jsefa.sourceforge.net/quick-tutorial.html
    https://github.com/Manmay/JSefa/tree/master/samples/flr/employee/src/flr
 */
@Slf4j
public class TxtGenerator {
    public static void main(String[] args) {

        Company company1 = new Company("Hoptech Ltda", new Date(), BigDecimal.valueOf(1.12));

        Serializer serializer = FlrIOFactory.createFactory(Company.class).createSerializer();
        StringWriter writer = new StringWriter();
        serializer.open(writer);
        serializer.write(company1);
        serializer.close(true);

        log.info("Result:");
        log.info(writer.toString());

    }

}


