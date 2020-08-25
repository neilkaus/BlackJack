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
    static Main mainMenu;
    ImageIcon[] arrayCardIcons = new ImageIcon[52]; // "arrayCardIcons" array contains the playing card .jpg images
    
    ArrayList <PlayerGUI> arrayPlayerGUIs = new ArrayList <>(); 
    
    boolean[] arrayCheckFinish;
    
    Deck gameDeck;
    
    //BeginRound startRound = new BeginRound();
    
    /**
     * Creates new form MainMenu2
     */
    public Main() {
        initComponents();
        
        btnRoundStart.setToolTipText("Push to start a new round of the game."); // src: https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
        //txtDealerPoints1.setToolTipText("This text box displays the total amount of points the dealer has.");
        btnStart.setToolTipText("Enter the number of players, and then push to start game."); // src: https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
        txtPlayerAmount.setToolTipText("Enter the number of players in this text box.");
        btnExit.setToolTipText("Close program."); // src: https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
        
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
        cardP2 = new javax.swing.JPanel();
        Jpanel1 = new javax.swing.JPanel();
        btnRoundStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEndGame = new javax.swing.JButton();
        cardP3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        cardP1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPlayerAmount.setText("Enter# of players");

        btnStart.setText("Start Game");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Power Red and Green", 3, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 255));
        jLabel6.setText("Blackjack");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Group 6");

        jLabel4.setText("Neil Kaus");

        jLabel5.setText("Andrew Wang");

        jLabel7.setText("Ethan Tsang");

        javax.swing.GroupLayout cardP1Layout = new javax.swing.GroupLayout(cardP1);
        cardP1.setLayout(cardP1Layout);
        cardP1Layout.setHorizontalGroup(
            cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlayerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        cardP1Layout.setVerticalGroup(
            cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlayerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStart)))
                    .addGroup(cardP1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(513, Short.MAX_VALUE))
        );

        mainPanel.add(cardP1, "card3");

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

        jLabel2.setFont(new java.awt.Font("Power Clear", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
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
                .addGroup(cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardP2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(cardP2Layout.createSequentialGroup()
                                .addComponent(btnRoundStart)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(cardP2Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 258, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(cardP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEndGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardP2Layout.setVerticalGroup(
            cardP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardP2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnRoundStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEndGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(Jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(cardP2, "card4");

        cardP3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Power Red and Green", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 102));
        jLabel1.setText("Game Over");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("You lost all your money...");

        javax.swing.GroupLayout cardP3Layout = new javax.swing.GroupLayout(cardP3);
        cardP3.setLayout(cardP3Layout);
        cardP3Layout.setHorizontalGroup(
            cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP3Layout.createSequentialGroup()
                .addGroup(cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardP3Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel1))
                    .addGroup(cardP3Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel8)))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        cardP3Layout.setVerticalGroup(
            cardP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardP3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(450, Short.MAX_VALUE))
        );

        mainPanel.add(cardP3, "card2");

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
       int numOfPlayers = Integer.parseInt(txtPlayerAmount.getText());

        for (int i=0; i<numOfPlayers; i++) {
            PlayerGUI pGUI = new PlayerGUI(gameDeck, i, mainMenu);
            arrayPlayerGUIs.add(pGUI);
        }
        
        gameDeck = new Deck(numOfPlayers, 1000);
        
        CardLayout card = (CardLayout)mainPanel.getLayout(); // src: https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder/
        card.show(mainPanel, "cardP2");    
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRoundStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoundStartActionPerformed
        arrayCheckFinish = new boolean[arrayPlayerGUIs.size()];
        for (int i=0; i<arrayCheckFinish.length; i++) {
            arrayCheckFinish[i] = false;
        }
        for (int i=0; i<arrayPlayerGUIs.size(); i++) {
            arrayPlayerGUIs.get(i).startBet();
        }

//        
    }//GEN-LAST:event_btnRoundStartActionPerformed

    private void btnEndGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndGameActionPerformed

        CardLayout card = (CardLayout)mainPanel.getLayout(); // src: https://stackoverflow.com/questions/21898425/how-to-use-cardlayout-with-netbeans-gui-builder/
        card.show(mainPanel, "cardP3");
    }//GEN-LAST:event_btnEndGameActionPerformed
 
    public void setFinishedBet() { // src: Neil gave me this code    
        boolean finished = true; 
        for(int i=0; i < arrayCheckFinish.length; i++) {
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
        Jpanel1.removeAll();
     
        Dealer dealer = gameDeck.dealDealer();
        JLabel cardPic = new JLabel();                       // src: https://stackoverflow.com/questions/14030124/how-to-dynamically-add-jlabels-to-jpanel
        cardPic.setIcon(arrayCardIcons[dealer.hand.get(0)]); // src: Also help from Neil
            Jpanel1.add(cardPic);                                       
            Jpanel1.validate();
            Jpanel1.repaint();
        for (int i=0; i<arrayCheckFinish.length; i++) {
            arrayPlayerGUIs.get(i).startPlay();
        }
        for (int i=0; i<arrayCheckFinish.length; i++) {
            arrayCheckFinish[i] = false;
        }
    }
    
    public void setFinishedPlay(int PlayerNum) {
        arrayCheckFinish [PlayerNum] = true;
        boolean finished = true; 
        for(int i=0; i < arrayCheckFinish.length; i++) {
            if (!arrayCheckFinish[i]) {
                finished = false;
                break;
            }
        }
        if (finished) {
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
        mainMenu = new Main();
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
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtPlayerAmount;
    // End of variables declaration//GEN-END:variables
}
