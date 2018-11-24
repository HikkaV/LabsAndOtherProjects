import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graf {
    public static void main(String[] args) throws IOException {
        FileData fileData = new FileData();
        ShowData showData = new ShowData();
        MainActions actions = new MainActions();
        fileData.MakeFile();
        GetMessages getMes = new GetMessages();
        Map<String, Integer> graf = new LinkedHashMap<>();
        Map<Integer, String> lastgraf = new TreeMap<>();
        FileReader fr = new FileReader("C:\\Users\\Andre\\InputData.txt");
        Scanner sc = new Scanner(fr);
        Scanner scanner = new Scanner(System.in);
        String qua = "";
        while (sc.hasNext()) {
            qua = sc.next();
            while (sc.hasNextLine()) {
                graf.put(sc.next() + "-" + sc.next(), Integer.parseInt(sc.next()));
            }
        }
        getMes.QuaOfPeaks(qua);
        showData.ShowMap(graf);
        String origin = scanner.next();
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

        int length = 0;

        String way = "";
        StringBuilder sb = new StringBuilder();
        String string = "";
        String dest = "";
        StringBuilder stringBuilder = new StringBuilder();
        String helper = "";
        k:
        for (int i = 0; i < graf.size(); i++) {
            for (Map.Entry<String, Integer> item : graf.entrySet()) {
                if (item.getKey().contains(origin) && (!(item.getKey().contains(destination)))) {
                    if (item.getKey().charAt(0) == origin.charAt(0)) {
                        dest = item.getKey().charAt(2) + "";
                        way = origin + "-" + dest;
                        length += graf.get(way);
                        origin = dest;


                        stringBuilder.append(way + "-");
                        helper = stringBuilder.toString();

                    } else if (item.getKey().charAt(2) == origin.charAt(0)) {

                        dest = item.getKey().charAt(0) + "";
                        way = dest + "-" + origin;
                        length += graf.get(way);
                        origin = dest;

                        stringBuilder.append(way+ "-");
                        helper = stringBuilder.toString();


                    }

                    String Key = item.getKey();
                    int key = item.getValue();
                    graf.remove(item.getKey());
                    graf.putIfAbsent(Key, key);
                    i--;
                    continue k;

                } else if (item.getKey().contains(origin) && item.getKey().contains(destination)) {
                    string = origin + "-" + destination;
                    // actions.Exception(graf, string, length , destination, origin);
                    try {
                        length += graf.get(string);
                    } catch (NullPointerException e) {
                        string = destination + "-" + origin;
                        length += graf.get(string);
                        System.out.print(e);
                        System.out.println();
                    }
                    break;
                }

            }

            sb.append(helper).append(string);
            stringBuilder.replace(0, stringBuilder.length(), "");
            lastgraf.put(length, sb.toString());
            sb.replace(0, sb.length(), "");
            length = 0;
            origin = orbase;


        }
        actions.Output(lastgraf);
        getMes.FinalResult(lastgraf);


    }
}

