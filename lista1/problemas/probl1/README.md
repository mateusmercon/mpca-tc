# Lista 1 -- Teoria da Computação / Linguagens Formais e Autômatos -- 2024/2

**Introdução à Teoria da Computação & Fundamentos Matemáticos**
**Autor:** Mateus Neves Merçon  

## Problema 1
Este problema exige a construção de uma função que converta um número de uma base para outra, com suporte para as bases 2, 8, 10, 12, 16 e 20. Para bases superiores a 10, são usados os dígitos A a J.

## Solução
A função `convertNumber` utiliza dois métodos auxiliares:
- `toInt`: converte o número da base de origem para uma representação numérica.
- `fromInt`: converte a representação numérica para a base de destino.

O programa verifica se as bases especificadas são suportadas e lança uma exceção se não forem.

## Exemplo de Execução
Para executar a função no prompt do Scala execute, por exemplo:

```scala
convertNumber("A2", 16, 10)
convertNumber("1010", 2, 16)
convertNumber("123", 10, 8)
convertNumber("1C7", 20, 12)
convertNumber("15", 10, 16)
```

Para executar usando o SBT use:
```bash
sbt run
```
