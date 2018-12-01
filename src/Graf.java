import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graf {
    public static void main(String[] args) throws IOException {
        FileData fileData = new FileData();
        ShowData showData = new ShowData();
        MainActions actions = new MainActions();
        fileData.MakeFile();
        // Pair<Integer, Integer> pair1 = new Pair<>(1, 2);
        GetMessages getMes = new GetMessages();
        Map<Pair, Integer> graf = new LinkedHashMap<>();
        Map<Integer, String> lastgraf = new TreeMap<>();
        FileReader fr = new FileReader("C:\\Users\\InputData.txt");
        Scanner sc = new Scanner(fr);
        String qua = "";
        while (sc.hasNext()) {
            qua = sc.next();
            while (sc.hasNextLine()) {

                graf.put(new Pair<>(sc.nextInt(), sc.nextInt()), Integer.parseInt(sc.next()));
            }
        }
        getMes.QuaOfPeaks(qua);
        showData.ShowMap(graf);
        String origin = actions.Checking(qua);
        String orbase = origin;
        String destination = actions.Checking(qua);
        int length = 0;
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
                        // dest = item.getKey().getSecond() + "";
                        dest = item.getKey().getSecond();
                        way = origin + "-" + dest;
                        length += graf.get(new Pair<>(Integer.parseInt(origin), dest));
                        origin = dest + "";
                        counter++;

                        stringBuilder.append(way).append("-");
                        helper = stringBuilder.toString();

                    } else if (item.getKey().getSecond() == Integer.parseInt(origin)) {

                        dest = item.getKey().getFirst();
                        way = dest + "-" + origin;
                        length += graf.get(new Pair<>(dest, Integer.parseInt(origin)));
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
                        Pair<Integer, Integer> pair1 = new Pair<>(Integer.parseInt(origin), Integer.parseInt(destination));
                        try {
                            length += graf.get(pair1);
                        } catch (NullPointerException e) {
                            string = destination + "-" + origin;
                            Pair<Integer, Integer> pair2 = new Pair<>(Integer.parseInt(destination), Integer.parseInt(origin));
                            length += graf.get(pair2);
                            System.out.print(e);
                            System.out.println();
                        }
                        break;
                    } else {
                        lastgraf.put(item.getValue(), item.getKey().getFirst() + "-" + item.getKey().getSecond());
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
            stringBuilder.replace(0, stringBuilder.length(), "");
            lastgraf.put(length, sb.toString());
            sb.replace(0, sb.length(), "");
            length = 0;
            origin = orbase;


        }
        showData.Output(lastgraf);
        getMes.FinalResult(lastgraf);


    }
}

