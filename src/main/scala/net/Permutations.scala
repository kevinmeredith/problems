package net

import scala.annotation.tailrec

object Permutations {

  private def factorial(n: Int): BigDecimal =
    factorialHelper(n, 1)

  @tailrec
  private def factorialHelper(n: Int, acc: BigDecimal): BigDecimal = {
    if (n <= 1) acc
    else factorialHelper(n - 1, acc * n)
  }

  private def shiftN[A](list: List[A], n: Int): List[List[A]] = {
    if (n <= 0) Nil
    else {
      val shifted: List[A] = shift(list)
      shifted :: shiftN(shifted, n - 1)
    }
  }

  private def shift[A](arr: List[A]): List[A] = arr match {
    case head :: tail => tail ++ List(head)
    case Nil => Nil
  }

  //  private def shiftHelper[A](n: Int, list: List[A], acc: List[List[A]]): List[List[A]] = {
  //    if(n <= 0) acc
  //    else {
  //      val shifted: List[A] = shift(list)
  //      shiftHelper(n-1, shifted, shifted :: acc)
  //    }

  def permutations[A](str: List[A]): List[List[A]] =
    str match {
      case Nil => List(Nil)
      case l @ head :: tail => permutationsHelper(l)
    }

  def permutationsHelper[A](str: List[A]): List[List[A]] =
    str match {
      case Nil => Nil
      case head :: Nil => List(List(head))
      case a :: b :: Nil => List(List(a, b), List(b, a))
      case list@head :: tail =>
        val shifteds: List[List[A]] =
          shiftN(list, list.length)

        shifteds.flatMap {
          case head :: tail =>
            permutations(tail).map { lists: List[A] =>
              head :: lists
            }
          case Nil => Nil
        }
    }
}