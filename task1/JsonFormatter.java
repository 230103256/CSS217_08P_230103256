package task1;

import static jdk.internal.icu.impl.Utility.escape;

public class JsonFormatter implements ReportFormatter {

    private String escape(String value) {
        if (value == null) return "null";

        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    @Override
    public String format(String title, String[] headers, String[][] rows) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n \"report\": \"").append(title).append("\",\n \"records\": [\n");
        for (int i = 0; i < rows.length; i++) {
            sb.append(" {");
            for (int j = 0; j < headers.length; j++) {
                sb.append("\"").append(escape(headers[j])).append("\": \"").append(escape(rows[i][j])).append("\"");
                if (j < headers.length - 1) sb.append(", ");
            }
            sb.append("}").append(i < rows.length - 1 ? ",\n" : "\n");
        }
        sb.append(" ]\n}");
        return sb.toString();
    }
}
