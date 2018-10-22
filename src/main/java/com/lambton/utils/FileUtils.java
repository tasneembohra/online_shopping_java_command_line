package com.lambton.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class FileUtils {
    public static void writeToPdf(String text) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(new File("orders.pdf")));
            document.open();
            BufferedReader br = new BufferedReader(new StringReader(text));
            String line;
            Paragraph p;
            Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            boolean title = true;
            String oldLine = "";
            while ((line = br.readLine()) != null) {
                p = new Paragraph(line, title ? bold : normal);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                title = line.isEmpty();
                document.add(p);
                if (title && oldLine.contains("Total:"))
                    document.add( Chunk.NEWLINE );
                oldLine = line;
            }
            document.close();

        } catch (IOException | DocumentException ex) {
            ex.printStackTrace();
        }
    }
}

