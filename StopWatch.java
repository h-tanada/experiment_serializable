import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StopWatch {
    private Instant startInstant = Instant.now();
    private Long resultMicros;
    private String name;

    public StopWatch(String name) {
        this.name = name;
    }

    public void stop() {
        if (this.resultMicros == null) {
            this.resultMicros = ChronoUnit.MICROS.between(startInstant, Instant.now());
        }
        System.out.println("StopWatch { name: " + this.name + ", result: "
                + (this.getMills() == null ? "not Yet" : this.getMills() + " ms") + "}");
    }

    private Double getMills() {
        if (this.resultMicros == null) {
            return null;
        }
        return ((double) this.resultMicros) / 1000;
    }
}
