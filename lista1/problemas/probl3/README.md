# Lista 1 -- Teoria da Computação / Linguagens Formais e Autômatos -- 2024/2

**Introdução à Teoria da Computação & Fundamentos Matemáticos**  
**Autor:** Mateus Neves Merçon  

## Problema 3
Este problema exige a implementação de uma função que verifica se um número é perfeito, ou seja, o número é igual à soma de seus divisores próprios, excluindo ele mesmo.

## Solução
A função `isPerfectNumber` calcula a soma dos divisores próprios de um número:
- Filtra os divisores próprios.
- Verifica se a soma desses divisores é igual ao número para determinar se ele é perfeito.

## Exemplo de Execução
Para executar a função no prompt do Scala, utilize, por exemplo:

```scala
isPerfectNumber(6)
isPerfectNumber(28)
isPerfectNumber(12)
isPerfectNumber(-5) 
```

Para executar usando o SBT use:
```bash
sbt run
```