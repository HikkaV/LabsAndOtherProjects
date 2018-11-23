import java.util.ArrayList;
import java.util.LinkedList;

class Rules {


  static int CalcPoints(LinkedList<String> InStockCards) {
        for(int i=0; i<Cards.RANKS.length; i++) {
            if (InStockCards.toString().contains(Cards.RANKS[i].toString())){
                return Cards.RANKS[i].getValue();

            }
        }
        return 0;
  }




    public boolean RuleOfEnd(int Sum1, int Sum2, String name) {
        if (Sum1 == 21) {
            System.out.println(name + " " + "has" + " : " + Sum1 + " " + "points");
            System.out.println(name + " " + "has won");
            return true;
        } else if (Sum2 == 21) {
            System.out.println("PC" + " " + "has" + " : " + Sum2 + " " + "points");
            System.out.println("Pc has won");
            return true;
        } else if (Sum1 > 21) {
            System.out.println(name + " " + "has" + " : " + Sum1 + " " + "points");
            System.out.println("Pc has won");
            return true;
        } else if (Sum2 > 21) {
            System.out.println("PC" + " " + "has" + " : " + Sum2 + " " + "points");
            System.out.println(name + " " + "has won");
            return true;
        } else if (Sum1 < 21 && Sum2 < 21) {
            return false;
        } else {
            System.out.println("PC" + " " + "has" + " : " + Sum2 + " " + "points");
            System.out.println(name + " " + "has" + " : " + Sum1 + " " + "points");
            System.out.println("Draw");
            return true;
        }
    }

}


