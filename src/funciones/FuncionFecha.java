package funciones;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FuncionFecha {
    public static String fechaActual() {
        LocalDate fechaDeConsulta = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaDeConsulta.format(formato);
    }
}
