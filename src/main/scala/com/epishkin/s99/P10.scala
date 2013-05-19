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

  def lastBuiltIn[A](list: List[A]): A = list.last
}

object P02 {
  //@tailrec
  def penultimate(list: List[Int]): Int = list match {
    case last :: Nil => last
    case head :: tail => tail match {
      case last :: Nil => head
      case head2 :: tail2 => penultimate(tail)
    }
  }
}

object P03 {
  def nth[A](index: Int, list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case e1 :: _ if (index == 0) => e1
    case _ :: tail => nth(index -1, tail)
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