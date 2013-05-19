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

object P01 {
  @tailrec
  def last[A](list: List[A]): A = list match {
    case last :: Nil => last
    case _ :: tail   => last(tail)
    case _           => throw new NoSuchElementException
  }

  def lastInline[A](list: List[A]): A = {
    if (list.isEmpty) throw new NoSuchElementException

    var rest = list
    while (!rest.tail.isEmpty) {
      rest = rest.tail
    }

    rest.head
  }

  def lastBuiltIn[A](list: List[A]): A = list.last
}

object P02 {
  @tailrec
  def penultimate[A](list: List[A]): A = list match {
    case head :: next :: Nil => head
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

  def penultimateGeneric[A](list: List[A]): A = {
    @tailrec
    def nthFromEnd(n: Int, rest: List[A], index: Int)(resultList: List[A]): A = rest match {
      case Nil => resultList.head
      case head :: tail  => nthFromEnd(n, tail, index + 1) {
        if (index < n)
          List.empty[A]
        else if (index == n)
          list
        else
          resultList.tail
      }
    }

    nthFromEnd(1, list, 0)(List.empty[A])
  }
}

object P03 {
  def nth[A](index: Int, list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case e1 :: _ if (index == 0) => e1
    case _ :: tail => nth(index - 1, tail)
  }

  def nthBuiltIn[A](index: Int, list: List[A]): A = list(index)
}

object P04 {
  def length[A](list: List[A]): Int = list match {
    case Nil => 0
    case e1 :: tail => 1 + length(tail)
  }

  def lengthTailRecursion[A](list: List[A]): Int = {
    @tailrec
    def length0(list: List[A], result: Int): Int = list match {
      case Nil => result
      case e1 :: tail => length0(tail, result + 1)
    }

    length0(list, 0)
  }

  def lengthFold[A](list: List[A]): Int = list.foldLeft(0) {(result, _) => result + 1}

  def lengthInline[A](list: List[A]): Int = {
    var result = 0

    var rest = list
    while (!rest.isEmpty) {
      result += 1
      rest = rest.tail
    }

    result

  }

  def lengthBuiltIn[A](list: List[A]): Int = list.length
}

object P05 {
  def reverse[A](list: List[A]): List[A] = list match {
    case Nil  => Nil
    case e1 :: tail => reverse(tail) ::: List(e1)
  }

  def reverseTailRecursion[A](list: List[A]): List[A] = {
    @tailrec
    def reverse0(result: List[A], tail: List[A]): List[A] = tail match {
      case Nil => result
      case e1 :: t => reverse0(e1 :: result, t)
    }

    reverse0(Nil, list)
  }

  def reverseFold[A](list: List[A]): List[A] = list.foldLeft(List.empty[A]) {(result, e) => e :: result}

  def reverseInline[A](list: List[A]): List[A] = {
    var result: List[A] = Nil

    var rest = list
    while (!rest.isEmpty) {
      result = rest.head :: result
      rest = rest.tail
    }

    result
  }

  def reverseBuiltIn[A](list: List[A]): List[A] = list.reverse
}

object P06 {
  def isPalindrome[A](list: List[A]): Boolean = {
    list == P05.reverseBuiltIn(list)
  }
}

object P20 {
  def removeAt[A](n: Int, list: List[A]): (List[A], A) = {
    def removeAtR(index: Int, start: List[A], end: List[A]): (List[A], A) = end match {
      case e1 :: tail if (index == n) => (start ::: tail, e1)
      case e1 :: tail => removeAtR(index + 1, start :+ e1, tail)
      case _ => throw new IndexOutOfBoundsException
    }

    removeAtR(0, List.empty[A],  list)
  }

  def removeAtBuiltIn[A](n: Int, list: List[A]): (List[A], A) =
    (list.take(n) ::: list.drop(n + 1), list(n))
}