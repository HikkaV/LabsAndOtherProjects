import java.util.*;

class Actions  {
    public void GetCard(LinkedList<String> InStockCards) {

        InStockCards.add(Cards.CARDS.get(0));
       // Rules.CalcPoints(InStockCards);
        Cards.CARDS.remove(0);


    }

    public int ShowCounter(int Sum1, int Sum2) {
        int point = 0;
        if (Sum1 == 21) {

            point++;
            return point;


        } else if (Sum2 > 21) {
           point++;
            return point;


        } else {

            return 0;
        }
    }
public void PrintAndClear(int Sum1, LinkedList<String>InStockCards){
    System.out.println(Sum1);
    InStockCards.remove(0);
}
public  void GetAndPrint(LinkedList<String>InStockCards){GetCard(InStockCards);
    System.out.println(InStockCards);}

public int GetPointPc(LinkedList<String>InStockCards){
        int SumPc=0;
        GetCard(InStockCards);
    SumPc += Rules.CalcPoints(InStockCards);
    InStockCards.remove(0);
    return SumPc;}

public int AI(){ Random random = new Random();
int f = random.nextInt(4);
return f;

    }
    public static int input  (){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String str;
        Integer bounder = null;
        while(flag) {
            str = sc.nextLine();
            try{
                bounder=Integer.parseInt(str) ; flag=false;}
            catch (NumberFormatException e ){
                System.out.println(e);
            }
        }

        return bounder;
    }
}
