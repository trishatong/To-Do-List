import java.io.*;

public class FileIO {
    private static final String encounterIOExceptionError = "Encountered an IO exception for ";
    private static String fileName;

    public FileIO() {
    }

    public static void setFileName(String var0) {
        fileName = var0;
    }

    public static String importTextFromFile(String fileName) {
        String var1 = "";

        try {
            BufferedReader var2 = new BufferedReader(new FileReader(fileName));
            var1 = var2.readLine();
            var2.readLine();
            return var1;
        } catch (IOException var4) {
            return null;
        }
    }
}
