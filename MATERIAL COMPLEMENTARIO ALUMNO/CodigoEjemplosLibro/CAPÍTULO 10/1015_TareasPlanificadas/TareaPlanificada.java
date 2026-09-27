@Component
@EnableScheduling
public class TareaPlanificada {
    @Scheduled(fixedDelay = 1000 * 60)
    public void tarea1() {
        System.out.println("Ejecución cada minuto:" + LocalDateTime.now());
    }

    @Scheduled(cron = "00 15 10 * * * ") // todos los días a la 10:15h
    public void tareaAhoraFija() {
        System.out.println("Ejecución a una hora dada:"
                + LocalDateTime.now());
    }
}