object problem {
  val a = 5
  def main(args: Array[String]) {
    println("yes")
    try {} catch {

      case e: Exception => println(e)
    }
  }
}
