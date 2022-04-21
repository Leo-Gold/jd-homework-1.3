package homework.netology;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Reader {
    String urlBat;

    public Reader(String url) {
        this.urlBat = url + ".bat";
    }

    public void openProgress() {
        GameProgress gameProgress = null;
        try (
                FileInputStream fis = new FileInputStream(urlBat);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(gameProgress);
    }
}
