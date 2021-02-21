package net

import scala.annotation.tailrec

object A {

  // "23"
  // "32,
  private def f(s: String): List[String] = {
    val arr: Array[Int] = s.split("")
    val arrLen: Int = arr.length
    val numRepeat: BigDecimal = factorial(arrLen) / arrLen
  }

  private def factorial(n: Int): BigDecimal =
    factorialHelper(n, 1)

  @tailrec
  private def factorialHelper(n: Int, acc: BigDecimal): BigDecimal = {
    if(n <= 1) acc
    else factorialHelper(n-1, acc * n)
  }

  private def f[A](list: List[A], n: Int): List[List[A]] = {
    if(n <= 0) Nil
    else {
      val shifted: List[A] = shift(list)
      shifted :: f(shifted, n-1)
    }
  }

  // shift(123) == 231
  private def shift[A](arr: List[A]): List[A] = arr match {
    case head :: tail => tail ++ List(head)
    case Nil => Nil
  }

  def permutations[A](str: List[A]): List[List[A]] =
    str match {
      case Nil => Nil
      case head :: Nil => List(List(head))
      case a :: b :: Nil => List(List(a, b), List(b, a))
      case list @ head :: tail =>
        val shifteds: List[List[A]] =
          f(list, list.length)

        shifteds.flatMap {
          case head :: tail =>
            permutations(tail).map { lists: List[A] =>
              head :: lists
            }
          case Nil => Nil
        }
    }

    // 123 --

    // 321
    // 312
    // 231
    // 213
    // 123
    // 132

  }

  private def permutationsHelper()

  //The permutations of 2, 3 are:
  // 32, 23

  //The permutations of 2, 3, 4 are: (3! / 3) = (6 / 3) = 2
  // 432, 423, 342, 324, 234, 243

  //The permutations of 2, 3, 4, 5 are: (4! / 4) = (24 /4) = 6
  //5432, 5423, 5324, 5342, 5234, 5243, 4532, 4523, 4325, 4352, 4253, 4235, 3542, 3524, 3425, 3452, 3254, 3245, 2543, 2534, 2435, 2453, 2354, 2345

}