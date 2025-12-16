import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams {
    public static void main(String[] args) {
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(new FileOutputStream("data_output.dat"))) {

            dataOutputStream.writeInt(42);
            dataOutputStream.writeDouble(3.14);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}