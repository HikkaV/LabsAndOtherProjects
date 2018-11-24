

import java.util.Map;
import java.util.TreeMap;

public class GetMessages {
    public void WrongInput(){
        System.out.println("You entered the wrong data , your input data has to be in range [1:5]");
    }
    public void Result(String origin, String destination){
        System.out.println("The best way to your destination is:"+ " "+ origin+"-"+destination);
        System.out.print("The length of this way is :");
    }
    public void FinalResult( Map<Integer, String> lastgraf ){
        System.out.println("length = way : " + " ");
        System.out.print(((TreeMap<Integer, String>) lastgraf).firstEntry());
    }
public void QuaOfPeaks(String qua){
    System.out.println("The graf consists of 5 peaks");
}
}
