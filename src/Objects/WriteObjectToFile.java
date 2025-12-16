package Objects;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class WriteObjectToFile {
    public static void main(String[] args) {
        try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            Employee emp = new Employee("John Doe", 30);
            out.writeObject(emp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
