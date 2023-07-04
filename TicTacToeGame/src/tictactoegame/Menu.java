/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tictactoegame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tictactoegame.PvP;

/**
 *
 * @author datbe
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        playPvP = new javax.swing.JButton();
        playPvAI = new javax.swing.JButton();
        Exitgame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(124, 232, 232));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 2, 48)); // NOI18N
        jLabel1.setText("                     X   Tic Tac Toe   O");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 790, 100));

        playPvP.setBackground(new java.awt.Color(51, 255, 255));
        playPvP.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        playPvP.setText("2 Player");
        playPvP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPvPActionPerformed(evt);
            }
        });
        jPanel3.add(playPvP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 500, 90));

        playPvAI.setBackground(new java.awt.Color(0, 255, 255));
        playPvAI.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        playPvAI.setText("PLAY WITH AI");
        playPvAI.setToolTipText("");
        playPvAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPvAIActionPerformed(evt);
            }
        });
        jPanel3.add(playPvAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 500, 90));

        Exitgame.setBackground(new java.awt.Color(0, 255, 255));
        Exitgame.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        Exitgame.setText("EXIT GAME");
        Exitgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameActionPerformed(evt);
            }
        });
        jPanel3.add(Exitgame, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 500, 90));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 970, 580));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playPvAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPvAIActionPerformed

        PvAI ai = new PvAI();// Tạo một thể hiện mới của NewGUI
        ai.setVisible(true); // Hiển thị NewGUI
        setVisible(false); // Ẩn MainGUI
    }//GEN-LAST:event_playPvAIActionPerformed

    private JFrame frame;
    private void exitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameActionPerformed
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the game ?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitGameActionPerformed

    private void playPvPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPvPActionPerformed
        PvP p = new PvP(); // Tạo một thể hiện mới của NewGUI
        p.setVisible(true); // Hiển thị NewGUI
        setVisible(false); // Ẩn MainGUI
    }//GEN-LAST:event_playPvPActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitgame;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton playPvAI;
    private javax.swing.JButton playPvP;
    // End of variables declaration//GEN-END:variables
}