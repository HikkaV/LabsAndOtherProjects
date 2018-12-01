import java.util.LinkedList;
import java.util.Map;

public class SearchOfLength {

    public void lengthSearch(Map<Pair, Integer> graf, LinkedList<Integer> valuerep, String destination, String origin, String orbase) {
        int length = 0;
        int counter = 0;
        int dest;
        k:
        for (int i = 0; i < graf.size(); i++) {
            for (Map.Entry<Pair, Integer> item : graf.entrySet()) {
                if ((item.getKey().getFirst() + "-" + item.getKey().getSecond()).contains(origin) && (!(item.getKey().getFirst() + "-" + item.getKey().getSecond()).contains(destination))) {

                    if (item.getKey().getFirst() == Integer.parseInt(origin)) {
                        dest = item.getKey().getSecond();

                        length += graf.get(new Pair<>(Integer.parseInt(origin), dest));
                        origin = dest + "";
                        counter++;


                    } else if (item.getKey().getSecond() == Integer.parseInt(origin)) {

                        dest = item.getKey().getFirst();

                        length += graf.get(new Pair<>(dest, Integer.parseInt(origin)));
                        origin = dest + "";


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

                        try {
                            length += graf.get(new Pair<>(Integer.parseInt(origin), Integer.parseInt(destination)));
                        } catch (NullPointerException e) {

                            length += graf.get(new Pair<>(Integer.parseInt(destination), Integer.parseInt(origin)));
                            System.out.print(e);
                            System.out.println();
                        }
                        break;
                    } else {
                        valuerep.add(item.getValue());
                        Pair Key = item.getKey();
                        int key = item.getValue();
                        graf.remove(item.getKey());
                        graf.putIfAbsent(Key, key);
                        i--;
                        continue k;

                    }

                }
            }
            valuerep.add(length);
            length = 0;
            origin = orbase;
        }
    }
}
