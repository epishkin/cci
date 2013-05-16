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

import com.epishkin.s99.P10._

import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers._

class P10Test extends FunSuite {
  test("Find the last element of a list.") {
    last(List(1, 1, 2, 3, 5, 8)) must be(8)

    last(List(8)) must be(8)

    evaluating {
      last(List())
    } must produce [NoSuchElementException]

    lastBuiltIn(List(1, 1, 2, 3, 5, 8)) must be(8)
  }

  test("Find the last but one element of a list.") {
    penultimate(List(1, 1, 2, 3, 5, 8)) must be(5)
  }
}
