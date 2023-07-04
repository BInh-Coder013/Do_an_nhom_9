/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tictactoegame;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author ADMIN
 */
public class PvAI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
     private int[][] arr;
    private boolean[][] arrEnd;
    private boolean turn;
    private boolean endGame;
    private int cCount, hCount;
    private boolean swapTurn;
    int a, b;
    
    public PvAI() {
        initComponents();
        
        arr = new int[3][3];
        arrEnd = new boolean[3][3];
    }
    
    public void randomMove() {

        a = (int) (Math.random() * (3));
        b = (int) (Math.random() * (3));
        arr[a][b] = 2;
        arrEnd[a][b] = true;

        if (a == 0 && b == 0) {
            jbtnTic1.setText("X");
            jbtnTic1.setForeground(Color.RED);
        }
        if (a == 0 && b == 1) {
            jbtnTic2.setText("X");
            jbtnTic2.setForeground(Color.RED);
        }
        if (a == 0 && b == 2) {
            jbtnTic3.setText("X");
            jbtnTic3.setForeground(Color.RED);
        }
        if (a == 1 && b == 0) {
            jbtnTic4.setText("X");
            jbtnTic4.setForeground(Color.RED);
        }
        if (a == 1 && b == 1) {
            jbtnTic5.setText("X");
            jbtnTic5.setForeground(Color.RED);
        }
        if (a == 1 && b == 2) {
            jbtnTic6.setText("X");
            jbtnTic6.setForeground(Color.RED);
        }
        if (a == 2 && b == 0) {
            jbtnTic7.setText("X");
            jbtnTic7.setForeground(Color.RED);
        }
        if (a == 2 && b == 1) {
            jbtnTic8.setText("X");
            jbtnTic8.setForeground(Color.RED);
        }
        if (a == 2 && b == 2) {
            jbtnTic9.setText("X");
            jbtnTic9.setForeground(Color.RED);
        }
    }

    public void reset() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr[i][j] = 0;
                arrEnd[i][j] = false;
                endGame = false;

            }
        }

    }

    public void New() {
    
                reset();
                turn = false;
                swapTurn = false;

                cCount = 0;
                hCount = 0;

           

    }

    public int checkResult(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            if (a == arr[i][1] && arr[i][1] == arr[i][2]) {
                if (a == 1) {
                    return -10;
                } else if (a == 2) {
                    return 10;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            int a = arr[0][i];
            if (a == arr[1][i] && arr[1][i] == arr[2][i]) {
                if (a == 1) {
                    return -10;
                } else if (a == 2) {
                    return 10;
                }
            }

        }
        if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) {
            if (arr[0][0] == 1) {
                return -10;
            } else if (arr[0][0] == 2) {
                return 10;
            }
        }
        if (arr[2][0] == arr[1][1] && arr[2][0] == arr[0][2]) {
            if (arr[2][0] == 1) {
                return -10;
            } else if (arr[2][0] == 2) {
                return 10;
            }
        }
        return 0;

    }

    public boolean checkMove(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }

        }
        return false;
    }

    public int minimax(int[][] arr, boolean isTurn) {
        int s = checkResult(arr);
        if (s == 10) {
            return s;
        }
        if (s == -10) {
            return s;
        }
        if (checkMove(arr) == false) {
            return 0;
        }
        if (isTurn == true) {
            int best = -10000;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 2;
                        best = Math.max(best, minimax(arr, !isTurn));
                        arr[i][j] = 0;
                    }

                }
            }
            return best;

        } else {
            int best = 10000;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 1;
                        best = Math.min(best, minimax(arr, !isTurn));
                        arr[i][j] = 0;
                    }

                }
            }
            return best;
        }
    }

    public Move bestMove(int[][] arr, boolean turn) {
        int best = - 1000;
        Move move = new Move(-1, -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 2;
                    int score = minimax(arr, !turn);
                    arr[i][j] = 0;
                    if (score > best) {
                        best = score;
                        move.setX(i);
                        move.setY(j);

                    }
                }

            }
        }
        return move;
    }

    public void end() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrEnd[i][j] = true;
            }
        }
    }

    public void AIturn() {
        if (turn == true && checkMove(arr) == true) {
            Move m = bestMove(arr, turn);
            int i = m.getX();
            int j = m.getY();

            if (swapTurn == false) {

                if (i == 0 && j == 0) {
                    jbtnTic1.setText("O");
                    jbtnTic1.setForeground(Color.BLUE);

                } else if (i == 0 && j == 1) {
                    jbtnTic2.setText("O");
                    jbtnTic2.setForeground(Color.BLUE);

                } else if (i == 0 && j == 2) {
                    jbtnTic3.setText("O");
                    jbtnTic3.setForeground(Color.BLUE);

                } else if (i == 1 && j == 0) {
                    jbtnTic4.setText("O");
                    jbtnTic4.setForeground(Color.BLUE);

                } else if (i == 1 && j == 1) {
                    jbtnTic5.setText("O");
                    jbtnTic5.setForeground(Color.BLUE);

                } else if (i == 1 && j == 2) {
                    jbtnTic6.setText("O");
                    jbtnTic6.setForeground(Color.BLUE);

                } else if (i == 2 && j == 0) {
                    jbtnTic7.setText("O");
                    jbtnTic7.setForeground(Color.BLUE);

                } else if (i == 2 && j == 1) {
                    jbtnTic8.setText("O");
                    jbtnTic8.setForeground(Color.BLUE);

                } else if (i == 2 && j == 2) {
                    jbtnTic9.setText("O");
                    jbtnTic9.setForeground(Color.BLUE);

                }

            } else if (swapTurn == true) {
                if (i == 0 && j == 0) {
                    jbtnTic1.setText("X");
                    jbtnTic1.setForeground(Color.RED);

                } else if (i == 0 && j == 1) {
                    jbtnTic2.setText("X");
                    jbtnTic2.setForeground(Color.RED);

                } else if (i == 0 && j == 2) {
                    jbtnTic3.setText("X");
                    jbtnTic3.setForeground(Color.RED);

                } else if (i == 1 && j == 0) {
                    jbtnTic4.setText("X");
                    jbtnTic4.setForeground(Color.RED);

                } else if (i == 1 && j == 1) {
                    jbtnTic5.setText("X");
                    jbtnTic5.setForeground(Color.RED);

                } else if (i == 1 && j == 2) {
                    jbtnTic6.setText("X");
                    jbtnTic6.setForeground(Color.RED);

                } else if (i == 2 && j == 0) {
                    jbtnTic7.setText("X");
                    jbtnTic7.setForeground(Color.RED);

                } else if (i == 2 && j == 1) {
                    jbtnTic8.setText("X");
                    jbtnTic8.setForeground(Color.RED);

                } else if (i == 2 && j == 2) {
                    jbtnTic9.setText("X");
                    jbtnTic9.setForeground(Color.RED);

                }

            }
            arrEnd[i][j] = true;
            arr[i][j] = 2;
            turn = false;

        }

    }

    public void checkEnd() {
        int check = checkResult(arr);
        if (check == 10 && endGame == false) {
            JOptionPane.showConfirmDialog(null, "Computer wins", "End", JOptionPane.DEFAULT_OPTION);
            end();
            endGame = true;
            cCount++;
            jlblComputer.setText(cCount + "");
            if (swapTurn == false) {
                swapTurn = true;
            } else if (swapTurn == true) {
                swapTurn = false;
            }
        }

        if (check == -10 && endGame == false) {
            JOptionPane.showConfirmDialog(null, "Human wins", "End", JOptionPane.DEFAULT_OPTION);
            end();
            endGame = true;
            hCount++;
            jlblHuman.setText(hCount + "");

            if (swapTurn == false) {
                swapTurn = true;
            } else if (swapTurn == true) {
                swapTurn = false;
            }
        }
        if (endGame == false) {
            if (checkMove(arr) == false) {
                JOptionPane.showConfirmDialog(null, "Draw", "End", JOptionPane.DEFAULT_OPTION);
                end();
                endGame = true;
                if (swapTurn == false) {
                    swapTurn = true;
                } else if (swapTurn == true) {
                    swapTurn = false;
                }

            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jbtnTic9 = new javax.swing.JButton();
        jbtnTic1 = new javax.swing.JButton();
        jbtnTic2 = new javax.swing.JButton();
        jbtnTic3 = new javax.swing.JButton();
        jbtnTic4 = new javax.swing.JButton();
        jbtnTic5 = new javax.swing.JButton();
        jbtnTic6 = new javax.swing.JButton();
        jbtnTic7 = new javax.swing.JButton();
        jbtnTic8 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        Reset = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        newGame = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        Computer = new javax.swing.JLabel();
        jlblHuman = new javax.swing.JLabel();
        jlblComputer = new javax.swing.JLabel();
        Human = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(124, 232, 232));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnTic9.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic9ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 140, 140));

        jbtnTic1.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic1ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 140));

        jbtnTic2.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic2ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 140, 140));

        jbtnTic3.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic3ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 140, 140));

        jbtnTic4.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic4ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 140));

        jbtnTic5.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic5ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, 140));

        jbtnTic6.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic6ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 140, 140));

        jbtnTic7.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic7ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 140));

        jbtnTic8.setFont(new java.awt.Font("Segoe UI Black", 1, 100)); // NOI18N
        jbtnTic8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic8ActionPerformed(evt);
            }
        });
        jPanel14.add(jbtnTic8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 140, 140));

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 500, 550));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newGame, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 400, 210));

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        Computer.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        Computer.setText("   computer");

        jlblHuman.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        jlblHuman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHuman.setText("0");
        jlblHuman.setOpaque(true);

        jlblComputer.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        jlblComputer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblComputer.setText("0");
        jlblComputer.setOpaque(true);

        Human.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        Human.setText("      Human");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Human, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Computer, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblHuman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblComputer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(Human, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Computer, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlblHuman, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 400, 210));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 460, 550));

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        jLabel5.setText("       TIC TAC TOE");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnTic9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic9ActionPerformed
        if (arrEnd[2][2] == false) {
            if (swapTurn == false) {
                jbtnTic9.setText("X");
                jbtnTic9.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic9.setText("O");
                jbtnTic9.setForeground(Color.BLUE);
            }
            arrEnd[2][2] = true;
            arr[2][2] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic9ActionPerformed

    private void jbtnTic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic1ActionPerformed
        if (arrEnd[0][0] == false) {
            if (swapTurn == false) {
                jbtnTic1.setText("X");
                jbtnTic1.setForeground(Color.RED);

            } else if (swapTurn == true) {
                jbtnTic1.setText("O");
                jbtnTic1.setForeground(Color.BLUE);

            }
            arrEnd[0][0] = true;
            arr[0][0] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic1ActionPerformed

    private void jbtnTic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic2ActionPerformed
        if (arrEnd[0][1] == false) {
            if (swapTurn == false) {
                jbtnTic2.setText("X");
                jbtnTic2.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic2.setText("O");
                jbtnTic2.setForeground(Color.BLUE);
            }
            arrEnd[0][1] = true;
            arr[0][1] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();
    }//GEN-LAST:event_jbtnTic2ActionPerformed

    private void jbtnTic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic3ActionPerformed

        if (arrEnd[0][2] == false) {
            if (swapTurn == false) {
                jbtnTic3.setText("X");
                jbtnTic3.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic3.setText("O");
                jbtnTic3.setForeground(Color.BLUE);
            }
            arrEnd[0][2] = true;
            arr[0][2] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic3ActionPerformed

    private void jbtnTic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic4ActionPerformed
        //
        if (arrEnd[1][0] == false) {
            if (swapTurn == false) {
                jbtnTic4.setText("X");
                jbtnTic4.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic4.setText("O");
                jbtnTic4.setForeground(Color.BLUE);
            }
            arrEnd[1][0] = true;
            arr[1][0] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic4ActionPerformed

    private void jbtnTic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic5ActionPerformed
        if (arrEnd[1][1] == false) {
            if (swapTurn == false) {
                jbtnTic5.setText("X");
                jbtnTic5.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic5.setText("O");
                jbtnTic5.setForeground(Color.BLUE);
            }
            arrEnd[1][1] = true;
            arr[1][1] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic5ActionPerformed

    private void jbtnTic6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic6ActionPerformed
        if (arrEnd[1][2] == false) {
            if (swapTurn == false) {
                jbtnTic6.setText("X");
                jbtnTic6.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic6.setText("O");
                jbtnTic6.setForeground(Color.BLUE);
            }
            arrEnd[1][2] = true;
            arr[1][2] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic6ActionPerformed

    private void jbtnTic7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic7ActionPerformed

        if (arrEnd[2][0] == false) {
            if (swapTurn == false) {
                jbtnTic7.setText("X");
                jbtnTic7.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic7.setText("O");
                jbtnTic7.setForeground(Color.BLUE);
            }
            arrEnd[2][0] = true;
            arr[2][0] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic7ActionPerformed

    private void jbtnTic8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic8ActionPerformed
        if (arrEnd[2][1] == false) {
            if (swapTurn == false) {
                jbtnTic8.setText("X");
                jbtnTic8.setForeground(Color.RED);
            } else if (swapTurn == true) {
                jbtnTic8.setText("O");
                jbtnTic8.setForeground(Color.BLUE);
            }
            arrEnd[2][1] = true;
            arr[2][1] = 1;
            turn = true;

        }
        AIturn();
        checkEnd();

    }//GEN-LAST:event_jbtnTic8ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        Menu exit = new Menu();
        exit.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ExitActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed

        jbtnTic1.setText("");
        jbtnTic2.setText("");
        jbtnTic3.setText("");
        jbtnTic4.setText("");
        jbtnTic5.setText("");
        jbtnTic6.setText("");
        jbtnTic7.setText("");
        jbtnTic8.setText("");
        jbtnTic9.setText("");

        New();

        jlblHuman.setText(cCount + "");
        jlblComputer.setText(hCount + "");

    }//GEN-LAST:event_newGameActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed

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

        turn = false;
        if (swapTurn == true) {

            randomMove();
        }
    }//GEN-LAST:event_ResetActionPerformed

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
            java.util.logging.Logger.getLogger(PvAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PvAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PvAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PvAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PvAI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Computer;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Human;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbtnTic1;
    private javax.swing.JButton jbtnTic2;
    private javax.swing.JButton jbtnTic3;
    private javax.swing.JButton jbtnTic4;
    private javax.swing.JButton jbtnTic5;
    private javax.swing.JButton jbtnTic6;
    private javax.swing.JButton jbtnTic7;
    private javax.swing.JButton jbtnTic8;
    private javax.swing.JButton jbtnTic9;
    private javax.swing.JLabel jlblComputer;
    private javax.swing.JLabel jlblHuman;
    private javax.swing.JButton newGame;
    // End of variables declaration//GEN-END:variables

    
}
