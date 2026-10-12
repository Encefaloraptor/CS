package practica.ejercicio52;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FormInfo {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha1;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha2;

    public long diasEntreFechas() {
        return Math.abs(ChronoUnit.DAYS.between(fecha1, fecha2));
    }

    public List<Integer> añosBisiestos() {
        LocalDate inicio = fecha1.isBefore(fecha2) ? fecha1 : fecha2;
        LocalDate fin = fecha1.isAfter(fecha2) ? fecha1 : fecha2;
        List<Integer> anios = new ArrayList<>();

        for (int anio = inicio.getYear(); anio <= fin.getYear(); anio++) {
            if (LocalDate.of(anio, 1, 1).isLeapYear()) {
                anios.add(anio);
            }
        }

        return anios;
    }

    public int domingoUnoEnero() {
        LocalDate inicio = fecha1.isBefore(fecha2) ? fecha1 : fecha2;
        LocalDate fin = fecha1.isAfter(fecha2) ? fecha1 : fecha2;
        int total = 0;

        for (int anio = inicio.getYear(); anio <= fin.getYear(); anio++) {
            LocalDate primeroDeEnero = LocalDate.of(anio, 1, 1);

            if (!primeroDeEnero.isBefore(inicio)
                    && !primeroDeEnero.isAfter(fin)
                    && primeroDeEnero.getDayOfWeek()
                            == java.time.DayOfWeek.SUNDAY) {
                total++;
            }
        }

        return total;
    }
}