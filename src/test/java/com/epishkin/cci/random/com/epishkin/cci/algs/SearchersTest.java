package com.epishkin.cci.random.com.epishkin.cci.algs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchersTest {

    private Searchers search;
    private List<Integer> list;
    private List<Integer> emptyList;

    @BeforeMethod
    public void setUp() throws Exception {
        search = new Searchers();

        list = Arrays.asList(1, 3, 5, 9, 10);
        emptyList = Collections.emptyList();
    }

    @Test(groups = "unit")
    public void testLinearSearch() throws Exception {
        assertEquals(search.linearSearch(list, 3), 1);
        assertEquals(search.linearSearch(list, 10), 4);

        assertEquals(search.linearSearch(list, 2), -1);
        assertEquals(search.linearSearch(emptyList, 2), -1);
    }

    @Test(groups = "unit")
    public void testBinarySearch() throws Exception {
        assertEquals(search.binarySearch(list, 3), 1);
        assertEquals(search.binarySearch(list, 10), 4);

        assertEquals(search.binarySearch(list, 2), -1);
        assertEquals(search.binarySearch(emptyList, 2), -1);
    }
}
