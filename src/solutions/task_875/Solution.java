package solutions.task_875;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats
 * k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElseThrow();
        int midle;
        while (left < right) {
            midle = (left + right) / 2;
            int count = 0;
            for (int pile : piles) {
                count += (pile + midle - 1) / midle;
            }
            if (count <= h) {
                right = midle;
            } else {
                left = midle + 1;
            }
        }
        return right;
    }
}