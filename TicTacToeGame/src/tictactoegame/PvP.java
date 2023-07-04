/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tictactoegame;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tictactoegame.Menu;

/**
 *
 * @author datbe
 */
public class PvP extends javax.swing.JFrame {

    private String startGame = "X";
    private int xCount = 0;
    private int oCount = 0;
    boolean checker;
    boolean arrEnd[][];
    boolean endGame;

    public PvP() {
        initComponents();
        arrEnd = new boolean[3][3];
    }

    private void gameScore() {
        jlblPlayerX.setText(String.valueOf(xCount));
        jlblPlayerO.setText(String.valueOf(oCount));
    }

    private void choose_a_Player() {
        if (startGame.equalsIgnoreCase("X")) {
            startGame = "O";
        } else {
            startGame = "X";
        }
    }

    private void endArr() {

        for (int i = 0; i < arrEnd.length; i++) {
            for (int j = 0; j < arrEnd.length; j++) {
                arrEnd[i][j] = true;
            }
        }

    }

    private void reset() {
        for (int i = 0; i < arrEnd.length; i++) {
            for (int j = 0; j < arrEnd.length; j++) {
                arrEnd[i][j] = false;

            }
        }

    }

    public boolean checkMove(boolean[][] arrEnd) {
        for (int i = 0; i < arrEnd.length; i++) {
            for (int j = 0; j < arrEnd[i].length; j++) {
                if (arrEnd[i][j] == false) {
                    return true;
                }
            }

        }
        return false;
    }

