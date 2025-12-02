package DayOne

object Utils {
  def processLine(line: String): Int = {
    val direction: Int = if (line.startsWith("R")) 1 else -1
    val steps: Int = Integer.parseInt(line.substring(1))

    steps * direction
  }
}
