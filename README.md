# Tarefa: Recursão e Programação Dinâmica

## Exercício 1 - Fatorial com Recursão

### Código:
[FatorialRecursivo.java](src/FatorialRecursivo.java)

### Pergunta: Consegue calcular o fatorial de um número acima de 100 com recursão?
**Resposta:** Não, porque:
1. **StackOverflowError** - Cada chamada recursiva consome pilha. Para n=100, são 100 chamadas aninhadas.
2. **Overflow numérico** - Fatorial de 100 tem 158 dígitos, muito maior que o limite do `long` (9.2e18).
3. **Desempenho** - Embora o fatorial recursivo seja O(n), o overhead da recursão torna inviável para n muito grandes.

---

## Exercício 2 - Fatorial com Programação Dinâmica

### Abordagem Top-Down (Memoization):
[Código](src/FatorialTopDown.java)

### Abordagem Bottom-Up (Iterativo):
[Código](src/FatorialBottomUp.java)

### Diferenças entre recursão pura e PD:

| Aspecto | Recursão pura | PD Top-Down | PD Bottom-Up |
|---------|--------------|-------------|--------------|
| Abordagem | Divide em subproblemas | Começa do topo com cache | Começa da base |
| Uso de memória | Pilha (risco de StackOverflow) | Cache + pilha | Array ou variável única |
| Performance | O(n) com overhead | O(n) com cache | O(n) mais rápido |
| Risco de StackOverflow | Sim (n > ~10⁴) | Sim (ainda recursivo) | Não |

---

## Exercício 3 - Complexidade de Fibonacci

### Complexidade calculada:

| Versão | Complexidade Tempo | Complexidade Espaço |
|--------|-------------------|---------------------|
| Recursiva pura | O(2ⁿ) | O(n) |
| PD Top-Down | O(n) | O(n) |
| PD Bottom-Up | O(n) | O(1) |

### Por que a solução com PD é melhor?

1. **Recursiva pura recalcula os mesmos valores** centenas de vezes. Para fib(40), são ~2⁴⁰ operações (~1 trilhão!).
2. **PD Top-Down** calcula cada valor **uma única vez** e armazena no cache.
3. **PD Bottom-Up** é ainda melhor: espaço constante O(1) e sem recursão.
4. **Diferença prática:** Recursiva para n=45 demoraria **dias/semanas**; PD termina em **milissegundos**.

### Código de comparação:
[FibonacciComplexidade.java](src/FibonacciComplexidade.java)

---

## Como executar os códigos

bash
cd src
javac FatorialRecursivo.java FatorialTopDown.java FatorialBottomUp.java FibonacciComplexidade.java

java FatorialRecursivo
java FatorialTopDown
java FatorialBottomUp
java FibonacciComplexidade
