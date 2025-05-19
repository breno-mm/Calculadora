public class Calculo {

    //somar
    public float somar(float numero1, float numero2) {
        return numero1 + numero2;
    }

    //dividir
    public float dividir(float numero1, float numero2) {
        if (numero2 == 0)
            return Float.NaN;
        return numero1 / numero2;
    }

    //subtrair
    public float subtrair(float numero1, float numero2) {
        return numero1 - numero2;
    }

    //multicar
    public float multiplicar(float numero1, float numero2) {
        return numero1 * numero2;
    }

    //porcetagem....
    public float porcentagem(float numero1, float numero2) {
        return (numero1 * numero2) / 100;
    }

    //operações
    public float operacoes(float numero1, float numero2, String operador) {
        return switch (operador){
            case "+" -> somar(numero1, numero2);
            case "-" -> subtrair(numero1, numero2);
            case "*" -> multiplicar(numero1, numero2);
            case "/" -> dividir(numero1, numero2);
            default -> throw new UnsupportedOperationException("Operador Invalida");
        };
    }
}
