package com.epishkin.cci.random.com.epishkin.cci.algs;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortersTest {
    private Sorters sorters;

    private List<Integer> list;
    private List<Integer> singleElementlist;
    private List<Integer> emptyList;

    private List<Integer> sortedList;

    @BeforeMethod
    public void setUp() throws Exception {
        sorters = new Sorters();

        list = Arrays.asList(9, 3, 10, 1, 5);
        singleElementlist = Arrays.asList(42);
        emptyList = Collections.emptyList();

        sortedList = new ArrayList<Integer>(list);
        Collections.sort(sortedList);
    }

    @Test(groups = "unit")
    public void testSelectSort_empty() {
        assertEquals(sorters.selectSort(emptyList), emptyList);
    }

    @Test(groups = "unit")
    public void testSelectSort_singleElement() {
        assertEquals(sorters.selectSort(singleElementlist), singleElementlist);
    }

    @Test(groups = "unit")
    public void testSelectSort() {
        assertEquals(sorters.selectSort(list), sortedList);
    }

    @Test(groups = "unit")
    public void testQuickSort_empty() {
        assertEquals(sorters.quickSort(emptyList), emptyList);
    }

    @Test(groups = "unit")
    public void testQuickSort_singleElement() {
        assertEquals(sorters.quickSort(singleElementlist), singleElementlist);
    }

    @Test(groups = "unit")
    public void testQuickSort() {
        assertEquals(sorters.quickSort(list), sortedList);
    }

}
