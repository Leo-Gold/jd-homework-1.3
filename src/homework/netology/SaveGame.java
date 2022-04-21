package homework.netology;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
    private final String urlbat;
    private final GameProgress gameProgress;

    public SaveGame(String url, GameProgress gameProgress) {
        urlbat = url + ".bat";
        this.gameProgress = gameProgress;
    }

    public void save() {
        try (
                FileOutputStream fos = new FileOutputStream(urlbat);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(gameProgress);
            String name = new File(urlbat).getName();
            System.out.println("файл " + name + " сохранён");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


