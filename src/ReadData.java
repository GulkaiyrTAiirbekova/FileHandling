import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream("data_output.dat"))) {

            int number = dis.readInt();
            double value = dis.readDouble();

            System.out.println(number); // 42
            System.out.println(value);  // 3.14

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
