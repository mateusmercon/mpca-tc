# Lista 1 -- Teoria da Computação / Linguagens Formais e Autômatos -- 2024/2

**Introdução à Teoria da Computação & Fundamentos Matemáticos**  
**Autor:** Mateus Neves Merçon

## Problema 2

Este problema pede a implementação de uma função que verifique se uma expressão composta apenas por parênteses está corretamente balanceada. A expressão é considerada bem formada quando cada parêntese de abertura possui um correspondente parêntese de fechamento. 

## Solução

A função checkParentheses utiliza uma abordagem recursiva com um contador para monitorar o equilíbrio dos parênteses:

- A função auxiliar balance percorre a lista de caracteres, incrementando o contador para parênteses de abertura e decrementando para parênteses de fechamento.
- Se o contador for terminar em 0, a função retorna false, indicando que a expressão não está balanceada.
- A função lança uma exceção para caracteres inválidos na expressão.

## Exemplo de Execução

Para executar a função no prompt do Scala, utilize, por exemplo:

```scala
checkParentheses("()()")
checkParentheses("(()))(")
checkParentheses("((()))")
```

Para executar usando o SBT use:

```bash
sbt run
```
