package task07;

import java.nio.charset.StandardCharsets;

public class PdfConverter {
    public byte[] toPdf(String text) {
        byte[] bytes = ("%PDF-1.4\n" + text).getBytes(StandardCharsets.UTF_8);
        System.out.println("[PdfConverter] Converted to PDF (" + bytes.length + " bytes).");
        return bytes;
    }
}
