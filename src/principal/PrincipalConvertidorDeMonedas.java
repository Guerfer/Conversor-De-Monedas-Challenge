import funciones.FuncionApi;
import funciones.FuncionConvertirValorMonedas;
import funciones.FuncionFecha;

import java.util.Scanner;
public class PrincipalConvertidorDeMonedas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n**********************************************************************************");
        System.out.println("***** BIENVENIDOS AL CONVERSOR DE MONEDAS *****");

        System.out.println("\n**********************************************************************************");
        System.out.print("Por favor ingrese su tipo de moneda, (ejemplo: COP): ");
        String tipoMonedaOrigen = teclado.nextLine().toUpperCase();

        System.out.println("\n**********************************************************************************");
        System.out.print("Por favor ingrese el tipo de moneda a convertir, (ejemplo: USD): ");
        String tipoMonedaDestino = teclado.nextLine().toUpperCase();

        System.out.println("\n**********************************************************************************");
        System.out.print("Por favor ingrese el valor que desea convertir: ");
        double valorConvertir = teclado.nextDouble();
        System.out.println("\n**********************************************************************************");

        // se obtiene los valores de los tipos de cambio
        FuncionApi funcionApi = new FuncionApi();
        double tipoCambio = funcionApi.obtenerCambio(tipoMonedaOrigen, tipoMonedaDestino);

        // Se obtiene la conversion de la moneda
        FuncionConvertirValorMonedas convertir = new FuncionConvertirValorMonedas(funcionApi.obtenerCambio(tipoMonedaOrigen, tipoMonedaDestino));
        double totalConvertido = convertir.convertir(valorConvertir);

        // Se obtiene la fecha actual
        String fechaDeConsulta = FuncionFecha.fechaActual();


        System.out.println("El valor que se ingreso para convertir fue: " + valorConvertir + " " + tipoMonedaOrigen + " el cual es igual a " + totalConvertido + " " + tipoMonedaDestino + " en la fecha: " + fechaDeConsulta);
        System.out.println("\n***** Finalizo la ejecucion del programa *****");

    }
}
