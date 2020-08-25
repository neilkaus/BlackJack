import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class Deck {

    private ArrayList<Player> arrayPlayers = new ArrayList<>();
    private int[] arrayDeck = new int[52];
    private int cardToDraw = 0;
    private Dealer mainDealer;

    public Deck(int numPlayers, double startingMoney) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element game = doc.createElement("game");
            game.setAttribute("numPlayers", numPlayers + "");
            game.setAttribute("startingMoney", startingMoney + "");
            doc.appendChild(game);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result =  new StreamResult(new File("BlackJackLog.xml"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException ex) {
        } catch (TransformerConfigurationException ex) {
        } catch (TransformerException ex) {
        }

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
            P.oneAceAs11Total = 0;
            P.splitSoftTotal = 0;
            P.splitHardTotal = 0;
            P.splitOneAceAs11Total = 0;
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
        arrayPlayers.get(playerNum).oneAceAs11Total = 0;
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
            } else if ((card%13) + 1 < 10) {
                arrayPlayers.get(playerNum).softTotal += (card%13) + 1;
                arrayPlayers.get(playerNum).hardTotal += (card%13) + 1;
                arrayPlayers.get(playerNum).oneAceAs11Total += (card%13) + 1;
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
            arrayPlayers.get(playerNum).splitOneAceAs11Total = 0;
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
                } else if ((card%13) +1 < 10) {
                    arrayPlayers.get(playerNum).splitSoftTotal += (card%13) + 1;
                    arrayPlayers.get(playerNum).splitHardTotal += (card%13)+ 1;
                    arrayPlayers.get(playerNum).splitOneAceAs11Total += (card%13) + 1;
                } else {
                    arrayPlayers.get(playerNum).splitSoftTotal += 10;
                    arrayPlayers.get(playerNum).splitHardTotal += 10;
                    arrayPlayers.get(playerNum).splitOneAceAs11Total += 10;
                }
            }
        }
    }

    private void dealerHandTotal() {
        mainDealer.softTotal = 0;
        mainDealer.hardTotal = 0;
        mainDealer.oneAceAs11Total = 0;
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
            } else if ((card%13) + 1 < 10) {
                mainDealer.softTotal += (card%13) + 1;
                mainDealer.hardTotal += (card%13) + 1;
                mainDealer.oneAceAs11Total += (card%13) + 1;
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
        arrayPlayers.get(playerNum).money -= arrayPlayers.get(playerNum).betAmount;
        arrayPlayers.get(playerNum).betAmount *= 2;
        
        playerHandTotal(playerNum);

        return arrayPlayers.get(playerNum);
    } 

    public void standSplitHand(int playerNum) {
        arrayPlayers.get(playerNum).playSplitHand = true;
    }

    public Dealer finalDealer() {
        while(mainDealer.softTotal < 17) {
            mainDealer.hand.add(arrayDeck[cardToDraw]);
            cardToDraw++;

            dealerHandTotal();
        }

        if(mainDealer.oneAceAs11Total < 17 && mainDealer.softTotal > 21) {
            while(mainDealer.oneAceAs11Total < 17) {
                mainDealer.hand.add(arrayDeck[cardToDraw]);
                cardToDraw++;

                dealerHandTotal();
            }
        }

        if(mainDealer.hardTotal < 17 && mainDealer.oneAceAs11Total > 21) {
            while(mainDealer.hardTotal < 17) {
                mainDealer.hand.add(arrayDeck[cardToDraw]);
                cardToDraw++;

                dealerHandTotal();
            }
        }
        System.out.println("dealer soft : " + mainDealer.softTotal + " dealer hard " + mainDealer.hardTotal + " one ace " + mainDealer.oneAceAs11Total);
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
            System.out.println(" win amount " + arrayPlayers.get(playerNum).winAmount);
        } else {
            if(handHighestTotal > 21 ) {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount;
            } else if (handHighestTotal == 21 && arrayPlayers.get(playerNum).hand.size() == 2) {
                arrayPlayers.get(playerNum).winAmount += arrayPlayers.get(playerNum).betAmount * 1.5;
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).betAmount * 2.5;
            } else if(dealerHighestTotal > 21 || handHighestTotal > dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += arrayPlayers.get(playerNum).betAmount; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).winAmount * 2;
            } else if(handHighestTotal == dealerHighestTotal) {
                arrayPlayers.get(playerNum).winAmount += 0; 
                arrayPlayers.get(playerNum).money += arrayPlayers.get(playerNum).betAmount;
            } else {
                arrayPlayers.get(playerNum).winAmount -= arrayPlayers.get(playerNum).betAmount; 
            }
        }        

        return arrayPlayers.get(playerNum);
    }

    public Player getPlayer(int playerNum) {
        return arrayPlayers.get(playerNum);
    }
    public void endRound() {
         try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("BlackJackLog.xml"));
            doc.getDocumentElement().normalize();
            Element game = doc.getDocumentElement();
            Element round = doc.createElement("round");
            
            for (Player P:arrayPlayers) {
                Element elementPlayer = doc.createElement("player");
                elementPlayer.setAttribute("playerNum", arrayPlayers.indexOf(P) + "");
                Element money = doc.createElement("money");
                Element hand = doc.createElement("hand");
                Element hardTotal = doc.createElement("hardTotal");
                Element softTotal = doc.createElement("softTotal");
                Element oneAceAs11Total = doc.createElement("oneAceAs11Total");
                Element splitHand = doc.createElement("splitHand");
                Element splitHardTotal = doc.createElement("splitHardTotal");
                Element splitSoftTotal = doc.createElement("splitSoftTotal");
                Element splitOneAceAs11Total = doc.createElement("splitOneAceAs11Total");
                Element winAmount = doc.createElement("winAmount");
                Element betAmount = doc.createElement("betAmount");
                money.appendChild(doc.createTextNode(P.money + ""));
                hand.appendChild(doc.createTextNode(P.hand + ""));
                hardTotal.appendChild(doc.createTextNode(P.hardTotal + ""));
                softTotal.appendChild(doc.createTextNode(P.softTotal + ""));
                oneAceAs11Total.appendChild(doc.createTextNode(P.oneAceAs11Total + ""));
                splitHand.appendChild(doc.createTextNode(P.splitHand + ""));
                splitHardTotal.appendChild(doc.createTextNode(P.splitHardTotal + ""));
                splitSoftTotal.appendChild(doc.createTextNode(P.splitSoftTotal + ""));
                splitOneAceAs11Total.appendChild(doc.createTextNode(P.oneAceAs11Total + ""));
                winAmount.appendChild(doc.createTextNode(P.winAmount + ""));
                betAmount.appendChild(doc.createTextNode(P.betAmount + ""));
                elementPlayer.appendChild(money);
                elementPlayer.appendChild(hand);
                elementPlayer.appendChild(hardTotal);
                elementPlayer.appendChild(softTotal);
                elementPlayer.appendChild(oneAceAs11Total);
                elementPlayer.appendChild(splitHand);
                elementPlayer.appendChild(splitHardTotal);
                elementPlayer.appendChild(splitSoftTotal);
                elementPlayer.appendChild(splitOneAceAs11Total);
                elementPlayer.appendChild(winAmount);
                elementPlayer.appendChild(betAmount);
                round.appendChild(elementPlayer);
            }
            
            game.appendChild(round);
            
            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result =  new StreamResult(new File("BlackJackLog.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException ex) {
        } catch (SAXException | IOException | TransformerException ex) {
        }
    }
}
