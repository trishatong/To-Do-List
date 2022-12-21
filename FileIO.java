import java.io.*;

public class FileIO {
    private static String fileName;

    public FileIO() {
    }

    public static void setFileName(String var0) {
        fileName = var0;
    }

    public static String importTextFromFile(String var0) {
        String var1 = "";
        try {
            BufferedReader var2 = new BufferedReader(new FileReader(var0));

            for(String var3 = var2.readLine(); var3 != null; var3 = var2.readLine()) {
                var1 = var1 + var3;
            }

            var2.close();
            return var1;
        } catch (IOException var4) {
            return null;
        }
    }
}
