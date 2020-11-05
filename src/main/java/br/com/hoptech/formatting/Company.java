package br.com.hoptech.formatting;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;

import java.math.BigDecimal;
import java.util.Date;

@FlrDataType
public class Company {
    public Company(String name, Date date, BigDecimal value){
        this.name = name;
        this.date = date;
        this.value = value;
    }
    public Company() {}

    @FlrField(pos = 1, length = 6)
    private static final String REGNUM = "REG001";

    @FlrField(pos = 2, length = 20, align = Align.LEFT, padCharacter = '_')
    private String name;

    @FlrField(pos = 3, length = 8, align = Align.RIGHT, padCharacter = '0', format = "yyyyMMdd")
    private Date date;

    @FlrField(pos = 4, length = 10, align = Align.RIGHT, padCharacter = '.')
    private BigDecimal value;
}
