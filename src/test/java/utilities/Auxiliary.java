package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Auxiliary {

    private static final String PATH_OUTPUT = "src/test/output/";

    // Waits for the seconds
    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Returns current date and time
    protected static String datetime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        LocalDateTime ldt = LocalDateTime.now();
        String datetime = dtf.format(ldt);

        return datetime;
    }

    // Writes the data into an output file with the specified name
    public static void writeOutputTXT(String fileName, String data) {

        String path = PATH_OUTPUT + fileName;

        writeTXT(path, data);
    }

    // Writes the data into a file at the specified path
    protected static void writeTXT(String path, String data) {

        FileOutputStream outputStream = null;

        byte[] dataByte = data.getBytes();

        try {
            outputStream = new FileOutputStream(path);
            outputStream.write(dataByte);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}