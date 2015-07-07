import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by alvaroviebrantz on 06/07/2015.
 */
class CellphoneTest extends FlatSpec with Matchers {

  val cellphone = Cellphone()

  it should "return number representation when a letter is passed" in {

    cellphone.convertToKeypadCode("A") should be("2")
    cellphone.convertToKeypadCode("B") should be("22")
    cellphone.convertToKeypadCode("C") should be("222")

    cellphone.convertToKeypadCode("D") should be("3")
    cellphone.convertToKeypadCode("E") should be("33")
    cellphone.convertToKeypadCode("F") should be("333")

    cellphone.convertToKeypadCode("P") should be("7")
    cellphone.convertToKeypadCode("Q") should be("77")
    cellphone.convertToKeypadCode("R") should be("777")
    cellphone.convertToKeypadCode("S") should be("7777")
  }

  it should "use a underline to separate two number from the same key group" in {

    cellphone.convertToKeypadCode("AB") should be("2_22")
    cellphone.convertToKeypadCode("EF") should be("33_333")
    cellphone.convertToKeypadCode("MAA") should be("62_2")
  }

  it should "return '77773367_7773302_222337777_777766606660366656667889999_9999555337777' when 'SEMPRE ACESSO O DOJOPUZZLESSEMPRE ACESSO O DOJOPUZZLES' passed" in {

    cellphone.convertToKeypadCode("SEMPRE ACESSO O DOJOPUZZLES") should be("77773367_7773302_222337777_777766606660366656667889999_9999555337777")
  }

  it should "return '29337777666_63307777222_25552' when 'AWESOME SCALA' passed" in {
    
    cellphone.convertToKeypadCode("AWESOME SCALA") should be("29337777666_63307777222_25552")
  }
}
