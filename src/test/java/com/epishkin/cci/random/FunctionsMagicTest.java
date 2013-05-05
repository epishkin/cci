package com.epishkin.cci.random;

import org.junit.Assert;
import org.junit.Test;

public class FunctionsMagicTest extends FunctionsMagic {
    /*
	 * Exercise 1: Implement these functions under test so that each test passes.
	 * Here we simply check that application yields the expected results.
	 */

    @Test
    public void increment5I() {
        Integer i = increment5I.apply(5);
        Assert.assertEquals(10, i.intValue());

        Integer j = increment5I.apply(null);
        Assert.assertEquals(0,j.intValue());
    }

    @Test
    public void squareI() {
        Integer i = squareI.apply(5);
        Assert.assertEquals(25, i.intValue());

        Integer j = squareI.apply(null);
        Assert.assertEquals(0,j.intValue());
    }

	/*
	 * Exercise 2: Implement Function composition (f . g) so that tests on the composed functions pass.
	 */

    @Test
    public void add5AndSquareComposition() {
		/*
		 * Composition of increment51 and squareI, when applied to an integer argument, will first
		 * add 5 to the argument and the compute the sum's square.
		 */
        Function<Integer, Integer> plus5andSquare = increment5I.andThen(squareI);
        Integer x = plus5andSquare.apply(5);
        Assert.assertEquals(100, x.intValue());
    }

    @Test
    public void add5Composition() {
		/*
		 * Composition of increment51 with itself, when applied to an integer argument, will add 5
		 * to the argument and then add 5 to that sum.
		 */
        Function<Integer, Integer> add10 = increment5I.andThen(increment5I);
        Integer x = add10.apply(5);
        Assert.assertEquals(15, x.intValue());
    }
}
