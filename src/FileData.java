import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class FileData {
    private String path = "D:\\InputData.txt" ;
    String qua = "";
    public void MakeFile() throws IOException {
        File InputData = new File(path);

        try {
            boolean created = InputData.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        FileWriter fw = new FileWriter(path);
        fw.write("5 \r\n1 2 5 \r\n1 3 3 \r\n1 5 4 \r\n2 4 6 \r\n2 5 2 \r\n3 4 4");

        fw.close();
    }
    public void fillGraph(Map<Pair, Integer> graf) throws FileNotFoundException {
    FileReader fr = new FileReader(path);
    Scanner sc = new Scanner(fr);
        while (sc.hasNext()) {
        qua = sc.next();
        while (sc.hasNextLine()) {

            graf.put(new Pair<>(sc.nextInt(), sc.nextInt()), Integer.parseInt(sc.next()));}
        }
    }

}