import java.util.ArrayList;

public class Player {
    public int softTotal, oneAceAs11Total, hardTotal, splitSoftTotal, splitHardTotal, splitOneAceAs11Total;
    public double money, betAmount, winAmount;
    boolean playSplitHand;
    ArrayList<Integer> hand, splitHand;

    public Player(double startingMoney) {
        money = startingMoney;
    }

}