    public void checkDraw() {
        if (endGame == false) {
            if (checkMove(arrEnd) == false) {
                JOptionPane.showMessageDialog(this, "Draw", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                endGame = true;
            }
        }
    }

    private void winningGame() {                                       // phuong thuc kiem tra chien thang
        String b1 = jbtnTic1.getText();
        String b2 = jbtnTic2.getText();
        String b3 = jbtnTic3.getText();
        String b4 = jbtnTic4.getText();
        String b5 = jbtnTic5.getText();
        String b6 = jbtnTic6.getText();
        String b7 = jbtnTic7.getText();
        String b8 = jbtnTic8.getText();
        String b9 = jbtnTic9.getText();

        if (b1 == ("X") && b2 == ("X") && b3 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b4 == ("X") && b5 == ("X") && b6 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b7 == ("X") && b8 == ("X") && b9 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b1 == ("O") && b2 == ("O") && b3 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b4 == ("O") && b5 == ("O") && b6 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b7 == ("O") && b8 == ("O") && b9 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b1 == ("X") && b5 == ("X") && b9 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b3 == ("X") && b5 == ("X") && b7 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b1 == ("O") && b5 == ("O") && b9 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b3 == ("O") && b5 == ("O") && b7 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b1 == ("X") && b4 == ("X") && b7 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b2 == ("X") && b5 == ("X") && b8 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b3 == ("X") && b6 == ("X") && b9 == ("X")) {
            JOptionPane.showMessageDialog(this, "Player X Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            xCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b1 == ("O") && b4 == ("O") && b7 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b2 == ("O") && b5 == ("O") && b8 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        } else if (b3 == ("O") && b6 == ("O") && b9 == ("O")) {
            JOptionPane.showMessageDialog(this, "Player O Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);

            oCount++;
            gameScore();
            endArr();
            endGame = true;

        }

    }
    //kiem tra chien thang

    /**
     *
     * @param arrEnd
     * @return
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Reset = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        newGame = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        PlayerO = new javax.swing.JLabel();
        jlblPlayerX = new javax.swing.JLabel();
        jlblPlayerO = new javax.swing.JLabel();
        PlayerX = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbtnTic9 = new javax.swing.JButton();
        jbtnTic1 = new javax.swing.JButton();
        jbtnTic2 = new javax.swing.JButton();
        jbtnTic3 = new javax.swing.JButton();
        jbtnTic4 = new javax.swing.JButton();
        jbtnTic5 = new javax.swing.JButton();
        jbtnTic6 = new javax.swing.JButton();
        jbtnTic7 = new javax.swing.JButton();
        jbtnTic8 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(124, 232, 232));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        Reset.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Exit.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        newGame.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        newGame.setText("New ");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newGame, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 400, 210));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        PlayerO.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        PlayerO.setText("      Player O");

        jlblPlayerX.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        jlblPlayerX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPlayerX.setText("0");
        jlblPlayerX.setOpaque(true);

        jlblPlayerO.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        jlblPlayerO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPlayerO.setText("0");
        jlblPlayerO.setOpaque(true);

        PlayerX.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        PlayerX.setText("      Player X");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PlayerX, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(PlayerO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblPlayerX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblPlayerO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(PlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayerO, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlblPlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblPlayerO, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 400, 210));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 460, 540));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnTic9.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic9ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 140, 140));

        jbtnTic1.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic1ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 140));

        jbtnTic2.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic2ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 140, 140));

        jbtnTic3.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic3ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 140, 140));

        jbtnTic4.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic4ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 140));

        jbtnTic5.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic5ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, 140));

        jbtnTic6.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic6ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 140, 140));

        jbtnTic7.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic7ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 140));

        jbtnTic8.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic8ActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnTic8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 140, 140));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 500, 540));

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        Title.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        Title.setText("       TIC TAC TOE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 760, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1040, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        Menu exit = new Menu();
        exit.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_ExitActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed

        jlblPlayerX.setText("0");
        jlblPlayerO.setText("0");

        jbtnTic1.setText("");
        jbtnTic2.setText("");
        jbtnTic3.setText("");
        jbtnTic4.setText("");
        jbtnTic5.setText("");
        jbtnTic6.setText("");
        jbtnTic7.setText("");
        jbtnTic8.setText("");
        jbtnTic9.setText("");

        xCount = 0;
        oCount = 0;
        reset();
        endGame = false;
        startGame = "X";
    }//GEN-LAST:event_newGameActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed

//      
        jbtnTic1.setText("");
        jbtnTic2.setText("");
        jbtnTic3.setText("");
        jbtnTic4.setText("");
        jbtnTic5.setText("");
        jbtnTic6.setText("");
        jbtnTic7.setText("");
        jbtnTic8.setText("");
        jbtnTic9.setText("");

        reset();
        endGame = false;
        startGame = "X";
    }//GEN-LAST:event_ResetActionPerformed

    private void jbtnTic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic1ActionPerformed
        if (arrEnd[0][0] == false) {
            arrEnd[0][0] = true;
            jbtnTic1.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic1.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic1.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
        }


    }//GEN-LAST:event_jbtnTic1ActionPerformed

    private void jbtnTic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic2ActionPerformed
        if (arrEnd[0][1] == false) {
            arrEnd[0][1] = true;
            jbtnTic2.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic2.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic2.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();// TODO add your handling code here:
            checkDraw();
        }

    }//GEN-LAST:event_jbtnTic2ActionPerformed

    private void jbtnTic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic3ActionPerformed
        if (arrEnd[0][2] == false) {
            arrEnd[0][2] = true;
            jbtnTic3.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic3.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic3.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic3ActionPerformed
    }
    private void jbtnTic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic4ActionPerformed
        if (arrEnd[1][0] == false) {
            arrEnd[1][0] = true;
            jbtnTic4.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic4.setForeground(Color.RED);
            } else {
                jbtnTic4.setForeground(Color.BLUE);
                checker = true;
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic4ActionPerformed
    }
    private void jbtnTic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic5ActionPerformed
        if (arrEnd[1][1] == false) {
            arrEnd[1][1] = true;
            jbtnTic5.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic5.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic5.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic5ActionPerformed
    }
    private void jbtnTic6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic6ActionPerformed
        if (arrEnd[1][2] == false) {
            arrEnd[1][2] = true;
            jbtnTic6.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic6.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic6.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic6ActionPerformed
    }
    private void jbtnTic7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic7ActionPerformed
        if (arrEnd[2][0] == false) {
            arrEnd[2][0] = true;
            jbtnTic7.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic7.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic7.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic7ActionPerformed
    }
    private void jbtnTic8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic8ActionPerformed
        if (arrEnd[2][1] == false) {
            arrEnd[2][1] = true;
            jbtnTic8.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic8.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic8.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic8ActionPerformed
    }
    private void jbtnTic9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic9ActionPerformed
        if (arrEnd[2][2] == false) {
            arrEnd[2][2] = true;
            jbtnTic9.setText(startGame);

            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                jbtnTic9.setForeground(Color.RED);
            } else {
                checker = true;
                jbtnTic9.setForeground(Color.BLUE);
            }
            choose_a_Player();
            winningGame();
            checkDraw();
    }//GEN-LAST:event_jbtnTic9ActionPerformed
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
            java.util.logging.Logger.getLogger(PvP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PvP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PvP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PvP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PvP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JLabel PlayerO;
    private javax.swing.JLabel PlayerX;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbtnTic1;
    private javax.swing.JButton jbtnTic2;
    private javax.swing.JButton jbtnTic3;
    private javax.swing.JButton jbtnTic4;
    private javax.swing.JButton jbtnTic5;
    private javax.swing.JButton jbtnTic6;
    private javax.swing.JButton jbtnTic7;
    private javax.swing.JButton jbtnTic8;
    private javax.swing.JButton jbtnTic9;
    private javax.swing.JLabel jlblPlayerO;
    private javax.swing.JLabel jlblPlayerX;
    private javax.swing.JButton newGame;
    // End of variables declaration//GEN-END:variables
}
