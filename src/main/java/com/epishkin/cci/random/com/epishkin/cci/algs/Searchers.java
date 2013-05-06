package com.epishkin.cci.random.com.epishkin.cci.algs;

import java.util.List;

// Big-O Cheat Sheet - http://bigocheatsheet.com
public class Searchers {
    // O(n)
    public int linearSearch(List<Integer> list, Integer value) {
        for (int i = 0; i < list.size(); i++) {
            Integer element = list.get(i);
            if (element.equals(value)) {
                return i;
            }
        }

        return -1;
    }

    // O(log n)
    public int binarySearch(List<Integer> list, Integer value) {
        int min = 0;
        int max = list.size() - 1;

        while (min <= max) {
            int index = min + (max - min) / 2;

            Integer element = list.get(index);
            if (element < value) {
                min = index + 1;
            } else if (element > value) {
                max = index - 1;
            } else {
                return index;
            }
        }

        return -1;
    }
}
