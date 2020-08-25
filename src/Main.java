 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author etsan
 */
public class Main extends javax.swing.JFrame {
    
    ImageIcon[] arrayCardIcons = new ImageIcon[52]; // "arrayCardIcons" array contains the playing card .jpg images
    
    ArrayList <PlayerGUI> arrayPlayerGUIs = new ArrayList <>(); // ArrayList of PlayerGUI
    
    boolean[] arrayCheckFinish;
    
    Deck gameDeck;
    
    /**
     * Creates new form MainMenu2
     */
    public Main() {
        initComponents();
        
        btnRoundStart.setToolTipText("Push to start a new round of the game."); // src: https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
        btnStart.setToolTipText("Enter the number of players, as well as the amount of money you want to start with, and then push to start game."); 
        txtPlayerAmount.setToolTipText("Enter the number of players in this text box.");
        btnExit.setToolTipText("Close program."); 
        txtStartMoney.setToolTipText("Enter the amount of money you want to start with."); 
        
        arrayCardIcons[0] = new ImageIcon("AC.jpg");  
        arrayCardIcons[1] = new ImageIcon("2C.jpg");
        arrayCardIcons[2] = new ImageIcon("3C.jpg");
        arrayCardIcons[3] = new ImageIcon("4C.jpg");
        arrayCardIcons[4] = new ImageIcon("5C.jpg");
        arrayCardIcons[5] = new ImageIcon("6C.jpg");
        arrayCardIcons[6] = new ImageIcon("7C.jpg");
        arrayCardIcons[7] = new ImageIcon("8C.jpg");
        arrayCardIcons[8] = new ImageIcon("9C.jpg");
        arrayCardIcons[9] = new ImageIcon("10C.jpg");
        arrayCardIcons[10] = new ImageIcon("JC.jpg");
        arrayCardIcons[11] = new ImageIcon("QC.jpg");
        
        arrayCardIcons[12] = new ImageIcon("KC.jpg");
        arrayCardIcons[13] = new ImageIcon("AD.jpg");  
        arrayCardIcons[14] = new ImageIcon("2D.jpg");
        arrayCardIcons[15] = new ImageIcon("3D.jpg");
        arrayCardIcons[16] = new ImageIcon("4D.jpg");
        arrayCardIcons[17] = new ImageIcon("5D.jpg");
        arrayCardIcons[18] = new ImageIcon("6D.jpg");
        arrayCardIcons[19] = new ImageIcon("7D.jpg");
        arrayCardIcons[20] = new ImageIcon("8D.jpg");
        arrayCardIcons[21] = new ImageIcon("9D.jpg");
        arrayCardIcons[22] = new ImageIcon("10D.jpg");
        arrayCardIcons[23] = new ImageIcon("JD.jpg");
        arrayCardIcons[24] = new ImageIcon("QD.jpg");
        arrayCardIcons[25] = new ImageIcon("KD.jpg");
        
        arrayCardIcons[26] = new ImageIcon("AH.jpg");  
        arrayCardIcons[27] = new ImageIcon("2H.jpg");
        arrayCardIcons[28] = new ImageIcon("3H.jpg");
        arrayCardIcons[29] = new ImageIcon("4H.jpg");
        arrayCardIcons[30] = new ImageIcon("5H.jpg");
        arrayCardIcons[31] = new ImageIcon("6H.jpg");
        arrayCardIcons[32] = new ImageIcon("7H.jpg");
        arrayCardIcons[33] = new ImageIcon("8H.jpg");
        arrayCardIcons[34] = new ImageIcon("9H.jpg");
        arrayCardIcons[35] = new ImageIcon("10H.jpg");
        arrayCardIcons[36] = new ImageIcon("JH.jpg");
        arrayCardIcons[37] = new ImageIcon("QH.jpg");
        arrayCardIcons[38] = new ImageIcon("KH.jpg");
        
        arrayCardIcons[39] = new ImageIcon("AS.jpg");  
        arrayCardIcons[40] = new ImageIcon("2S.jpg");
        arrayCardIcons[41] = new ImageIcon("3S.jpg");
        arrayCardIcons[42] = new ImageIcon("4S.jpg");
        arrayCardIcons[43] = new ImageIcon("5S.jpg");
        arrayCardIcons[44] = new ImageIcon("6S.jpg");
        arrayCardIcons[45] = new ImageIcon("7S.jpg");
        arrayCardIcons[46] = new ImageIcon("8S.jpg");
        arrayCardIcons[47] = new ImageIcon("9S.jpg");
        arrayCardIcons[48] = new ImageIcon("10S.jpg");
        arrayCardIcons[49] = new ImageIcon("JS.jpg");
        arrayCardIcons[50] = new ImageIcon("QS.jpg");
        arrayCardIcons[51] = new ImageIcon("KS.jpg");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        cardP1 = new javax.swing.JPanel();
        txtPlayerAmount = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStartMoney = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cardP2 = new javax.swing.JPanel();
        Jpanel1 = new javax.swing.JPanel();
        btnRoundStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEndGame = new javax.swing.JButton();
        cardP3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaFinal1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaFinal2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaFinal3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaFinal4 = new javax.swing.JTextArea();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        cardP1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnStart.setText("Start Game");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria", 3, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Blackjack");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Group 6");

