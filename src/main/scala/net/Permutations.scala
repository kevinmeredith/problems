package net

import scala.annotation.tailrec

object Permutations {

  def permutations[A](str: List[A]): List[List[A]] =
    str match {
      case Nil => List(Nil)
      case a :: b :: Nil => List(List(a, b), List(b, a))
      case list @ _ :: _ =>
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
}