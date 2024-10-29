def checkParentheses(expression: String): String =
  def balance(chars: List[Char], count: Int): Boolean =
    if count < 0 then false
    else
      chars match
        case Nil => count == 0
        case '(' :: tail => balance(tail, count + 1)
        case ')' :: tail => balance(tail, count - 1)
        case _ :: _ => throw IllegalArgumentException("Caracter inválido na expressão.")

  if balance(expression.toList, 0) then
    "A expressão está bem formada."
  else
    "A expressão não está bem formada."

@main def runCheckParentheses() =
  println(checkParentheses("(()())"))
  println(checkParentheses("(()"))
  println(checkParentheses("(()()(()))"))