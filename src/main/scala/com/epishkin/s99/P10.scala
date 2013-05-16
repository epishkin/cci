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

import scala.annotation.tailrec

object P10 {
  @tailrec
  def last[A](list: List[A]): A = list match {
    case last :: Nil => last
    case _ :: tail   => last(tail)
    case _           => throw new NoSuchElementException
  }

  def lastBuiltIn[A](list: List[A]): A = list.last

  //@tailrec
  def penultimate(list: List[Int]): Int = list match {
    case last :: Nil => last
    case head :: tail => tail match {
      case last :: Nil => last
      case head2 :: tail2 => last(tail2)
    }
  }
}
