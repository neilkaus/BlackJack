/**
* class for needed player information
*
* date     20200824
* @author neil
* @version 1.0
* @see    Assignment 4.3
*/
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
