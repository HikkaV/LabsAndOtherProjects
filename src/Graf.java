import javax.swing.text.html.parser.Parser;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graf {
    public static void main(String[] args) throws IOException {
        FileData fileData = new FileData();
        ShowData showData = new ShowData();
        Actions actions = new Actions();
        fileData.MakeFile();
        Messages getMes = new Messages();
        Map<String, Integer> graf = new LinkedHashMap<>();
        TreeMap<Integer, String> lastgraf = new TreeMap<>();
        TreeMap<Integer, String> diametrgraf = new TreeMap<>();
        FileReader fr = new FileReader("C:\\Users\\Andre\\InputData.txt");
        Scanner sc = new Scanner(fr);
        //   Scanner scanner = new Scanner(System.in);
        String qua = "";
        while (sc.hasNext()) {
            qua = sc.next();
            while (sc.hasNextLine()) {
                graf.put(sc.next() + "-" + sc.next(), Integer.parseInt(sc.next()));
            }
        }
        getMes.QuaOfPeaks(qua);
        showData.ShowMap(graf);
      /*  String origin = scanner.next();
        String orbase = origin;
        while (Integer.parseInt(origin) > 5 || Integer.parseInt(origin) < 1) {
            getMes.WrongInput();
            origin = scanner.next();
        }
        String destination = scanner.next();
        while (Integer.parseInt(destination) > 5 || Integer.parseInt(destination) < 1) {
            getMes.WrongInput();
            destination = scanner.next();
        }

       actions.firstResult(graf, origin, destination);
       actions.firstResult(graf, destination, origin);

       */
        int length = 0;

        String way = "";
        StringBuilder sb = new StringBuilder();
        String string = "";
        String dest = "";
        StringBuilder stringBuilder = new StringBuilder();
        String helper = "";
        int counter = 0;
        for (int z = 1; z < 6; z++) {
            String origin = z + "";
            String orbase = origin;
            z:
            for (int f = 1; f < 6; f++) {
                String destination = f + "";
                k:
                for (int i = 0; i < graf.size(); i++) {
                    for (Map.Entry<String, Integer> item : graf.entrySet()) {
                        if (f == z) {
                            continue z;
                        }
                        if (item.getKey().contains(origin) && (!(item.getKey().contains(destination)))) {
                            if (item.getKey().charAt(0) == origin.charAt(0)) {
                                dest = item.getKey().charAt(2) + "";
                                way = origin + "-" + dest;
                                length += graf.get(way);
                                origin = dest;


                                stringBuilder.append(way).append("-");
                                helper = stringBuilder.toString();
                                counter++;

                            } else if (item.getKey().charAt(2) == origin.charAt(0)) {

                                dest = item.getKey().charAt(0) + "";
                                way = dest + "-" + origin;
                                length += graf.get(way);
                                origin = dest;

                                stringBuilder.append(way).append("-");
                                helper = stringBuilder.toString();
                                counter++;

                            }

                            String Key = item.getKey();
                            int key = item.getValue();
                            graf.remove(item.getKey());
                            graf.putIfAbsent(Key, key);
                            i--;
                            continue k;

                        } else if (item.getKey().contains(origin) && item.getKey().contains(destination)) {
                            if (counter > 0) {
                                string = origin + "-" + destination;

                                try {
                                    length += graf.get(string);
                                } catch (NullPointerException e) {
                                    string = destination + "-" + origin;
                                    length += graf.get(string);
                                    System.out.print(e);
                                    System.out.println();
                                }
                                break;
                            } else {
                                lastgraf.put(item.getValue(), item.getKey());
                                String Key = item.getKey();
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


                getMes.wayOfPeaks(orbase, destination);
                actions.Output(lastgraf);
                diametrgraf.put(lastgraf.firstEntry().getKey(), lastgraf.firstEntry().getValue());
                lastgraf.clear();
            }
           // diametrgraf.put(lastgraf.firstEntry().getKey(), lastgraf.firstEntry().getValue());
          //  lastgraf.clear();
        }
        System.out.println();
        actions.Output(diametrgraf);
        System.out.println();
        getMes.getDiameter(diametrgraf);
    }
}

