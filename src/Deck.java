import java.lang.Math;
import java.util.ArrayList;

public class Deck {

    private ArrayList<Player> arrayPlayers = new ArrayList<Player>();
    private int[] arrayDeck = new int[52];
    private int cardToDraw = 0;

    public Deck(int numPlayers, double startingMoney) {
        for(int i = 0; i < numPlayers; i++) {
            arrayPlayers.add(new Player(startingMoney));
        }
        Dealer mainDealer = new Dealer(); 
    }

    public void startRound() {
        cardToDraw = 0;

        for(int i = 0; i < 51; i++) {
            arrayDeck[i] = i;
        }
        
        for(int j = 0; i < 51; i++) {
            int shuffle = Math.random()*52;
            int temp = arrayDeck[j];
            arrayDeck[j] = arrayDeck[shuffle];
            arrayDeck[shuffle] = temp;
        }

        for(Player P:arrayPlayers) {
            P.hand = new ArrayList<Integer>();
            P.splitHand = new ArrayList<Integer>();
            P.softTotal = 0;
            P.hardTotal = 0;
            P.splitSoftTotal = 0;
            P.splitHardTotal = 0;
            P.betAmount = 0;
            P.betA = 0;
        }

        mainDealer.hand = new ArrayList<Integer>();
        mainDealer.softTotal = 0;
        mainDealer.hardTotal = 0;
    }

    public Player deal(int playerNum) {
        arrayPlayer.get(playerNum).hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        arrayPlayer.get(playerNum).hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        
        playerHandTotal(playerNum);
        
        return arrayPlayer.get(playerNum);
    }

    public ArrayList dealDealer() {
        mainDealer.hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        mainDealer.hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;

        dealerHandTotal();

        return mainDealer;
    }

    private void playerHandTotal(int playerNum) {
        arrayPlayer.get(playerNum).softTotal = 0;
        arrayPlayer.get(playerNum).hardTotal = 0;
        boolean ace = false;
        for (int card:arrayPlayer.get(playerNum).hand) {
            if ( card%13 == 0 && !ace) {
                arrayPlayer.get(playerNum).softTotal += 11;
                arrayPlayer.get(playerNum).hardTotal += 1;
                arrayPlayer.get(playerNum).oneAceAs11Total += 11;
                ace = true;
            } else if ( card%13 == 0 && ace) {
                arrayPlayer.get(playerNum).softTotal += 11;
                arrayPlayer.get(playerNum).hardTotal += 1;
                arrayPlayer.get(playerNum).oneAceAs11Total += 1;
            } else if (card%13 < 10) {
                arrayPlayer.get(playerNum).softTotal += card%13;
                arrayPlayer.get(playerNum).hardTotal += card%13;
                arrayPlayer.get(playerNum).oneAceAs11Total += card%13;
            } else {
                arrayPlayer.get(playerNum).softTotal += 10;
                arrayPlayer.get(playerNum).hardTotal += 10;
                arrayPlayer.get(playerNum).oneAceAs11Total += 10;
            } 
        }

        if(arrayPlayer.get(playerNum).splitHand.size() != 0) {
            ace = false;
            arrayPlayer.get(playerNum).splitSoftTotal = 0;
            arrayPlayer.get(playerNum).splitHardTotal = 0;
            for (int card:arrayPlayer.get(playerNum).hand) {
                if ( card%13 == 0 && !ace) {
                    arrayPlayer.get(playerNum).splitSoftTotal += 11;
                    arrayPlayer.get(playerNum).splitHardTotal += 1;
                    arrayPlayer.get(playerNum).splitOneAceAs11Total += 11;
                    ace = true;
                } else if ( card%13 == 0 && ace) {
                    arrayPlayer.get(playerNum).splitSoftTotal += 11;
                    arrayPlayer.get(playerNum).splitHardTotal += 1;
                    arrayPlayer.get(playerNum).splitOneAceAs11Total += 1;
                } else if (card%13 < 10) {
                    arrayPlayer.get(playerNum).splitSoftTotal += card%13;
                    arrayPlayer.get(playerNum).splitHardTotal += card%13;
                    arrayPlayer.get(playerNum).splitOneAceAs11Total += card%13;
                } else {
                    arrayPlayer.get(playerNum).splitSoftTotal += 10;
                    arrayPlayer.get(playerNum).splitHardTotal += 10;
                    arrayPlayer.get(playerNum).splitOneAceAs11Total += 10;
                }
            }
        }
    }

