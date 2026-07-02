import org.scalacheck.Gen
import terms.Variable

import scala.util.Random

object generators:
  val badCharacters: List[Char] = Array('+', '-', '*', '/').toList

  val genValidVarName: Gen[String] = Gen.nonEmptyStringOf(Gen.alphaChar)

  val genInvalidVarName: Gen[String] = for
    listOfBad <- Gen.nonEmptyListOf(Gen.oneOf(badCharacters))
    combinedCharList <- Gen
      .listOf(Gen.alphaChar)
      .map(goodList => Random.shuffle(listOfBad ::: goodList))
  yield combinedCharList.mkString

  val genVariable: Gen[Variable] =
    genValidVarName.map(name => Variable(name).toOption.get)
