import java.util.ArrayList;
import java.util.Map;

public class ShowData {
    public void ShowMap(Map<Pair, Integer> graf){
        for (Map.Entry<Pair, Integer> item : graf.entrySet()) {

            System.out.printf("Number of side %s  Value: %s \n", item.getKey().getFirst()+"-"+item.getKey().getSecond(), item.getValue());
        }
    }
    public  void Output(Map<Integer, String> lastgraf){for (Map.Entry entry : lastgraf.entrySet()) {
        System.out.println(entry.getValue() + " " + entry.getKey());
    }}
}
