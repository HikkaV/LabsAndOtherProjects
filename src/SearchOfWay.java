import java.util.LinkedList;
import java.util.Map;

public class SearchOfWay {

    public void waySearch(Map<Pair, Integer> graf,  LinkedList<String> wayrep, String destination, String origin, String orbase) {
        int counter = 0;
        String way;
        StringBuilder sb = new StringBuilder();
        String string = "";
        int dest;
        StringBuilder stringBuilder = new StringBuilder();
        String helper = "";
        k:
        for (int i = 0; i < graf.size(); i++) {
            for (Map.Entry<Pair, Integer> item : graf.entrySet()) {
                if ((item.getKey().getFirst() + "-" + item.getKey().getSecond()).contains(origin) && (!(item.getKey().getFirst() + "-" + item.getKey().getSecond()).contains(destination))) {

                    if (item.getKey().getFirst() == Integer.parseInt(origin)) {
                        dest = item.getKey().getSecond();
                        way = origin + "-" + dest;
                        origin = dest + "";
                        counter++;

                        stringBuilder.append(way).append("-");
                        helper = stringBuilder.toString();

                    } else if (item.getKey().getSecond() == Integer.parseInt(origin)) {

                        dest = item.getKey().getFirst();
                        way = dest + "-" + origin;
                        origin = dest + "";

                        stringBuilder.append(way).append("-");
                        helper = stringBuilder.toString();
                        counter++;

                    }

                    Pair Key = item.getKey();
                    int key = item.getValue();
                    graf.remove(item.getKey());
                    graf.putIfAbsent(Key, key);
                    i--;
                    continue k;

                } else if ((item.getKey().getFirst() + "-" + item.getKey().getSecond()).contains(origin) && ((item.getKey().getFirst() + "-" + item.getKey().getSecond()).contains(destination))) {
                    if (counter > 0) {
                        string = origin + "-" + destination;

                        break;
                    } else {
                        wayrep.add(item.getKey().getFirst() + "-" + item.getKey().getSecond());
                        Pair Key = item.getKey();
                        int key = item.getValue();
                        graf.remove(item.getKey());
                        graf.putIfAbsent(Key, key);
                        i--;
                        continue k;

                    }

                }
            }

            sb.append(helper).append(string);
            wayrep.add(sb.toString());
            stringBuilder.replace(0, stringBuilder.length(), "");
            sb.replace(0, sb.length(), "");

            origin = orbase;


        }
    }
}