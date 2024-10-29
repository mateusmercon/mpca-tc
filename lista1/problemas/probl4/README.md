# Lista 1 -- Teoria da Computação / Linguagens Formais e Autômatos -- 2024/2

**Introdução à Teoria da Computação & Fundamentos Matemáticos**  
**Autor:** Mateus Neves Merçon  

## Problema 4
Este problema exige a implementação de uma função para avaliar expressões da álgebra de conjuntos. A função recebe conjuntos definidos por extensão e uma expressão de operações entre conjuntos. As operações suportadas incluem: união, interseção, diferença, diferença simétrica, complemento, produto cartesiano e conjunto das partes. O complemento é calculado usando o conjunto universo, definido como a união de todos os conjuntos.

## Solução
A função `evaluateSetExpression` utiliza:
- **Tokenização e Parsing**: Converte a expressão em tokens e avalia-os conforme a precedência das operações.
- **Operações de Conjuntos**: Aplica operações como união (`|`), interseção (`&`), diferença (`-`), etc., em conjuntos identificados.

## Exemplo de Execução
Para executar a função no prompt do Scala, utilize, por exemplo:

```scala
val sets: Map[String, Set[Any]] = Map("A" -> Set(1, 2, 3), "B" -> Set(2, 3, 4), "C" -> Set(3, 4, 5))
evaluateSetExpression(sets, "A | B")
evaluateSetExpression(sets, "(A & B) ^ ~A")
```

Para executar usando o SBT use:
```bash
sbt run
```