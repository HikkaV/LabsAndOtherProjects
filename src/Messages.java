public class Messages {
    public void Name(){
        System.out.print("Print your name :" + " ");
    }
    public void QuaRounds(){
        System.out.print("Enter the number of rounds:" + " ");
    }
    public void Exception(){
        System.out.println("You should have written number except of character or string, the quantity of rounds is 3.");
    }
    public void FirstTurn(){
        System.out.println("Everybody gets one card from a deck");

    }

    public void Possibilities(String name){
       System.out.println(name + " " + " has to decide if he wants to take the other card or to pass his turn");
        System.out.println("If you want to take a card ,ENTER 1, otherwise enter any character or  string");

    }
    public void PlayerPass(String name){
        System.out.println(name + " " + "decided to pass the turn");
    }
    public void PcTake(){
        System.out.println("Pc decided to take the card");

    }
    public void PcPass(){
        System.out.println("Pc decided to pass the turn.");

    }

    public void Count(int player, int pc){System.out.println("The count is : " + player + " : " + pc);
    }


}
