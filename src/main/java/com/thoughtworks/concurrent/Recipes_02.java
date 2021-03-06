package com.thoughtworks.concurrent;

import static java.lang.String.format;

///
// 程序顺序规则: 一个线程中的每个操作,happens- before于该线程中的任意后续操作;
// 监视器锁规则：解锁之前的所有操作,happens- before加锁之后的所有操作；
// volatile变量规则：对一个volatile域的写操作，happens－before于任意后续对 这个volatile域的读操作;
// 传递性规则:如果A happens- before B,且B happens- before C,那么 A happens- before C 。
///
public class Recipes_02 {
    static Object lock = new Object();
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            a = 1;
            synchronized (lock) {
                x = b;
            }
        });

        Thread thread2 = new Thread(() -> {
            b = 1;
            synchronized (lock) {
                y = a;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(format("(%d, %d)", x, y));
    }
}
