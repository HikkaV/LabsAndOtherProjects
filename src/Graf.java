import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graf {
    public static void main(String[] args) throws IOException {
        FileData fileData = new FileData();
        MainActions actions = new MainActions();
        fileData.MakeFile();
        GetMessages getMes = new GetMessages();
        Map<Pair, Integer> graf = new LinkedHashMap<>();
        Map<Integer, String> lastgraf = new TreeMap<>();
        LinkedList<Integer> valuerep = new LinkedList<>();
        LinkedList<String> wayrep = new LinkedList<>();
        SearchOfLength searchOfLength = new SearchOfLength();
        SearchOfWay searchOfWay = new SearchOfWay();
        fileData.fillGraph(graf);
        getMes.QuaOfPeaks(fileData.qua);
        getMes.ShowMap(graf);
        String origin = actions.Checking(fileData.qua);
        String orbase = origin;
        String destination = actions.Checking(fileData.qua);
        searchOfLength.lengthSearch(graf, valuerep, destination, origin, orbase);
        searchOfWay.waySearch(graf, wayrep, destination, origin, orbase);
        actions.MakeGraph(lastgraf, valuerep, wayrep);
        getMes.Output(lastgraf);
        getMes.FinalResult(lastgraf);


    }
}

