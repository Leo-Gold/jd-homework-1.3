package homework.netology;

import java.util.Random;

public class GenerateData {
    private final int health;
    private final int weapons;
    private final int lvl;
    private final double distance;

    public GenerateData() {
        Random random = new Random();
        health = random.nextInt(100000);
        weapons = random.nextInt(100);
        lvl = random.nextInt(100);
        distance = 1000 * random.nextDouble();
    }

    public GameProgress newGameProgress() {
        return new GameProgress(health, weapons, lvl, distance);
    }
}
