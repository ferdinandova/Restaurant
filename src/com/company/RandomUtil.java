package com.company;

import java.util.Random;

public class RandomUtil {
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int getRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
