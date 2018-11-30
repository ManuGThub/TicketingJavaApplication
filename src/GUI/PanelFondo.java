/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class PanelFondo extends javax.swing.JPanel {

    Image img;
    
    public PanelFondo(String s) {
        initComponents();
        this.img=new ImageIcon(System.getProperty("user.dir")+"\\res\\"+s).getImage();
    }
    
    @Override
    public void paint(Graphics g) {
        
        this.setOpaque(false);
        g.drawImage(img, 0,0,this.getWidth(),this.getHeight(), null);
        
        super.paint(g);
        
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
