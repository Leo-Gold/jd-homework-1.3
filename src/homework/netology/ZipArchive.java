package homework.netology;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchive {
    private final String urlzip;
    private final String urlbat;

    public ZipArchive(String url) {
        urlbat = url + ".bat";
        urlzip = url + ".zip";
    }

    public void zipFiles() {
        try (
                FileOutputStream fos = new FileOutputStream(urlzip);
                ZipOutputStream zos = new ZipOutputStream(fos);
                FileInputStream fis = new FileInputStream(urlbat);
        ) {
            String name = new File(urlbat).getName();
            ZipEntry entry = new ZipEntry(name);
            zos.putNextEntry(entry);

            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

            zos.write(bytes);
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFiles() {
        File delete = new File(urlbat);
        if (delete.delete()) {
            System.out.println("файл " + delete.getName() + " удалён");
        }
    }
}
