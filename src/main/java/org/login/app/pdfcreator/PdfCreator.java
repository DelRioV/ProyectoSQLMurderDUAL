package org.login.app.pdfcreator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class PdfCreator {

    public void createPDF(String fileName, String text, String user, String password) throws IOException, DocumentException, URISyntaxException {

        Path path = Paths.get(ClassLoader.getSystemResource("SQLIcon.png").toURI());

        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
//        How to encrypt(1st way) before his creation
        pdfWriter.setEncryption(user.getBytes(), password.getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256);

        document.open();
        Paragraph paragraph = createParagraph(text);
        Image image = createImage(path);

        document.add(paragraph);
        document.add(image);
        document.close();

    }

    private Image createImage(Path path) throws BadElementException, IOException {
        Image image = Image.getInstance(path.toAbsolutePath().toString());
        image.scalePercent(40);
        return image;
    }

    private Paragraph createParagraph(String text) {
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setSpacingAfter(25f);
        return paragraph;
    }

}