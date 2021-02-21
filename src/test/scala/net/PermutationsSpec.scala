package net

import munit.ScalaCheckSuite
import org.scalacheck.Prop._
import org.scalacheck.Gen

class PermutationsSpec extends ScalaCheckSuite {

  private val listGen: Gen[List[Int]] =
    for {
      n <- Gen.choose(0, 7)
      list <- Gen.listOfN(n, Gen.posNum[Int])
    } yield list


  property("permutations works") {
    forAll(listGen) { list: List[Int] =>
      val mine: List[List[Int]] = Permutations.permutations(list)
      val stdLib: List[List[Int]] = list.permutations.toList
      assert(stdLib.diff(mine).isEmpty)
    }
  }

}