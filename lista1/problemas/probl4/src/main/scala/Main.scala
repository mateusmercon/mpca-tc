def evaluateSetExpression(sets: Map[String, Set[Any]], expression: String): Set[Any] =
  val universe = sets.values.flatten.toSet

  sealed trait Token
  case class Identifier(name: String) extends Token
  case class Operator(symbol: String) extends Token
  case object LeftParen extends Token
  case object RightParen extends Token

  def tokenize(expr: String): List[Token] =
    val tokens = expr.replaceAll("\\s+", "").toList
    def loop(chars: List[Char], acc: List[Token]): List[Token] =
      chars match
        case Nil => acc.reverse
        case '(' :: rest => loop(rest, LeftParen :: acc)
        case ')' :: rest => loop(rest, RightParen :: acc)
        case ch :: rest if "+-*/&|^~P".contains(ch) =>
          loop(rest, Operator(ch.toString) :: acc)
        case ch :: rest if ch.isLetter =>
          val (name, remaining) = chars.span(_.isLetter)
          loop(remaining, Identifier(name.mkString) :: acc)
        case _ => throw new IllegalArgumentException("Caractere inválido na expressão.")
    loop(tokens, Nil)

  def parseExpression(tokens: List[Token], minPrec: Int): (Set[Any], List[Token]) =
    var (left, rest) = parseFactor(tokens)
    while rest.nonEmpty && rest.head.isInstanceOf[Operator] && precedence(
        rest.head.asInstanceOf[Operator].symbol
      ) >= minPrec do
      val Operator(op) = rest.head.asInstanceOf[Operator]
      val prec = precedence(op)
      val nextMinPrec = if op == "-" then prec + 1 else prec
      val (right, remaining) = parseExpression(rest.tail, nextMinPrec)
      left = op match
        case "|" => left union right
        case "&" => left intersect right
        case "-" => left diff right
        case "^" => (left diff right) union (right diff left)
        case "*" => (for a <- left; b <- right yield (a, b)).toSet
      rest = remaining
    (left, rest)

  def parseFactor(tokens: List[Token]): (Set[Any], List[Token]) =
    tokens match
      case Operator("~") :: rest =>
        val (set, remaining) = parseFactor(rest)
        (universe diff set, remaining)
      case Operator("P") :: rest =>
        val (set, remaining) = parseFactor(rest)
        (set.subsets.toSet, remaining)
      case LeftParen :: rest =>
        val (expr, remaining) = parseExpression(rest, 0)
        if remaining.headOption != Some(RightParen) then
          throw new IllegalArgumentException("Parênteses desbalanceados.")
        (expr, remaining.tail)
      case Identifier(name) :: rest =>
        if !sets.contains(name) then
          throw new IllegalArgumentException(s"Conjunto indefinido: $name")
        (sets(name), rest)
      case _ => throw new IllegalArgumentException("Expressão inválida.")

  def precedence(op: String): Int =
    op match
      case "~" | "P" => 4
      case "*"       => 3
      case "&"       => 2
      case "|" | "^" => 1
      case "-"       => 0
      case _         => -1

  val (result, remainingTokens) = parseExpression(tokenize(expression), 0)
  if remainingTokens.nonEmpty then
    throw new IllegalArgumentException("Tokens inesperados no final da expressão.")
  result  // Ensure this line is not indented under the 'if' block




@main def runEvaluateSetExpression() =
  val sets: Map[String, Set[Any]] = Map(
    "A" -> Set(1, 2, 3),
    "B" -> Set(2, 3, 4),
    "C" -> Set(3, 4, 5)
  )
  println(evaluateSetExpression(sets, "A | (B & C)"))
  println(evaluateSetExpression(sets, "(A - B) ^ C"))
  println(evaluateSetExpression(sets, "~(A | B)"))
  println(evaluateSetExpression(sets, "P(A) - P(B)"))
