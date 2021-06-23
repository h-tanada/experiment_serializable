import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseData implements Serializable {

    private static final long serialVersionUID = 10L;

    protected String data1 = "datadata";
    protected InnerData data2 = new InnerData("data3");

    public void outputData() {
        Path path = Paths.get("./", this.data1);
        StopWatch watch = new StopWatch(this.data1);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            Files.createDirectories(path.getParent());
            objectOutputStream.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.toString());
            watch.stop();
        }
    }

    public static BaseData get(String name) {
        Path path = Paths.get("./", name);
        StopWatch watch = new StopWatch("load " + name);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            BaseData data = (BaseData) objectInputStream.readObject();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            watch.stop();
        }
    }

    @Override
    public String toString() {
        return "{ data1: " + data1 + ", data2: " + data2 + "}";
    }
}
