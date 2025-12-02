package DayOne

import DayOne.Utils.processLine
import General.Utils.{readInputs, rotateCircular}

object PartTwo {
  def main(args: Array[String]): Unit = {
    // Read lines from input.txt
    val inputs: Seq[String] = readInputs("DayOne")

    // process inputs
    val result = processInputs(inputs)

    // print code (number of times we're pointing to zero)
    println(s"Password: ${result}")
  }

  private def processInputs(inputs: Seq[String]): Int = {
    val start = 50;

    inputs.foldLeft((start, 0)) { (accumulator, line) =>
      var steps: Int = processLine(line)
      var laps = 0

      if (steps.abs > 100) {
        laps = (steps / 100).toInt
        steps = steps - (laps * 100)
      }

      val next = rotateCircular(accumulator._1, steps)

      if(next != 0 && accumulator._1 != 0) {
        if (steps < 0 && next > accumulator._1) {
          laps = laps - 1
        } else if (steps > 0 && next < accumulator._1) {
          laps = laps + 1
        }
      }

      if (next == 0) (next, accumulator._2 + 1 + laps.abs)
      else (next, accumulator._2 + laps.abs)
    }._2

  }
}
