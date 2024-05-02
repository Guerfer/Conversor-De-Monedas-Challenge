package funciones;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FuncionFecha {
    public static String getCurrentDate() {
        LocalDate fechaDeConsulta = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaDeConsulta.format(formatter);
    }
}
