public class FatorialBottomUp {

    public static long fatorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Número negativo não tem fatorial");
        if (n <= 1) return 1;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        
        return dp[n];
    }

    // Versão otimizada sem array (só precisa do último valor)
    public static long fatorialOtimizado(int n) {
        if (n < 0) throw new IllegalArgumentException("Número negativo não tem fatorial");
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("=== FATORIAL BOTTOM-UP (ITERATIVO) ===");
        
        int[] testes = {3, 7, 10, 15, 20, 30, 50, 100};
        
        for (int n : testes) {
            try {
                long inicio = System.nanoTime();
                long resultado = fatorialOtimizado(n);
                long fim = System.nanoTime();
                System.out.printf("fatorial(%d) = %d (tempo: %.2f ms)%n", 
                    n, resultado, (fim - inicio) / 1_000_000.0);
            } catch (Exception e) {
                System.out.printf("fatorial(%d) -> Erro: %s%n", n, e.getMessage());
                break;
            }
        }
    }
}
