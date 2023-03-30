import java.util.ArrayList;
import java.util.List;

public class CustomCSVParser {
    public static String[] parseLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '"') {
                insideQuotes = !insideQuotes;
            } else if (currentChar == ',' && !insideQuotes) {
                fields.add(field.toString());
                field.setLength(0); // Clear the field
            } else {
                field.append(currentChar);
            }
        }
        fields.add(field.toString()); // Add the last field

        return fields.toArray(new String[0]);
    }
}
