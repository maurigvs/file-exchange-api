package br.com.maurigvs.fileexchange.csv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import br.com.maurigvs.fileexchange.tutorial.Tutorial;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

public class CSVHelper {

    private CSVHelper() {}

    public static ByteArrayInputStream tutorialsToCSV(List<Tutorial> tutorials) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
            CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Tutorial tutorial : tutorials) {
                List<String> data = Arrays.asList(
                        String.valueOf(tutorial.getId()),
                        tutorial.getTitle(),
                        tutorial.getDescription(),
                        String.valueOf(tutorial.isPublished())
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
