package com.epishkin.cci.random.com.epishkin.cci.algs;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortersTest {
    private List<Integer> list;
    private List<Integer> singleElementList;
    private List<Integer> emptyList;

    private List<Integer> sortedList;

    @BeforeMethod
    public void setUp() throws Exception {
        list = Arrays.asList(9, 3, 10, 1, 5);
        singleElementList = Arrays.asList(42);
        emptyList = Collections.emptyList();

        sortedList = new ArrayList<Integer>(list);
        Collections.sort(sortedList);
    }

    @Test(groups = "unit", dataProvider = "sorters")
    public void testSort(Sorters.Sorter sorter) {
        testSort_empty(sorter);
        testSort_singleElement(sorter);

        assertEquals(sorter.sort(list), sortedList);
    }

    private void testSort_empty(Sorters.Sorter sorter) {
        assertEquals(sorter.sort(emptyList), emptyList);
    }

    private void testSort_singleElement(Sorters.Sorter sorter) {
        assertEquals(sorter.sort(singleElementList), singleElementList);
    }

    @DataProvider(name = "sorters")
    public Object[][] sorters() {
        return new Object[][] {
                {new Sorters.SelectSorter()},
                {new Sorters.QuickSorter()}
        };
    }
}
