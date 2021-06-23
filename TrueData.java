import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TrueData extends BaseData {

    private static final long serialVersionUID = 9L;
    private String x;
    private List<Long> longList;

    public TrueData(String name, List<Long> longList) {
        super();
        this.data1 = name;
        this.x = "xxx" + name + "xxx";
        this.longList = longList;
    }

    @Override
    public String toString() {
        return "{ data1: " + data1 + ", data2: " + data2 + ", x: " + x + ", longList: [" + longListToString() + "]}";
    }

    public String longListToString() {
        if (this.longList == null) {
            return null;
        }
        return this.longList.parallelStream().limit(100).map(String::valueOf).collect(Collectors.joining(", "));
    }
}
