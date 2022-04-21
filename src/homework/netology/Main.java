package homework.netology;

import java.io.File;

public class Main {
    public static int countData = 3;
    public static GameProgress[] gameProgress = new GameProgress[countData];

    public static void main (String[] args) {
        install();
        generateData();
        workData();
    }

    public static void install() {
        File games = new Created(new File("Games")).createdDir();
        File src = new Created(new File(games,"src")).createdDir();
        File main = new Created(new File(src, "main")).createdDir();
        File mainJava = new Created(new File(main, "Main.java")).createdFile();
        File utilsJava = new Created(new File(main, "Utils.java")).createdFile();

        File test = new Created(new File(src, "test")).createdDir();

        File res = new Created(new File(games, "res")).createdDir();
        File savegames = new Created(new File(games, "savegames")).createdDir();
        File drawables = new Created(new File(res, "drawables")).createdDir();
        File vectors = new Created(new File(res, "vectors")).createdDir();
        File icons = new Created(new File(res, "icons")).createdDir();

        File temp = new Created(new File(games, "temp")).createdDir();
        File tempTxt = new Created(new File(temp, "temp.txt")).createdFile();

        new Created(tempTxt).saveLogFile();
    }

    public static void generateData() {
        for (int i = 0; i < countData; i++) {
            gameProgress[i] = new GenerateData().newGameProgress();
        }
    }

    public static void workData(){
        for (int i = 0; i < countData; i++) {
            String url = "Games/savegames/save" + i;
            // сохранение данных
            new SaveGame(url, gameProgress[i]).save();
            // архивирование данных
            new ZipArchive(url).zipFiles();
            // удаление заархивированных файлов
            new ZipArchive(url).deleteFiles();
            // разархивирование файлов
            new ZipArchive(url).openZip();
            // чтение файлов
            new Reader(url).openProgress();
        }
    }
}
