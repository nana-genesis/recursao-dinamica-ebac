import java.util.HashMap;
import java.util.Map;

public class FatorialTopDown {

    private static Map<Integer, Long> memo = new HashMap<>();

    static {
        memo.put(0, 1L);
        memo.put(1, 1L);
    }

    public static long fatorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Número negativo não tem fatorial");
        
        // Se já calculou, retorna do cache
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Calcula recursivamente e armazena no cache
        long resultado = n * fatorial(n - 1);
        memo.put(n, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("=== FATORIAL TOP-DOWN (MEMOIZATION) ===");
        
        int[] testes = {3, 7, 10, 15, 20, 30, 50, 100};
        
        for (int n : testes) {
            try {
                long inicio = System.nanoTime();
                long resultado = fatorial(n);
                long fim = System.nanoTime();
                System.out.printf("fatorial(%d) = %d (tempo: %.2f ms)%n", 
                    n, resultado, (fim - inicio) / 1_000_000.0);
            } catch (StackOverflowError e) {
                System.out.printf("fatorial(%d) -> StackOverflowError!%n", n);
                break;
            } catch (Exception e) {
                System.out.printf("fatorial(%d) -> Erro: %s%n", n, e.getMessage());
                break;
            }
        }
        
        System.out.println("\nTamanho do cache: " + memo.size());
    }
}
