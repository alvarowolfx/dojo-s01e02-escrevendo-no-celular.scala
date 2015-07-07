import scala.collection.generic.SeqFactory

/**
 * Created by alvaroviebrantz on 06/07/2015.
 */
class Cellphone {

  val keys = List(
    "ABC",
    "DEF",
    "GHI",
    "JKL",
    "MNO",
    "PQRS",
    "TUV",
    "WXYZ")

  private def convertCharToCode(c: Char): String = {
    if ( c == ' ')
      return "0"

    keys.zipWithIndex map {
      case (key, index) if key.contains(c) => (index + 2).toString * (key.indexOf(c) + 1)
      case _ => ""
    } mkString("")
  }

  def convertToKeypadCode(text: String): String  = {
    text.foldLeft(List[String]()) {
      case (acc, atual) if !acc.isEmpty && acc.last.charAt(0) == convertCharToCode(atual).charAt(0) => (acc ++ List("_" , convertCharToCode(atual)))
      case (acc, atual) => (acc ++ List(convertCharToCode(atual)))
    } mkString
  }

}

object Cellphone {
  def apply() = new Cellphone()
}

