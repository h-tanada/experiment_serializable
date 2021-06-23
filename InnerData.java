import java.io.Serializable;
import java.time.Instant;

public class InnerData implements Serializable {

    private static final long serialVersionUID = 7L;

    private String inner1;
    private String inner2;
    private String inner3 = "sankaku";
    private long innerlong;

    public InnerData(String data) {
        this.inner1 = "innerData1";
        this.inner2 = data;
        this.innerlong = Instant.now().toEpochMilli();
        this.inner3 = String.valueOf(this.innerlong);
    }

    @Override
    public String toString() {
        return "{ inner1: " + this.inner1 + ", inner2: " + this.inner2 + ", inner3: " + this.inner3 + ", innerlong: "
                + innerlong + "}";
    }
}
