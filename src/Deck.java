import java.util.ArrayList;

public class Deck {

    private ArrayList<Player> arrayPlayers = new ArrayList<>();
    private int[] arrayDeck = new int[52];
    private int cardToDraw = 0;
    private Dealer mainDealer;

    public Deck(int numPlayers, double startingMoney) {
        for(int i = 0; i < numPlayers; i++) {
            arrayPlayers.add(new Player(startingMoney));
        }
        mainDealer = new Dealer(); 
    }

    public void startRound() {
        cardToDraw = 0;

        for(int i = 0; i < 51; i++) {
            arrayDeck[i] = i;
        }
        
        for(int j = 0; j < 51; j++) {
            int shuffle = (int) (Math.random() * 52);
            int temp = arrayDeck[j];
            arrayDeck[j] = arrayDeck[shuffle];
            arrayDeck[shuffle] = temp;
        }

        for(Player P:arrayPlayers) {
            P.hand = new ArrayList<>();
            P.splitHand = new ArrayList<>();
            P.softTotal = 0;
            P.hardTotal = 0;
            P.splitSoftTotal = 0;
            P.splitHardTotal = 0;
            P.betAmount = 0;
            P.winAmount = 0;
        }

        mainDealer.hand = new ArrayList<>();
        mainDealer.softTotal = 0;
        mainDealer.hardTotal = 0;
    }

    public Player deal(int playerNum) {
        arrayPlayers.get(playerNum).hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        arrayPlayers.get(playerNum).hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        
        playerHandTotal(playerNum);
        
        return arrayPlayers.get(playerNum);
    }

    public Dealer dealDealer() {
        mainDealer.hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        mainDealer.hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;

        dealerHandTotal();

        return mainDealer;
    }

