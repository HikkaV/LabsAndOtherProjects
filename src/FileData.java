import java.io.*;
import java.util.Scanner;

public class FileData {
    public void MakeFile() throws IOException {
        File InputData = new File("C:\\Users\\Andre\\InputData.txt");
        try {
            boolean created = InputData.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        FileWriter fw = new FileWriter("C:\\Users\\Andre\\InputData.txt");
        fw.write("5 \r\n1 2 5 \r\n1 3 3 \r\n1 5 4 \r\n2 4 6 \r\n2 5 2 \r\n3 4 4");

        fw.close();
    }

}