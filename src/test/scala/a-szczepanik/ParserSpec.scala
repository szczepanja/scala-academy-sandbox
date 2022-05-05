package `a-szczepanik`

import scopt.OParser

import org.scalatest._
import flatspec._
import matchers._

class ParserSpec extends AnyFlatSpec with should.Matchers {

  var config: Config = _

  val builder = OParser.builder[Config]
  val parser = {
    import builder._
    OParser.sequence(
      programName("docker-scopt"),
      head("scopt", "4.x"),
      opt[Int]('m', "multiply")
        .action((x, c) => c.copy(multiply = x * 10))
        .text("multiplies Integer by 10"),
      help("help").text("get available options"),
    )
  }

  it should "check if arguments are parsed correctly" in {
    validArguments(Config(50), 5)
  }

  it should "return false when invalid arguments are provided" in {}

  it should "return empty optional argument when parsed correctly" in {
    validArguments(Config())
  }


  def validArguments(expectedConfig: Config, args: Int*) {
    if (args === 5) {
      expectedConfig === Config(50)
    } else {
      Config()
    }
  }
}
