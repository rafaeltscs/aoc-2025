package DayTwo

import General.{BigIntIterator, Utils}

object PartOne {
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
      println("Processing ID: " + id)
      val idStr = id.toString()
      if (idStr.length % 2 != 0 || idStr.startsWith("0")) accumulator
      else {
        val idParts = idStr.splitAt(idStr.length/2)
        println(idStr + " - " + idParts._1 + "," + idParts._2)
        if (idParts._1 == idParts._2) accumulator + id
        else accumulator
      }
    }}
  }
}