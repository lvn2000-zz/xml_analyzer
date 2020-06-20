package com.xml.analyzer

import org.scalatest.flatspec.AnyFlatSpec
import scala.xml.Node

class AnalyzerTwoPagesTest extends AnyFlatSpec {

  val origF = getClass.getResource("/orig.html").getPath
  val otherF = getClass.getResource("/other.html").getPath

  "Analyzing of input files " should "return count of similarity elements" in {
    val result = AnalyzerTwoPages().analyze(origF, otherF)
    assert(result.getOrElse(Vector.empty[Node]).size == 3)
  }

}
