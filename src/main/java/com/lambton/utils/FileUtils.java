package com.lambton.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.lambton.models.Customer;
import com.lambton.models.Order;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileUtils {
    public static void writeToPdf(String text, String fileName) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(new File(fileName)));
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
    public static String readFromJSON(String fileName) {
        String output = "";
        try {
            JsonReader reader = new JsonReader(new FileReader(fileName));
            Gson gson = new Gson();
            ArrayList<Order> order = gson.fromJson(reader, new TypeToken<ArrayList<Order>>() {}.getType());
            for (Order c: order) {
                c.setShippingType(c.getShippingInfo().getShippingType());
                output += c.display();
            }
            return output;
        } catch (IOException e) {
            e.printStackTrace();
            return output;
        }
    }
}

