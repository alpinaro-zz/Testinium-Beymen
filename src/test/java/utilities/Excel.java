package utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Excel {

    private static final String PATH_RESOURCES = "src/test/resources/";
    private static String file;
    private static FileInputStream fis;
    private static FileOutputStream fos;

    public static Workbook workbook;

    public static void open(String fileName) {

        file = fileName;
        try {
            fis = new FileInputStream(PATH_RESOURCES + fileName);
            workbook = WorkbookFactory.create(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write() {

        try {
            fos = new FileOutputStream(PATH_RESOURCES + file);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close() {

        try {
            workbook.close();
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}