package com.geekidentity.leetcode.offerII;

/**
 * 数学
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * 摩尔投票法
 *
 * 核心就是对拼消耗。玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。
 * 最后还有人活下来的国家就是胜利。那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），
 * 或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。最后能剩下的必定是自己人。
 *
 * 假设有一个擂台，有一组人，每个人有编号，相同编号为一组，依次上场，没人时上去的便是擂主（x），若有人，编号相同则继续站着（人数+1），
 * 若不同，假设每个人战斗力相同，都同归于尽，则人数-1；那么到最后站着的肯定是人数占绝对优势的那一组啦~
 */
public class Offer39MajorityElement {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) { //每一个人都要出来挑战
            if (votes == 0) { //擂台上没人 选一个出来当擂主 x就是擂主  votes就是人数
                x = num;
            }
            if (num == x) votes += 1; //如果是自己人就站着呗 如果不是 就有一个人同归于尽
            else votes -= 1;
        }
        return x;
    }
}
