package com.thoughtworks.concurrent;

import java.util.concurrent.ExecutorService;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class Recipes_06 {
    public static void main(String[] args) {

        ExecutorService executorService = newFixedThreadPool(2, task -> {
            Thread thread = new Thread(task);
            thread.setUncaughtExceptionHandler((t, e) -> out.println(format("The exception message is %s", e.getMessage())));
            return thread;
        });

        executorService.execute(() -> {
            throw new RuntimeException("Error!");
        });

        executorService.shutdown();
    }
}
