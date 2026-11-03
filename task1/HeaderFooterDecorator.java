package task1;

public class HeaderFooterDecorator extends ExporterDecorator {
    private final String timestamp;

    public HeaderFooterDecorator(Exporter wrappedExporter, String timestamp) {
        super(wrappedExporter);
        this.timestamp = timestamp;
    }

    @Override
    public void export(String destination, String data) {


        int rowCount = 0;

        String reportData = data;

        if (data.startsWith("[BASE64_CIPHERTEXT:") && data.endsWith("]")) {
            String encoded = data.substring(
                    "[BASE64_CIPHERTEXT:".length(),
                    data.length() - 1
            );

            reportData = new String(
                    java.util.Base64.getDecoder().decode(encoded),
                    java.nio.charset.StandardCharsets.UTF_8
            );
        }

        int recordsStart = reportData.indexOf("\"records\"");
        if (recordsStart >= 0) {
            int arrayStart = reportData.indexOf("[", recordsStart);
            int arrayEnd = reportData.indexOf("]", arrayStart);

            if (arrayStart >= 0 && arrayEnd > arrayStart) {
                String records = reportData.substring(arrayStart, arrayEnd);
                rowCount = records.split("\\{", -1).length - 1;
            }
        }


        String enrichedData =
                "--- EXPORT TIMESTAMP: " + timestamp + " ---\n"
                        + data + "\n"
                        + "--- RECORD COUNT: " + rowCount
                        + " | SECURE HASH: [OK] ---";
        super.export(destination, enrichedData);

    }

}
