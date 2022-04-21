package homework.netology;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
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

    public void openZip() {
        try (
                FileInputStream fis = new FileInputStream(urlzip);
                ZipInputStream zis = new ZipInputStream(fis)
        ) {
                while (zis.getNextEntry() != null) {
                    FileOutputStream fos = new FileOutputStream(urlbat);
                    for (int i = zis.read(); i != -1 ; i = zis.read()) {
                        fos.write(i);
                    }
                    fos.flush();
                    zis.closeEntry();
                    fos.close();
            }
        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
