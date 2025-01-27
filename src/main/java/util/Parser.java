package util;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.Arrays;

public class Parser {
    private static CSVReader csvReader;

    public static String[][] makeTable(InputStream inputStream, int bound){
        String[][] table;
        try {
            CSVParser build = new CSVParserBuilder().withSeparator(';').build();
            csvReader =new CSVReaderBuilder(new InputStreamReader(inputStream))
                    .withCSVParser(build).build();
            table = new String[bound][];
            String[] buffer;
            for (int i = 0;(buffer = csvReader.readNext()) != null; i++){
                table[i] = buffer;
            }
            return table;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
