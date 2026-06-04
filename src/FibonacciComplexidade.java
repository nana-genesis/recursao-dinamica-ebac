public class FibonacciComplexidade {

    // ========== VERSÃO RECURSIVA PURA ==========
    // Complexidade de tempo: O(2^n) - exponencial!
    // Complexidade de espaço: O(n) - por causa da pilha de recursão
    public static long fibRecursivo(int n) {
        if (n <= 1) return n;
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    // ========== VERSÃO COM PROGRAMAÇÃO DINÂMICA (TOP-DOWN) ==========
    // Complexidade de tempo: O(n)
    // Complexidade de espaço: O(n) - array/cache + pilha
    private static long[] memo;
    
    public static long fibTopDown(int n) {
        memo = new long[n + 1];
        return fibTopDownAux(n);
    }
    
    private static long fibTopDownAux(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibTopDownAux(n - 1) + fibTopDownAux(n - 2);
        return memo[n];
    }

    // ========== VERSÃO COM PROGRAMAÇÃO DINÂMICA (BOTTOM-UP) ==========
    // Complexidade de tempo: O(n)
    // Complexidade de espaço: O(1) - só duas variáveis
    public static long fibBottomUp(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("=== COMPARAÇÃO DE COMPLEXIDADE FIBONACCI ===\n");
        
        int n = 45; // Número grande para ver diferença
        
        // Teste recursivo (cuidado! pode demorar muito)
        System.out.println("Testando fibonacci recursivo para n=40...");
        long inicio = System.nanoTime();
        long resultRec = fibRecursivo(40);
        long fim = System.nanoTime();
        System.out.printf("fibRecursivo(40) = %d (tempo: %.2f ms)%n", resultRec, (fim - inicio) / 1_000_000.0);
        
        // Teste Top-Down
        inicio = System.nanoTime();
        long resultTD = fibTopDown(n);
        fim = System.nanoTime();
        System.out.printf("fibTopDown(%d) = %d (tempo: %.2f ms)%n", n, resultTD, (fim - inicio) / 1_000_000.0);
        
        // Teste Bottom-Up
        inicio = System.nanoTime();
        long resultBU = fibBottomUp(n);
        fim = System.nanoTime();
        System.out.printf("fibBottomUp(%d) = %d (tempo: %.2f ms)%n", n, resultBU, (fim - inicio) / 1_000_000.0);
        
        System.out.println("\n=== ANÁLISE DE COMPLEXIDADE ===");
        System.out.println("| Versão | Complexidade Tempo | Complexidade Espaço |");
        System.out.println("|--------|-------------------|---------------------|");
        System.out.println("| Recursiva Pura | O(2^n) | O(n) |");
        System.out.println("| PD Top-Down | O(n) | O(n) |");
        System.out.println("| PD Bottom-Up | O(n) | O(1) |");
        
        System.out.println("\n=== POR QUE A SOLUÇÃO COM PD É MELHOR? ===");
        System.out.println("1. A recursiva pura recalcula os mesmos valores centenas/milhares de vezes.");
        System.out.println("2. Para n=40, a recursiva faz ~2^40 operações (~1 trilhão!).");
        System.out.println("3. A PD Top-Down calcula cada valor apenas uma vez e guarda no cache.");
        System.out.println("4. A PD Bottom-Up é ainda melhor: espaço constante O(1) e sem recursão.");
        System.out.println("5. Diferença prática: recursiva para n=45 demoraria horas/dias; PD termina em milissegundos.");
    }
}
