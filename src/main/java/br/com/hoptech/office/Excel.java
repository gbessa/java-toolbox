package br.com.hoptech.office;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.json.JSONArray;

public class Excel {

	public static void main(String[] args) {
		
		String PATH = System.getProperty("user.home") + "/Gescomex2";
		if (createDirectory(PATH) == false) {
			return;
		}
		
		Date timeStamp = new Date();          
		final String DEST = PATH + "/" + String.valueOf(timeStamp.getTime()) + ".xls";
        
		try {

			
			String jsonHeader = "[\"Serie\", \"Num\", \"Transporte\", \"UF Origem\", \"Cidade Origem\", \"UF Destino\", \"Cidade Destino\", \"SubUrbano\", \"Veículo\", \"Dia\", \"Mês\", \"Ano\", \"Fiscal\", \"Segurado\", \"Espec.\", \"Próprio\", \"Qtd Sacas\", \"Contrato\"]";
			String jsonFormatoColunas = "[\"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"STRING\", \"DOUBLE\", \"DOUBLE\", \"STRING\", \"STRING\", \"INTEGER\", \"STRING\"]";
			String tableBodyContent = "[[\"22\",\"011514\",\"TERRESTRE\",\"MG\",\"VARGINHA\",\"RJ\",\"SAO JOAO DO MERITI\",\"URBANO\",\"HMT-0202\",\"2\",\"10\",\"2019\",\"9.202,50\",\"2.258,95\",\"Café Cru em Grão\",\"Terceirizado\",\"50,00\",\"545/1\"]]";
			
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheetDados = workbook.createSheet("Dados");

			Set<HSSFFont> multiColorFonts = geraFontes(workbook);
			
			JSONArray tableHeader = new JSONArray(jsonHeader);
			
			JSONArray tableFormatoColunas = new JSONArray(jsonFormatoColunas);
			
			tableBodyContent = tableBodyContent.replace("\n", "").replace("\r", ""); //Limpa os LineBreaks																				
			JSONArray tableBody = new JSONArray(tableBodyContent);
			
			NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR" ));
			
			int rownum = 0;
			String changeColorTrigger = "";
            Iterator<HSSFFont> fontsIterator = multiColorFonts.iterator();
			HSSFFont lineFont = null;// = fontsIterator.next();
			
			HSSFDataFormat hssfDataFormat = workbook.createDataFormat(); 
			
			HSSFCellStyle baseStyleInteger = null;
			HSSFCellStyle baseStyleDouble = null;
			HSSFCellStyle baseStyleString = null;
					
			for (int i = 0; i < tableBody.length(); i++) {
				Row row = sheetDados.createRow(rownum++);
				JSONArray line = tableBody.getJSONArray(i);
				
				if (!line.get(17).equals(changeColorTrigger)) {
					if (!fontsIterator.hasNext()) {
						fontsIterator = multiColorFonts.iterator();
					}
					lineFont = fontsIterator.next();
					changeColorTrigger = line.get(17).toString();

					baseStyleInteger = workbook.createCellStyle();
					baseStyleInteger.setDataFormat(hssfDataFormat.getFormat("#,##0"));
					baseStyleInteger.setFont(lineFont);
					
					baseStyleDouble = workbook.createCellStyle();
					baseStyleDouble.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					baseStyleDouble.setFont(lineFont);
					
					baseStyleString = workbook.createCellStyle();
					baseStyleString.setAlignment(HorizontalAlignment.CENTER);
					baseStyleString.setFont(lineFont);
				}
				
				System.out.println(line.join("--"));
				
				
				for (int j = 0; j < tableHeader.length(); j++) {
					Cell cell = row.createCell(j);
					if (tableFormatoColunas.getString(j).equals("INTEGER")) {
						int valorCellInt = nf.parse(line.getString(j)).intValue();
						cell.setCellValue(valorCellInt);
						cell.setCellStyle(baseStyleInteger);
					} else if (tableFormatoColunas.getString(j).equals("DOUBLE")) {
						double valorCellDbl = 0.00;
						valorCellDbl = nf.parse(line.getString(j)).doubleValue();
						cell.setCellValue(valorCellDbl);
						cell.setCellStyle(baseStyleDouble);
					} else if (tableFormatoColunas.getString(j).equals("STRING")) {
						cell.setCellValue(line.getString(j));	
						cell.setCellStyle(baseStyleString);
					} else {
						System.out.println("Tipo nao esperado");
					}
				}

			}

			autoSizeColumns(sheetDados, tableHeader);
			
			FileOutputStream out = new FileOutputStream(new File(DEST));
			workbook.write(out);
			out.close();
			System.out.println("Arquivo Excel criado com sucesso!");

			//Abre Arquivo
			File file = new File(DEST);
		    if (file.toString().endsWith(".xls")) { 
		        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
		    } else {
		        Desktop desktop = Desktop.getDesktop();
		        desktop.open(file);
		    }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
			JOptionPane.showMessageDialog(null,"Arquivo não encontrado!\n" + DEST, "ERRO", JOptionPane.ERROR_MESSAGE);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
			JOptionPane.showMessageDialog(null,"Erro na edição do arquivo!\n" + DEST, "ERRO", JOptionPane.ERROR_MESSAGE);
		} 
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static boolean createDirectory(String path) {
        File files = new File(path);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
                JOptionPane.showMessageDialog(null,"Falha ao criar a pasta.\n" + path, "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
	}
	
	private static void autoSizeColumns(HSSFSheet sheetDados, JSONArray tableHeader) {
		for (int i = 0; i < tableHeader.length(); i++) {
			sheetDados.autoSizeColumn(i);
		}
	}
	
	private static Set<HSSFFont> geraFontes(HSSFWorkbook workbook) {
		
		short[] colors = new short[]{
				IndexedColors.BLACK.getIndex(),
				IndexedColors.RED.getIndex(),
				IndexedColors.BLUE.getIndex(),
				IndexedColors.BROWN.getIndex(),
				IndexedColors.GREEN.getIndex()
		};
		
		Set<HSSFFont> multiColorFonts = new HashSet<HSSFFont>();
		for (short color : colors) {
			HSSFFont font = workbook.createFont();
			font.setColor(color);
			multiColorFonts.add(font);
		}
		return multiColorFonts;
	}
}
