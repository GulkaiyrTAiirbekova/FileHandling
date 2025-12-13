import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFromOneFileToAnother {
    public static void main(String[] args) throws IOException {

        // Print working directory
        System.out.println("Working directory: " + new File(".").getAbsolutePath());

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("D:\\projects\\FileHandling\\xanadu.txt");
            out = new FileOutputStream("outagain.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            System.out.println("File copied successfully.");

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

