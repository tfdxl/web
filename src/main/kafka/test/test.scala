object Test {
  def main(args: Array[String]): Unit = {
    print("what is the fuck\n")
    val x = new StringBuilder("memeda")
    x.++=("tfdsf")
    println(x.toString())
    val f = (x: Float) => x * x
    println(f(434.89f))
    val t = new Test();
    t.finalize();
  }
}

class Test {
  println(Test)
}