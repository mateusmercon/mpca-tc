def isPerfectNumber(n: Int): String =
  if n <= 0 then
    "O número deve ser inteiro positivo."
  else
    val properDivisors = (1 until n).filter(divisor => n % divisor == 0)
    val sumOfDivisors = properDivisors.sum
    if sumOfDivisors == n then
      s"$n é um número perfeito."
    else
      s"$n não é um número perfeito."

@main def runIsPerfectNumber() =
  println(isPerfectNumber(6))
  println(isPerfectNumber(28))
  println(isPerfectNumber(12))
  println(isPerfectNumber(-5))