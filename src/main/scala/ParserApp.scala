object ParserApp extends App {

  import scopt.OParser

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

  val path = args

  OParser.parse(parser, path, Config()) match {
    case Some(config) => println(config)
    case _ => println("No config provided")
  }
}
