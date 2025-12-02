package General

class BigIntIterator(start: BigInt, end: BigInt, step: BigInt) extends Iterator[BigInt] {
  private var current = start

  override def hasNext: Boolean =
    if (step > 0) current <= end
    else if (step < 0) current >= end
    else start == end // Special case for step 0

  override def next(): BigInt = {
    if (!hasNext) throw new NoSuchElementException("next on empty iterator")
    val value = current
    current += step
    value
  }
}
