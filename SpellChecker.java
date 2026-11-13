package task07;

public class SpellChecker {
    public String check(String text) {
        String fixed = text.replace("teh", "the").replace("recieve", "receive").replace("adress", "address");
        if (!fixed.equals(text)) {
            System.out.println("[SpellChecker] Spelling errors fixed.");
        } else {
            System.out.println("[SpellChecker] No spelling errors found.");
        }
        return fixed;
    }
}
