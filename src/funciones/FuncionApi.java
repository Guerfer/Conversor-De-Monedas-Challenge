package funciones;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class FuncionApi { //// se crea la constante toda en mayuscula y dividida por un raya al piso. llamada URL_API que contiene nuestra URL  ////
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/52537ea78000bf8f94b04fa5/latest/";

    /////// El metodo llamado obtenerCambio cumple la funcion de obtener las tasas de cambio de diferentes monedas por medio de la API ///////
    public double obtenerCambio (String tipoMonedaOrigen, String tipoMonedaDestino) { //// se toma dos valores de tipo String ////
        try {
            URL url = new URL(URL_API + tipoMonedaOrigen); /// une la URL_API + el tipo de moneda ingresado que se declaro en la clase principal  ///
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();  /// crea una conexión con la API ////
            BufferedReader leer = new BufferedReader(new InputStreamReader(conexion.getInputStream())); /// lee la respuesta en formato Json utilizando el BufferedReader ////
            Object JsonParser;
            JsonObject jsonResponse = com.google.gson.JsonParser.parseReader(leer).getAsJsonObject(); //// de la biblioteca Gson se usa para parsear la respuesta Json con el JsonParser ////

            JsonObject metodosDeConversion = jsonResponse.getAsJsonObject("conversion_rates");
            if (metodosDeConversion != null && metodosDeConversion.has(tipoMonedaDestino)) {
                return metodosDeConversion.get(tipoMonedaDestino).getAsDouble(); //// si cumple el valor sera devuelto como tipo double ////
            } else {
                System.out.println("No se encontro la tasa de cambio para la moneda de destino,"
                        + tipoMonedaDestino + " valida si los tipos de moneda estan en mayuscula"); /// si no existe el tipo de cambio genera este mensaje ////
                            return 0;
            }
            } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}
