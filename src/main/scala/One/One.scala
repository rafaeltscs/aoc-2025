package One

import os._

object One {
  def main(args: Array[String]): Unit = {
    // Read lines from input.txt
    val inputs: Seq[String] = readInputs()

    // process inputs
    val result = processInputs(inputs)

    // print code (number of times we're pointing to zero)
    println(s"Password: ${result}")
  }

  private def readInputs(): Seq[String] = {
    val filename = "input.txt"
    val path: Path = os.pwd / "resources" / "One" / filename
    os.read.lines(path)
  }

  private def processInputs(inputs: Seq[String]): Int = {
    val start = 50;

    inputs.foldLeft((start, 0)) { (accumulator, line) =>
      val steps: Int = processLine(line)
      val next = rotateCircular(accumulator._1, steps)

      if (next == 0) (next, accumulator._2 + 1)
      else (next, accumulator._2)
    }._2

  }

  private def processLine(line: String): Int = {
    val direction: Int = if(line.startsWith("R")) 1 else -1
    val steps: Int = Integer.parseInt(line.substring(1))

    steps * direction
  }

  private def rotateCircular(n: Int, steps: Int, size: Int = 100): Int = {
    // 1. Calculate the effective steps modulo the size to handle full rotations
    val effectiveSteps = steps % size

    // 2. Add the effective steps to the number
    val movedN = n + effectiveSteps

    // 3. Handle wrapping for both positive and negative results using a double modulo
    // The first modulo gives a value in (-size, size).
    // Adding size shifts it to (0, 2*size).
    // The second modulo gives a value in [0, size).
    val result = (movedN % size + size) % size
    result
  }

}