    private void playerHandTotal(int playerNum) {
        arrayPlayers.get(playerNum).softTotal = 0;
        arrayPlayers.get(playerNum).hardTotal = 0;
        boolean ace = false;
        for (int card:arrayPlayers.get(playerNum).hand) {
            if ( card%13 == 0 && !ace) {
                arrayPlayers.get(playerNum).softTotal += 11;
                arrayPlayers.get(playerNum).hardTotal += 1;
                arrayPlayers.get(playerNum).oneAceAs11Total += 11;
                ace = true;
            } else if ( card%13 == 0 && ace) {
                arrayPlayers.get(playerNum).softTotal += 11;
                arrayPlayers.get(playerNum).hardTotal += 1;
                arrayPlayers.get(playerNum).oneAceAs11Total += 1;
            } else if (card%13 < 10) {
                arrayPlayers.get(playerNum).softTotal += card%13;
                arrayPlayers.get(playerNum).hardTotal += card%13;
                arrayPlayers.get(playerNum).oneAceAs11Total += card%13;
            } else {
                arrayPlayers.get(playerNum).softTotal += 10;
                arrayPlayers.get(playerNum).hardTotal += 10;
                arrayPlayers.get(playerNum).oneAceAs11Total += 10;
            } 
        }

        if(!arrayPlayers.get(playerNum).splitHand.isEmpty()) {
            ace = false;
            arrayPlayers.get(playerNum).splitSoftTotal = 0;
            arrayPlayers.get(playerNum).splitHardTotal = 0;
            for (int card:arrayPlayers.get(playerNum).hand) {
                if ( card%13 == 0 && !ace) {
                    arrayPlayers.get(playerNum).splitSoftTotal += 11;
                    arrayPlayers.get(playerNum).splitHardTotal += 1;
                    arrayPlayers.get(playerNum).splitOneAceAs11Total += 11;
                    ace = true;
                } else if ( card%13 == 0 && ace) {
                    arrayPlayers.get(playerNum).splitSoftTotal += 11;
                    arrayPlayers.get(playerNum).splitHardTotal += 1;
                    arrayPlayers.get(playerNum).splitOneAceAs11Total += 1;
                } else if (card%13 < 10) {
                    arrayPlayers.get(playerNum).splitSoftTotal += card%13;
                    arrayPlayers.get(playerNum).splitHardTotal += card%13;
                    arrayPlayers.get(playerNum).splitOneAceAs11Total += card%13;
                } else {
                    arrayPlayers.get(playerNum).splitSoftTotal += 10;
                    arrayPlayers.get(playerNum).splitHardTotal += 10;
                    arrayPlayers.get(playerNum).splitOneAceAs11Total += 10;
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
        if(arrayPlayers.get(playerNum).playSplitHand) {
            arrayPlayers.get(playerNum).splitHand.add(arrayDeck[cardToDraw]);
            cardToDraw++;
        } else {
            arrayPlayers.get(playerNum).hand.add(arrayDeck[cardToDraw]);
            cardToDraw++;
        }
        
        playerHandTotal(playerNum);

        if (!arrayPlayers.get(playerNum).splitHand.isEmpty() && arrayPlayers.get(playerNum).hardTotal > 21) {
            arrayPlayers.get(playerNum).playSplitHand = true;
        }

        return arrayPlayers.get(playerNum); 
    }

    public Player doubleDown(int playerNum) {
        arrayPlayers.get(playerNum).hand.add(arrayDeck[cardToDraw]);
        cardToDraw++;
        
        playerHandTotal(playerNum);
        arrayPlayers.get(playerNum).money -= arrayPlayers.get(playerNum).betAmount;
        arrayPlayers.get(playerNum).betAmount *= 2;

        return arrayPlayers.get(playerNum); 
    }

    public Player split(int playerNum) {
        arrayPlayers.get(playerNum).splitHand.add(arrayPlayers.get(playerNum).hand.get(0));
        arrayPlayers.get(playerNum).hand.remove(0);
        
        playerHandTotal(playerNum);

        return arrayPlayers.get(playerNum);
    } 

    public void standSplitHand(int playerNum) {
        arrayPlayers.get(playerNum).playSplitHand = true;
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
        arrayPlayers.get(playerNum).betAmount = betAmount;
        arrayPlayers.get(playerNum).money -= betAmount;

        return arrayPlayers.get(playerNum);
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

        if(arrayPlayers.get(playerNum).softTotal <= 21) {
            handHighestTotal = arrayPlayers.get(playerNum).softTotal;
        } else if (arrayPlayers.get(playerNum).oneAceAs11Total <= 21) {
            handHighestTotal = arrayPlayers.get(playerNum).oneAceAs11Total;
        } else {
            handHighestTotal = arrayPlayers.get(playerNum).hardTotal;
        }
        

        if (!arrayPlayers.get(playerNum).splitHand.isEmpty()) {
            if(arrayPlayers.get(playerNum).splitSoftTotal <= 21) {
                splitHandHighestTotal = arrayPlayers.get(playerNum).splitSoftTotal;
            } else if (arrayPlayers.get(playerNum).splitOneAceAs11Total <= 21) {
                splitHandHighestTotal = arrayPlayers.get(playerNum).splitOneAceAs11Total;
            } else {
                splitHandHighestTotal = arrayPlayers.get(playerNum).splitHardTotal;
            }

            if(splitHandHighestTotal > 21 ) {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount/2;
            } else if(dealerHighestTotal > 21 || splitHandHighestTotal > dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += arrayPlayers.get(playerNum).betAmount/2; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).winAmount * 2;
            } else if(splitHandHighestTotal == dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += 0; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).betAmount * 0.5;
            } else {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount/2; 
            }

            if(handHighestTotal > 21 ) {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount/2;
            } else if(dealerHighestTotal > 21 || handHighestTotal > dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += arrayPlayers.get(playerNum).betAmount/2; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).winAmount * 2;
            } else if(handHighestTotal == dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += 0; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).betAmount/2;
            } else {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount/2; 
            }

        } else {
            if(handHighestTotal > 21 ) {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount;
                arrayPlayers.get(playerNum).betAmount *= 0;
            } else if (handHighestTotal == 21 && arrayPlayers.get(playerNum).hand.size() == 2) {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount * 1.5;
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).betAmount * 2.5;
                arrayPlayers.get(playerNum).betAmount *= 0;
            } else if(dealerHighestTotal > 21 || handHighestTotal > dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += arrayPlayers.get(playerNum).betAmount; 
                arrayPlayers.get(playerNum).betAmount = 0;
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).winAmount * 2;
            } else if(handHighestTotal == dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += 0; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).betAmount;
                arrayPlayers.get(playerNum).betAmount = 0;
            } else {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount; 
                arrayPlayers.get(playerNum).betAmount = 0;
            }
        }        

        return arrayPlayers.get(playerNum);
    }

    public Player getPlayer(int playerNum) {
        return arrayPlayers.get(playerNum);
    }
}
