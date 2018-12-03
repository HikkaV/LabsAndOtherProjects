import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class MainActions extends GetMessages {


    public String Checking(String qua) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.next();
        while (Integer.parseInt(destination) > Integer.parseInt(qua) || Integer.parseInt(destination) < 1) {
            WrongInput();
            destination = scanner.next();
        }
        return destination;
    }

    public void MakeGraf(Map<Integer, String> lastgraf, LinkedList<Integer> valuerep, LinkedList<String> wayrep) {
        for (int i = 0; i < valuerep.size(); i++) {
            lastgraf.put(valuerep.get(i), wayrep.get(i));
        }
    }
}
