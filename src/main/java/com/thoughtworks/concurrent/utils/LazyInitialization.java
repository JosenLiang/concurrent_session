package com.thoughtworks.concurrent.utils;

///
// 问题：
//  1. Thread 1 and Thread 2 都去 new Resource
//  2. 不安全发布
//
// new 对象：
// 1. 为实例的数据字段分配内存；
// 2. 初始化对象的附加字段（类型对象指针和同步块索引）
// 3. 调用类型的实例构造器来设置对象的初始状态
// 4. 修改引用字段的值
///
public class LazyInitialization {
    public static class Resource {
        private String name;

        public Resource() {
            this.name = "DEMO";
        }

        public String getName() {
            return name;
        }
    }

    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }
}