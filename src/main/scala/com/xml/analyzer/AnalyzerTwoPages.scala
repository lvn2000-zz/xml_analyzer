package com.xml.analyzer

import java.io.File
import com.agileengine.xml.JsoupFindByIdSnippet
import com.typesafe.scalalogging.LazyLogging
import org.jsoup.nodes.{Element, Node}
import scala.util.Try

class AnalyzerTwoPages() extends LazyLogging {

  val buf = scala.collection.mutable.ArrayBuffer.empty[Node]

  def analyze(inpOriginPath: String, inpOtherPath: String): Try[Vector[Node]] = {

    Try {

      val inpOriginFile: File = new File(inpOriginPath)
      val inpOtherFile: File = new File(inpOtherPath)

      if (checkFile(inpOriginFile) && checkFile(inpOtherFile)) {

        JsoupFindByIdSnippet.findElementById(inpOriginFile, AnalyzerTwoPages.idElement).map(targetElement => {
          JsoupFindByIdSnippet.findElementById(inpOtherFile, AnalyzerTwoPages.idRootElement)
            .map(rootOtherElement => analyzeElement(rootOtherElement, targetElement))
        }
        )
      }

      buf.toVector
    }
  }


  private def checkFile(f: File): Boolean = {
    val res = f.exists() && f.canRead
    if (!res) logger.error(s"Error of reading of file ${f.getAbsolutePath}")
    res
  }

  private def analyzeElement(node: Node, origElement: Element): Unit = {

    logger.debug(node.toString)

    if (node.attr("class").contains("btn")) {
      buf += node
    }

    if (node.isInstanceOf[Element]) {
      val childs = node.childNodes()
      if (!childs.isEmpty) {
        (0 until childs.size()).foreach(i =>
          analyzeElement(node.childNode(i), origElement)
        )
      }
    }

    // if(node.attributes().get("id") != AnalyzerTwoPages.idRootElement){
    //   if ( node.hasParent) {
    //      analyzeElement(node.parent(), origElement)
    //   }
    // }
  }

}

object AnalyzerTwoPages {
  val idRootElement = "wrapper"
  val idElement = "make-everything-ok-button"

  def apply() = new AnalyzerTwoPages()
}






