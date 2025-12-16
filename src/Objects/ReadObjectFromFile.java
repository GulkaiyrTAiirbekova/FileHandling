package Objects;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ReadObjectFromFile {
    public static void main(String[] args) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("employee.ser"))) {

            Employee emp = new Employee("John Doe", 30);
            out.writeObject(emp);

            System.out.println("Employee object serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
