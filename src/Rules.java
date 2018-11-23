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


        /*char find = InStockCards.get(0).charAt(0);

        switch (find) {
            case 'S':
                ek = 6;
                break;
            case '$':
                ek = 7;
                break;
            case 'E':
                ek = 8;
                break;
            case 'N':
                ek = 9;
                break;
            case 'T':
                ek = 10;
                break;
            case 'A':
                ek = 11;
                break;
            case 'K':
                ek = 4;
                break;
            case 'J':
                ek = 2;
                break;
            case 'L':
                ek = 3;
                break;

        }

     */



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


