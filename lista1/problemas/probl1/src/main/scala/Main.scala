def convertNumber(number: String, fromBase: Int, toBase: Int): String =
  val suportedBases = Set(2, 8, 10, 12, 16, 20)
  if !suportedBases.contains(fromBase) || !suportedBases.contains(toBase) then
    throw new IllegalArgumentException("Bases não suportadas.")

  val digits = "0123456789ABCDEFGHIJ"

  def toInt(num: String, base: Int): Int =
    num.toUpperCase.foldLeft(0) { (accumulator, character) =>
      val digitValue = digits.indexOf(character)
      accumulator * base + digitValue
    }

  def fromInt(value: Int, base: Int): String =
    if value < base then digits(value).toString
    else fromInt(value / base, base) + digits(value % base)

  val decimalValue = toInt(number, fromBase)
  fromInt(decimalValue, toBase)

@main def testConversion() =
  println(convertNumber("A2", 16, 10))
  println(convertNumber("1010", 2, 16))
  println(convertNumber("123", 10, 8))
  println(convertNumber("1C7", 20, 12))
  println(convertNumber("15", 10, 16))