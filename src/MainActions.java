import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainActions extends  GetMessages{


    public String Checking ( String qua){
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.next();
        while (Integer.parseInt(destination) > Integer.parseInt(qua) || Integer.parseInt(destination) < 1) {
            WrongInput();
            destination = scanner.next();
        }
        return destination;
    }


}
