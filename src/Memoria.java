public class Memoria {
    private float valorMemoria = 0;

    // M+ adicionar à memória
    public void adicionar(float valor) {
        valorMemoria += valor;
    }

    // MA subtrair da memória
    public void subtrair(float valor) {
        valorMemoria -= valor;
    }

    // MR retornar o valor atual da memória
    public float recuperar() {
        return valorMemoria;
    }

    // MC limpar a memória
    public void limpar() {
        valorMemoria = 0;
    }
}