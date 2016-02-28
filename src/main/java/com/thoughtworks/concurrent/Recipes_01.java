package com.thoughtworks.concurrent;

import static java.lang.String.format;

///
// 寄存器/缓存/主内存 同步
// 重排序
///
public class Recipes_01 {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread thread2 = new Thread(() -> {
            b = 1;
            y = a;
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(format("(%d, %d)", x, y));
    }
}
