package funciones;

public class FuncionConvertirValorMonedas {
    public double tipoCambio;

    public FuncionConvertirValorMonedas(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public double convertir (double valorConvertir) {
        return valorConvertir * tipoCambio;
    }
}
