import java.util.Map;

public class Actions extends  Messages{
    public void firstResult(Map<String, Integer> graf, String origin , String destination){
        if (graf.containsKey(origin + "-" + destination)) {
           Result(origin, destination);
            System.out.print(" " + graf.get(origin + "-" + destination));
            System.exit(1);
        }

    }


    public  void Output(Map<Integer, String> lastgraf){for (Map.Entry entry : lastgraf.entrySet()) {
        System.out.println(entry.getValue() + " " + entry.getKey());
    }

    }


    }
