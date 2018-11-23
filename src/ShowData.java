import java.util.ArrayList;
import java.util.Map;

public class ShowData {
    public void ShowMap(Map<String, Integer> graf){
        for (Map.Entry<String, Integer> item : graf.entrySet()) {

            System.out.printf("Number of side %s  Value: %s \n", item.getKey(), item.getValue());
        }
    }
    public void ShowAllData(ArrayList<Integer> values, ArrayList<String> route){
        for (int i = 0; i <values.size() ; i++) {
            System.out.println("The way :"+" "+ route.get(i));
            System.out.println("The length : "+ values.get(i));
            System.out.println();
        }
    }
}
