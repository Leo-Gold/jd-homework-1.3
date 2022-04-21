package homework.netology;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Created {
    private final File file;
    private final static StringBuilder sblog = new StringBuilder();

    public Created(File file) {
        this.file = file;
    }

    public File createdDir(){
        if(file.mkdir()){
            sblog
                    .append("Каталог ")
                    .append(file.getName())
                    .append(" создан успешно. \n");
        } else if(file.isDirectory()) {
            sblog
                    .append("Каталог ")
                    .append(file.getName())
                    .append(" уже существует. \n");
        }
        return file;
    }

    public File createdFile() {
        try {
            if(file.createNewFile()){
                sblog
                        .append("Файл ")
                        .append(file.getName())
                        .append(" создан успешно. \n");
            } else if (file.isFile()) {
                sblog
                        .append("Файл ")
                        .append(file.getName())
                        .append(" уже существует. \n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void saveLogFile() {
        String log = String.valueOf(sblog);
        sblog.delete(0, sblog.length());
        byte[] saveLog = log.getBytes();
        try (FileOutputStream result = new FileOutputStream(file)){
            result.write(saveLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
