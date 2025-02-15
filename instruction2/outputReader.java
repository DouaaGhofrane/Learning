import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class outputReader {
    public static void main(String[] arg) {

        String path2 = "/home/kali/DebuggerJava/test2.csv";
        String path1 = "/home/kali/DebuggerJava/test1.csv";
        boolean result;
        String line;

        for (int i = 1; i <= 5; i++) { // Boucle de 1 à 5
            System.out.println("\nChecking for i=" + i);

            // Lire test2.csv et vérifier si la ligne est "P"
            try (BufferedReader reader2 = new BufferedReader(new FileReader(path2))) {
                while ((line = reader2.readLine()) != null) {
                    result = line.trim().equals("P");
                    System.out.println("Line matches P: " + result);
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + path2);
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Lire test1.csv et vérifier si i est présent dans une ligne
            try (BufferedReader reader1 = new BufferedReader(new FileReader(path1))) {
                while ((line = reader1.readLine()) != null) {
                    String[] values = line.split(",\\s*"); // Découper les valeurs
                    boolean test = Arrays.asList(values).contains(String.valueOf(i));
                    System.out.println("i=" + i + " exists: " + test);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
