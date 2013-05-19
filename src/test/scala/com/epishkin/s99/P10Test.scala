/** ***********************************************************************
  *
  * SecondMarket Labs CONFIDENTIAL
  *
  * [2007] - [2013] SecondMarket Labs, LLC.
  * All Rights Reserved.
  *
  * NOTICE: All information contained herein is, and remains the property
  * of SecondMarket Labs, LLC. and its suppliers, if any. The intellectual and
  * technical concepts contained herein are proprietary to SecondMarket Labs, LLC.
  * and its suppliers and may be covered by U.S. and Foreign Patents,
  * patents in process, and are protected by trade secret and copyright law.
  * Dissemination of this information or reproduction of this material
  * is strictly forbidden unless prior written permission is obtained
  * from SecondMarket Labs, LLC.
  */
package com.epishkin.s99

import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers._

/**
 * http://aperiodic.net/phil/scala/s-99/
 */
class P10Test extends FunSuite {
  val list = List(1, 1, 2, 3, 5, 8)

  test("P01: Find the last element of a list.") {
    import P01._

    def testLength(f: List[Int] => Int) {
      f(list) must be(8)
      f(List(8)) must be(8)
      f(List(2, 8)) must be(8)

      evaluating {
        f(List())
      } must produce [NoSuchElementException]
    }

    testLength(last)
    testLength(lastInline)
    testLength(lastBuiltIn)
  }

  test("P02: Find the last but one element of a list.") {
    import P02._

    def testPenultimate(f: List[Int] => Int) {
      f(List(1, 1, 2, 3, 5, 8)) must be(5)
      f(List(5, 8)) must be(5)

      evaluating {
        f(List())
      } must produce [NoSuchElementException]

      evaluating {
        f(List(8))
      } must produce [NoSuchElementException]
    }

    testPenultimate(penultimate)
    testPenultimate(penultimateGeneric)
  }

  test("P03: Find the Kth element of a list.") {
    import P03._

    nth(2, list) must be (2)
    nthBuiltIn(2, list) must be (2)
  }

  test("P04: Find the number of elements of a list.") {
    import P04._

    length(List(1, 1, 2, 3, 5, 8)) must be(6)
    lengthTailRecursion(List(1, 1, 2, 3, 5, 8)) must be(6)

    lengthFold(List(1, 1, 2, 3, 5, 8)) must be(6)
    lengthInline(List(1, 1, 2, 3, 5, 8)) must be(6)
    lengthBuiltIn(List(1, 1, 2, 3, 5, 8)) must be(6)
  }

  test("P05: Reverse a list.") {
    import P05._

    val reversed = List(8, 5, 3, 2, 1, 1)

    def testReverse(f: List[Int] => List[Int]) {
      f(list) must be(reversed)
    }

    testReverse(reverse)
    testReverse(reverseTailRecursion)
    testReverse(reverseFold)
    testReverse(reverseInline)
    testReverse(reverseBuiltIn)
  }
}
