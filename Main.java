import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        String mill = String.valueOf(Instant.now().toEpochMilli());
        BaseData trueData = new TrueData(mill, getRange(50, 1000));
        trueData.outputData();
        Path savePath = Paths.get("./");
        try {
            Files.walk(savePath).map(Path::getFileName).filter(file -> file.toString().startsWith("16"))
                    .map(Path::toString).map(BaseData::get).forEach(b -> show(b));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void show(BaseData baseData) {
        if (baseData instanceof TrueData trueData3) {
            System.out.println("TrueData");
            System.out.println(trueData3);
        } else {
            System.out.println("BaseData");
            System.out.println(baseData);
        }
    }

    private static List<Long> getRange(long from, long to) {
        return LongStream.rangeClosed(from, to).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}