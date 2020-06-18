package com.xml.analyzer

import java.io.File

import com.agileengine.xml.JsoupFindByIdSnippet
import com.typesafe.scalalogging.LazyLogging
import org.jsoup.nodes.{Attributes, Element}

import scala.annotation.tailrec
import scala.util.Try

class AnalyzerTwoPages() extends LazyLogging {

  def analyze(inpOriginPath: String, inpOtherPath: String) = {

    Try {

      val inpOriginFile: File = new File(inpOriginPath)
      val inpOtherFile: File = new File(inpOtherPath)

      if (checkFile(inpOriginFile) && checkFile(inpOtherFile)) {

        JsoupFindByIdSnippet.findElementById(inpOriginFile, AnalyzerTwoPages.idElement).map(element => {

          val rootOtherElement: Try[Element] = JsoupFindByIdSnippet.findElementById(inpOtherFile, AnalyzerTwoPages.idRootElement)
          val resultInvestigation: Try[Element] = rootOtherElement.map(otherElement => analyzeElement(otherElement.children().last(), element))

          resultInvestigation.getOrElse(Try {
            ""
          })
        }
        )

      } else {
        ""
      }

    }

  }


  private def checkFile(f: File): Boolean = {
    val res = f.exists() && f.canRead
    if (!res) logger.error(s"Error of reading of file ${f.getAbsolutePath}")
    res
  }

  @tailrec
  private def analyzeElement(element: Element, origElement: Element): Element = {
    if (element.lastElementSibling().hasParent) {
      analyzeElement(element.lastElementSibling(), origElement)
    } else {
      val origAttrs: Attributes = origElement.attributes()

      //TODO need to realize logic for comparing of origin element with other element
      //Just Stub now
      element
    }


  }


}

object AnalyzerTwoPages {

  val idRootElement = "wrapper"
  val idElement = "make-everything-ok-button"

  def apply() = new AnalyzerTwoPages()
}