    private void dealerHandTotal() {
        mainDealer.softTotal += 0;
        mainDealer.hardTotal += 0;
        boolean ace = false;
        for (int card:mainDealer.hand) {
            if ( card%13 == 0 && !ace) {
                mainDealer.softTotal += 11;
                mainDealer.hardTotal += 1;
                mainDealer.oneAceAs11Total += 11;
                ace = true;
            }else if ( card%13 == 0 && ace) {
                mainDealer.softTotal += 11;
                mainDealer.hardTotal += 1;
                mainDealer.oneAceAs11Total += 1;
            } else if (card%13 < 10) {
                mainDealer.softTotal += card%13;
                mainDealer.hardTotal += card%13;
                mainDealer.oneAceAs11Total += card%13;
            } else {
                mainDealer.softTotal += 10;
                mainDealer.hardTotal += 10;
                mainDealer.oneAceAs11Total += 10;
            } 
        }
    }

    public Player hit(int playerNum) {
        if(arrayPlayer.get(playerNum).playSplitHand) {
            arrayPlayer.get(playerNum).splitHand.add(arrayDeck[cardToDraw]);
            cardToDraw++;
        } else {
            arrayPlayer.get(playerNum).hand.add(arrayDeck[cardToDraw]);
            cardToDraw++;
        }
        
        playerHandTotal(playerNum);

        if (arrayPlayer.get(playerNum).splitHand.size() != 0 && arrayPlayer.get(playerNum).hardTotal > 21) {
            arrayPlayer.get(playerNum).playSplitHand = true;
        }

        return arrayPlayer.get(playerNum); 
    }

    public Player doubleDown(int playerNum) {
        arrayPlayer.get(playerNum).hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        
        playerHandTotal(playerNum);
        arrayPlayer.get(playerNum).money -= arrayPlayer.get(playerNum).bet;
        arrayPlayer.get(playerNum).bet *= 2;

        return arrayPlayer.get(playerNum); 
    }

    public Player split(int playerNum) {
        arrayPlayer.get(playerNumber).splitHand.add(arrayPlayer.get(playerNum).hand.get(0));
        arrayPlayer.get(playerNumber).hand.remove(0);
        
        playerHandTotal(playerNum);

        return arrayPlayer.get(playerNum);
    } 

    public void standSplitHand(int playerNum) {
        arrayPlayer.get(playerNumber).playSplitHand = true;
    }

    public Dealer finalDealerHand() {
        while(mainDealer.softTotal <= 16) {
            mainDealer.hand.add(arrayDeck[cardToDraw]);
            cardToDraw++;

            dealerHandTotal();
        }

        if(mainDealer.oneAceAs11Total <= 16 && mainDealer.softTotal > 21) {
            while(mainDealer.oneAceAs11Total <= 16) {
                mainDealer.hand.add(arrayDeck[cardToDraw]);
                cardToDraw++;

                dealerHandTotal();
            }
        }

        if(mainDealer.hardTotal <= 16 && mainDealer.oneAceAs11Total > 21) {
            while(mainDealer.hardTotal <= 16) {
                mainDealer.hand.add(arrayDeck[cardToDraw]);
                cardToDraw++;

                dealerHandTotal();
            }
        }

        return mainDealer;
    }

