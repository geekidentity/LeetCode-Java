package com.geekidentity.leetcode.offerII;

/**
 * 设计模式
 * 剑指 Offer 02. 实现singleton模式
 */
public class Offer02Singleton {
    Offer02Singleton() {}

    public static Offer02Singleton instance() {
        return Nested.instance;
    }
}

class Nested {
    static Offer02Singleton instance = new Offer02Singleton();
}
