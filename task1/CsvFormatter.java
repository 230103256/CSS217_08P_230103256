package task1;

public class CsvFormatter implements ReportFormatter {

    private String quote(String value) {
        if (value == null) value = "";
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }

    @Override
    public String format(String title, String[] headers, String[][] rows) {
        StringBuilder sb = new StringBuilder();
        sb.append("# TITLE: ").append(title).append("\n");

        for (int i = 0; i < headers.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(quote(headers[i]));
        }
        sb.append("\n");


        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) sb.append(",");
                sb.append(quote(row[i]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
