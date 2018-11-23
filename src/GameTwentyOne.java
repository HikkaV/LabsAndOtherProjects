import java.util.*;

class GameTwentyOne {
    public static void main(String[] args) {
        Cards cards = new Cards();
        Rules rules = new Rules();
        Actions actions = new Actions();
        Messages message = new Messages();
        Scanner sc = new Scanner(System.in);
        LinkedList<String> InStockCards = new LinkedList<>();
        message.Name();
        String name = sc.nextLine();
        message.QuaRounds();
        byte counter = 0;
        byte player = 0;
        byte pc = 0;


      


        while (counter < Actions.input()) {
            int SumPlayer = 0;
            int SumPc = 0;

            cards.MakeDeck();

            message.FirstTurn();


            SumPc += actions.GetPointPc(InStockCards);
            actions.GetAndPrint(InStockCards);

            SumPlayer += rules.CalcPoints(InStockCards);
            actions.PrintAndClear(SumPlayer, InStockCards);


            while (!rules.RuleOfEnd(SumPlayer, SumPc, name)) {
                message.Possibilities(name);
                String q = sc.next();

                if (q.equals("1")) {
                    actions.GetAndPrint(InStockCards);
                    SumPlayer += rules.CalcPoints(InStockCards);
                    actions.PrintAndClear(SumPlayer, InStockCards);
                } else {
                    message.PlayerPass(name);
                }




                if (actions.AI() == 1 || actions.AI() == 0) {
                    message.PcTake();

                    SumPc += actions.GetPointPc(InStockCards);

                } else {
                    message.PcPass();
                }


            }
            counter++;

            player += actions.ShowCounter(SumPlayer, SumPc);
            pc += actions.ShowCounter(SumPc, SumPlayer);
            message.Count(player, pc);

        }


    }
}




