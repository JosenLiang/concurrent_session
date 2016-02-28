package com.thoughtworks.concurrent;

import com.thoughtworks.concurrent.utils.LazyInitialization;

import static java.lang.System.out;

public class Recipes_03 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> out.println(LazyInitialization.getInstance().getName()));

        Thread thread2 = new Thread(() -> out.println(LazyInitialization.getInstance().getName()));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