    public Player bet(int playerNum, double betAmount) {
        arrayPlayer.get(playerNum).bet = betAmount;
        arrayPlayer.get(playerNum).money -= betAmount;

        return arrayPlayer.get(playerNum);
    } 

    public Player payout(int playerNum) {
        int dealerHighestTotal, handHighestTotal, splitHandHighestTotal;

        if(mainDealer.softTotal <= 21) {
            dealerHighestTotal = mainDealer.softTotal;
        } else if (mainDealer.oneAceAs11Total <= 21) {
            dealerHighestTotal = mainDealer.oneAceAs11Total;
        } else {
            dealerHighestTotal = mainDealer.hardTotal;
        }

        if(arrayPlayer.get(playerNum).softTotal <= 21) {
            handHighestTotal = arrayPlayer.get(playerNum).softTotal;
        } else if (arrayPlayer.get(playerNum).oneAceAs11Total <= 21) {
            handHighestTotal = arrayPlayer.get(playerNum).oneAceAs11Total;
        } else {
            handHighestTotal = arrayPlayer.get(playerNum).hardTotal;
        }
        

        if (arrayPlayer.get(playerNum).splitHand.size() != 0) {
            if(arrayPlayer.get(playerNum).splitSoftTotal <= 21) {
                splitHandHighestTotal = arrayPlayer.get(playerNum).splitSoftTotal;
            } else if (arrayPlayer.get(playerNum).splitOneAceAs11Total <= 21) {
                splitHandHighestTotal = arrayPlayer.get(playerNum).splitOneAceAs11Total;
            } else {
                splitHandHighestTotal = arrayPlayer.get(playerNum).splitHardTotal;
            }

            if(splitHandHighestTotal > 21 ) {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount/2;
            } else if(dealerHighestTotal > 21 || splitHandHighestTotal > dealerHighestTotal) {
                arrayPlayer.get(playerNum).winAmount += arrayPlayer.get(playerNum).betAmount/2; 
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).winAmount * 2;
            } else if(splitHandHighestTotal == dealerHighestTotal) {
                arrayPlayer.get(playerNum).winAmount += 0; 
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).betAmount * 0.5;
            } else {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount/2; 
            }

            if(handHighestTotal > 21 ) {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount/2;
            } else if(dealerHighestTotal > 21 || handHighestTotal > dealerHighestTotal) {
                arrayPlayer.get(playerNum).winAmount += arrayPlayer.get(playerNum).betAmount/2; 
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).winAmount * 2;
            } else if(handHighestTotal == dealerHighestTotal) {
                arrayPlayer.get(playerNum).winAmount += 0; 
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).betAmount/2;
            } else {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount/2; 
            }

        } else {
            if(handHighestTotal > 21 ) {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount;
                arrayPlayer.get(playerNum).betAmount *= 0;
            } else if (handHighestTotal == 21 && arrayPlayer.get(playerNum).hand.size() == 2) {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount * 1.5;
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).betAmount * 2.5;
                arrayPlayer.get(playerNum).betAmount *= 0;
            } else if(dealerHighestTotal > 21 || handHighestTotal > dealerHighestTotal) {
                arrayPlayer.get(playerNum).winAmount += arrayPlayer.get(playerNum).betAmount; 
                arrayPlayer.get(playerNum).betAmount = 0;
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).winAmount * 2;
            } else if(handHighestTotal == dealerHighestTotal) {
                arrayPlayer.get(playerNum).winAmount += 0; 
                arrayPlayer.get(playerNum).money += arrayPlayer.get(playerNum).betAmount;
                arrayPlayer.get(playerNum).betAmount = 0;
            } else {
                arrayPlayer.get(playerNum).winAmount -= arrayPlayer.get(playerNum).betAmount; 
                arrayPlayer.get(playerNum).betAmount = 0;
            }
        }        

        return arrayPlayer.get(playerNum);
    }

    public Player getPlayer(int playerNum) {
        return arrayPlayer.get(playerNum);
    }
}
