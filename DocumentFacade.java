package task07;

public class DocumentFacade {
    private final SpellChecker spellChecker;
    private final PageFormatter formatter;
    private final PdfConverter pdfConverter;
    private final PrinterSpooler spooler;

    public DocumentFacade(SpellChecker spellChecker, PageFormatter formatter,
                          PdfConverter pdfConverter, PrinterSpooler spooler) {
        this.spellChecker = spellChecker;
        this.formatter = formatter;
        this.pdfConverter = pdfConverter;
        this.spooler = spooler;
    }

    public void printCleanDocument(String text) {
        System.out.println("=== Printing document ===");
        String clean = spellChecker.check(text);
        String formatted = formatter.applyA4Margins(clean);
        spooler.queue(formatted);
    }

    public void exportAsPdf(String text, String fileName) {
        System.out.println("=== Exporting " + fileName + " ===");
        String clean = spellChecker.check(text);
        String formatted = formatter.applyA4Margins(clean);
        byte[] pdf = pdfConverter.toPdf(formatted);

        System.out.println("PDF ready: " + fileName + " (" + pdf.length + " bytes).");
    }
}