        jLabel4.setText("Neil Kaus");

        jLabel5.setText("Andrew Wang");

        jLabel7.setText("Ethan Tsang");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Hover over buttons and text boxes for tooltips!");

        javax.swing.GroupLayout cardP1Layout = new javax.swing.GroupLayout(cardP1);
        cardP1.setLayout(cardP1Layout);
        cardP1Layout.setHorizontalGroup(
            cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP1Layout.createSequentialGroup()
                .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(cardP1Layout.createSequentialGroup()
                                .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardP1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPlayerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardP1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtStartMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 264, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardP1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(288, 288, 288))
        );
        cardP1Layout.setVerticalGroup(
            cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP1Layout.createSequentialGroup()
                .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txtPlayerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStartMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardP1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnStart)
                        .addGap(52, 52, 52)))
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(247, 247, 247)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(16, 16, 16))
        );

        mainPanel.add(cardP1, "cardP1");

        cardP2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Jpanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout Jpanel1Layout = new javax.swing.GroupLayout(Jpanel1);
        Jpanel1.setLayout(Jpanel1Layout);
        Jpanel1Layout.setHorizontalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Jpanel1Layout.setVerticalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        btnRoundStart.setText("Start New Round");
        btnRoundStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoundStartActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dealer's Hand");

        btnEndGame.setText("End Game");
        btnEndGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardP2Layout = new javax.swing.GroupLayout(cardP2);
        cardP2.setLayout(cardP2Layout);
        cardP2Layout.setHorizontalGroup(
            cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cardP2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEndGame)
                            .addComponent(btnRoundStart))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
                .addContainerGap())
        );
        cardP2Layout.setVerticalGroup(
            cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardP2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btnRoundStart)
                .addGap(34, 34, 34)
                .addComponent(btnEndGame)
                .addGap(18, 18, 18)
                .addComponent(Jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(cardP2, "cardP2");

        cardP3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Game Over");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Final Scores!");

        txaFinal1.setColumns(20);
        txaFinal1.setRows(5);
        jScrollPane1.setViewportView(txaFinal1);

        txaFinal2.setColumns(20);
        txaFinal2.setRows(5);
        jScrollPane2.setViewportView(txaFinal2);

        txaFinal3.setColumns(20);
        txaFinal3.setRows(5);
        jScrollPane3.setViewportView(txaFinal3);

        txaFinal4.setColumns(20);
        txaFinal4.setRows(5);
        jScrollPane4.setViewportView(txaFinal4);

        javax.swing.GroupLayout cardP3Layout = new javax.swing.GroupLayout(cardP3);
        cardP3.setLayout(cardP3Layout);
        cardP3Layout.setHorizontalGroup(
            cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(cardP3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardP3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(380, 380, 380))
        );
        cardP3Layout.setVerticalGroup(
            cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardP3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardP3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardP3Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        mainPanel.add(cardP3, "cardP3");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            int numOfPlayers = Integer.parseInt(txtPlayerAmount.getText());
            int startMoney = Integer.parseInt(txtStartMoney.getText());
                    
            if (numOfPlayers > 0 && numOfPlayers < 5) { // Only up to 3 players can join a match
                gameDeck = new Deck(numOfPlayers, startMoney); // install Deck and starting money amount 
                for (int i=0; i<numOfPlayers; i++) { // set the amount of "PlayerGUI" and then add them into the "arrayPlayerGUIs"
                    PlayerGUI pGUI = new PlayerGUI(i, this);
                    arrayPlayerGUIs.add(pGUI);
                }
                CardLayout card = (CardLayout)mainPanel.getLayout(); // src: https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder/
                card.show(mainPanel, "cardP2");
            }
            else {
                System.out.println("Too Many Players");
                CardLayout card = (CardLayout)mainPanel.getLayout(); // src: https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder/
                card.show(mainPanel, "cardP1");
            }
        }
        catch(Exception e) {
            System.out.println("Incorrect Input");
            CardLayout card = (CardLayout)mainPanel.getLayout(); // src: https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder/
            card.show(mainPanel, "cardP1");
        }   
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRoundStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoundStartActionPerformed
        // Neil provided this code
        btnRoundStart.setEnabled(false); // disable the Start New Round button
        Jpanel1.removeAll();
        javax.swing.GroupLayout Jpanel1Layout = new javax.swing.GroupLayout(Jpanel1); 
        Jpanel1.setLayout(Jpanel1Layout); // set new JPanel
        Jpanel1Layout.setHorizontalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Jpanel1Layout.setVerticalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
        Jpanel1.validate();
        Jpanel1.repaint();
    
        arrayCheckFinish = new boolean[arrayPlayerGUIs.size()];
        for (int i=0; i<arrayCheckFinish.length; i++) {
            arrayCheckFinish[i] = false;
        }
        gameDeck.startRound();
        for (int i=0; i<arrayPlayerGUIs.size(); i++) {
            arrayPlayerGUIs.get(i).startBet();
        }
    }//GEN-LAST:event_btnRoundStartActionPerformed

    private void btnEndGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndGameActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout(); // src: https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder/
        card.show(mainPanel, "cardP3");
        
        Double [] finalMoneyList = new Double [4];
        for (int i=0; i < arrayPlayerGUIs.size(); i++) {
            finalMoneyList [i] = gameDeck.getPlayer(i).money;
        }
        
        txaFinal1.setText("Player 1 final score!\n" + "$ "+Double.toString(finalMoneyList [0]));
        txaFinal2.setText("Player 2 final score!\n" + "$ "+Double.toString(finalMoneyList [1]));
        txaFinal3.setText("Player 3 final score!\n" + "$ "+Double.toString(finalMoneyList [2]));
        txaFinal4.setText("Player 4 final score!\n" + "$ "+Double.toString(finalMoneyList [3]));
    }//GEN-LAST:event_btnEndGameActionPerformed
 
    public void setFinishedBet(int playerNum) { // src: Neil gave me this code    
        arrayCheckFinish[playerNum] = true;
        boolean finished = true; 
        for(int i=0; i < arrayCheckFinish.length; i++) { // check if all of "arrayCheckFinish" is true. If not, then break
            if (!arrayCheckFinish[i]) {
                finished = false;
                break;
            }
        }
        if (finished) {
            startPlayRound(); 
        }     
    }
    
    public void startPlayRound() { 
        Jpanel1.removeAll(); // Remove all previous card images
        Jpanel1.setLayout(new FlowLayout());
        
        // set up new JLabels with the card images, and display one card in the dealer's hand
        Dealer dealer = gameDeck.dealDealer(); 
        JLabel cardPic = new JLabel(); // src: https://stackoverflow.com/questions/14030124/how-to-dynamically-add-jlabels-to-jpanel
        cardPic.setIcon(arrayCardIcons[dealer.hand.get(0)]); // src: Also help from Neil
        Jpanel1.add(cardPic);                                       
        Jpanel1.validate();
        Jpanel1.repaint();
        
        // 
        for (int i=0; i<arrayCheckFinish.length; i++) {
            arrayPlayerGUIs.get(i).startPlay();
        }
        
        //set all of "arrayCheckFinish" back to false
        for (int i=0; i<arrayCheckFinish.length; i++) {
            arrayCheckFinish[i] = false;
        }
    }
    
    public void setFinishedPlay(int PlayerNum) {
        arrayCheckFinish [PlayerNum] = true;
        boolean finished = true; // check if all of "arrayCheckFinish" is true. If not, then break
        for(int i=0; i < arrayCheckFinish.length; i++) {
            if (!arrayCheckFinish[i]) {
                finished = false;
                break;
            }
        }
        if (finished) { // if finished is true, clear any current image JPanels and display any new images in the dealer's hand.
            Jpanel1.removeAll();
            Dealer dealer = gameDeck.finalDealer();
            for (int i=0; i<dealer.hand.size(); i++) {
                JLabel cardPic = new JLabel();                       // src: https://stackoverflow.com/questions/14030124/how-to-dynamically-add-jlabels-to-jpanel
                cardPic.setIcon(arrayCardIcons[dealer.hand.get(i)]); //  src: Also help from Neil 
                Jpanel1.add(cardPic);                                      
            }
            Jpanel1.validate();
            Jpanel1.repaint();
            for (int i=0; i<arrayCheckFinish.length; i++) {
                arrayPlayerGUIs.get(i).getPayout();        
            }
            gameDeck.endRound();
            btnRoundStart.setEnabled(true); // reenable the Start New Round button
        }   
    }   
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        Main mainMenu = new Main();
        mainMenu.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel1;
    private javax.swing.JButton btnEndGame;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRoundStart;
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel cardP1;
    private javax.swing.JPanel cardP2;
    private javax.swing.JPanel cardP3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea txaFinal1;
    private javax.swing.JTextArea txaFinal2;
    private javax.swing.JTextArea txaFinal3;
    private javax.swing.JTextArea txaFinal4;
    private javax.swing.JTextField txtPlayerAmount;
    private javax.swing.JTextField txtStartMoney;
    // End of variables declaration//GEN-END:variables
}
