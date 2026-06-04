public class FatorialRecursivo {

    public static long fatorial(int n) {
        // Condição de parada
        if (n <= 1) {
            return 1;
        }
        // Chamada recursiva
        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== FATORIAL RECURSIVO ===");
        
        int[] testes = {3, 7, 10, 15, 20, 30, 50, 100};
        
        for (int n : testes) {
            try {
                long inicio = System.nanoTime();
                long resultado = fatorial(n);
                long fim = System.nanoTime();
                System.out.printf("fatorial(%d) = %d (tempo: %.2f ms)%n", 
                    n, resultado, (fim - inicio) / 1_000_000.0);
            } catch (StackOverflowError e) {
                System.out.printf("fatorial(%d) -> StackOverflowError! Recursão explodiu a pilha.%n", n);
                break;
            } catch (Exception e) {
                System.out.printf("fatorial(%d) -> Erro: %s%n", n, e.getMessage());
                break;
            }
        }
    }
}
