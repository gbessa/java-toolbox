package br.com.hoptech.dbf;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import org.jamel.dbf.processor.DbfProcessor;
import org.jamel.dbf.processor.DbfRowMapper;
import org.jamel.dbf.utils.DbfUtils;

public class ReadDBFFile {

	private final static String dbfFilePath = "C:\\gbessa\\Migracao Sistema AG\\agec.dbf";
	private final static String txtFilePath = "C:\\gbessa\\Migracao Sistema AG\\agec_mig.txt";
	
	public static void main(String[] args) {
		
		
		//DBF FILE INFO
        String dbfInfo = DbfProcessor.readDbfInfo(new File(dbfFilePath));
        System.out.println(dbfInfo);
        
        //CREATE COLLECTION FROM DBF FILE
        File dbf = new File(dbfFilePath);
        List<GuiaEntrada> guias = DbfProcessor.loadData(dbf, new DbfRowMapper<GuiaEntrada>() {
            @Override
            public GuiaEntrada mapRow(Object[] row) {
                // here we can change string encoding if it is needed
                String numGec = new String(DbfUtils.trimLeftSpaces((byte[]) row[0]));
                String codDep = new String(DbfUtils.trimLeftSpaces((byte[]) row[2]));

                return new GuiaEntrada(numGec, codDep);
            }
        });

        System.out.println(guias.size());
        //System.out.println("Guias de Entrada: " + guias);
        
        dbfToTxt();
        
    }
	
	public static void dbfToTxt() {
        DbfProcessor.writeToTxtFile(
                new File(dbfFilePath),
                new File(txtFilePath),
                Charset.forName("windows-1252"));
	}
        
}
