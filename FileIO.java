import java.io.*;

public class FileIO {
    private static String fileName;

    public FileIO() {
    }

    public static void setFileName(String var0) {
        fileName = var0;
    }

    public static UserData readUserData() {
        try {
            FileInputStream var1 = new FileInputStream(fileName);
            ObjectInputStream var2 = new ObjectInputStream(var1);
            UserData var0 = (UserData) var2.readObject();
            var2.close();
            var1.close();
            return var0;
        } catch (IOException var3) {
            return null;
        } catch (ClassNotFoundException var4) {
            return null;
        }
    }

    public static void saveUserData(UserData var0) {
        try {
            FileOutputStream var1 = new FileOutputStream(fileName);
            ObjectOutputStream var2 = new ObjectOutputStream(var1);
            var2.writeObject(var0);
            var2.close();
            var1.close();
        } catch (IOException var3) {
            System.out.println("Encountered an IO exception for " + fileName + " while writing.");
            var3.printStackTrace();
        }

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
        } catch (FileNotFoundException var4) {
            return null;
        } catch (IOException var5) {
            return null;
        }
    }
}
