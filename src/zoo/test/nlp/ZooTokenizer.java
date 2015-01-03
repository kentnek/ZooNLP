package zoo.test.nlp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * [Description]
 * <p/>
 * Created on Jan 03, 2015.
 *
 * @author Kent
 */

public class ZooTokenizer {

    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    static public final String PATTERN = String.format(WITH_DELIMITER, "[\\p{Punct}\\s]+");

    public static void main(String[] args) {
        String input = args[0];
        String output = args[1];

        try (
                BufferedReader reader = new BufferedReader(new FileReader(input));
                BufferedWriter writer = new BufferedWriter(new FileWriter(output))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String tokens[] = line.split(PATTERN);

                for (String token : tokens) {
                    if (token.trim().length() == 0) continue;
                    writer.write(token + "\tO");
                    writer.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
