package com.epishkin.cci.algs;

import java.util.ArrayList;
import java.util.List;

public class Sorters {
    // O(n^2)
    public List<Integer> selectSort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        List<Integer> result = new ArrayList<Integer>(list);
        for (int i = 0; i < result.size(); i++) {
            Integer min = Integer.MAX_VALUE;
            int replaceIndex = -1;
            for (int j = i; j < result.size(); j++) {
                Integer element = result.get(j);
                if (element < min) {
                    replaceIndex = j;
                    min = element;
                }
            }

            if (replaceIndex != -1) {
                Integer buf = result.get(i);
                result.set(i, min);
                result.set(replaceIndex, buf);
            }
        }

        return result;
    }

    // O(n log n)
    public List<Integer> quickSort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        Integer pivot = list.get(0);
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> more = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            Integer element = list.get(i);
            if (element <= pivot) {
                less.add(element);
            } else {
                more.add(element);
            }
        }

        return concatenate(quickSort(less), pivot, quickSort(more));
    }

    private List<Integer> concatenate(List<Integer> less, Integer pivot, List<Integer> more) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(less);
        result.add(pivot);
        result.addAll(more);

        return result;
    }

    //todo implement in place quick sort

    //todo implement merge sort

    interface Sorter {
        List<Integer> sort(List<Integer> list);
    }

    static class SelectSorter implements Sorter {
        public List<Integer> sort(List<Integer> list) {
            return new Sorters().selectSort(list);
        }
    }

    static class QuickSorter implements Sorter {
        public List<Integer> sort(List<Integer> list) {
            return new Sorters().quickSort(list);
        }
    }
}
