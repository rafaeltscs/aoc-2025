package DayTwo

import General.{BigIntIterator, Utils}

import scala.util.boundary
import scala.util.boundary.break

object PartTwo {
  def main(args: Array[String]): Unit = {
    // Read lines from input.txt
    val inputs: Seq[String] = Utils.readInputs("DayTwo")

    // process inputs
    val result = processInputs(inputs)

    // print code (number of times we're pointing to zero)
    println(s"Result: ${result}")
  }

  private def processInputs(inputs: Seq[String]): BigInt = {
    inputs.head.split(",").foldLeft[BigInt](0){(accumulator, rangeStr) => {
      accumulator + processRange(rangeStr)
    }}
  }

  private def processRange(rangeStr: String): BigInt = {
    println("Processing Range: " + rangeStr)
    val (head:String,tail:String) = Tuple.fromArray(rangeStr.split("-"))
    val range = new BigIntIterator(BigInt(head), BigInt(tail), 1)

    range.foldLeft[BigInt](0){(accumulator, id) => {
      val idStr = id.toString()
      if (idStr.startsWith("0")) accumulator
      else {
        var result: BigInt = accumulator
        val maxLength = idStr.length / 2;
        boundary:
          (1 to maxLength).foreach((length) => {
            val subStr = idStr.substring(0,length)
            val countSubs = idStr.sliding(length,length).count(window => window == subStr)
            if (countSubs.toFloat == idStr.length.toFloat / length.toFloat) {
              result = accumulator + id
              println("Invalid: " + id)
              break(result)
            }
          })
        result
      }
    }}
  }
}