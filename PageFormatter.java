package task07;

public class PageFormatter {
    public String applyA4Margins(String text) {
        System.out.println("[PageFormatter] A4 page, margins 2.5 cm applied.");
        return "[A4 | margins 2.5cm]\n" + text;
    }
}
