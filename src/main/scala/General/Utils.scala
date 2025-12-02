package General

import os.*

object Utils {
  def readInputs(packageName: String): Seq[String] = {
    val filename = "input.txt"
    val path: Path = os.pwd / "resources" / packageName / filename
    os.read.lines(path)
  }

  def rotateCircular(n: Int, steps: Int, size: Int = 100): Int = {
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
