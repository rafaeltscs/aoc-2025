package DayOne

import DayOne.Utils.{processLine, readInputs, rotateCircular}


object PartOne {
  def main(args: Array[String]): Unit = {
    // Read lines from input.txt
    val inputs: Seq[String] = readInputs()

    // process inputs
    val result = processInputs(inputs)

    // print code (number of times we're pointing to zero)
    println(s"Password: ${result}")
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

}
