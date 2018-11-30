/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import pojos.Factura;


public class PanelFactura extends javax.swing.JPanel {

    
    PanelControl pan_datos;
    PanelTabla pan_tab;
    
    public PanelFactura(PanelControl p,PanelTabla pt) {
        pan_datos=p;
        pan_tab=pt;
        this.setOpaque(false);
        minitComponents();
        
    }
    
    private void minitComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel1.setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        setToolTipText("");
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Control factura")));
        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jButton1.setText("Añadir producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Eliminar producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setText("Imprimir ticket");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Imprimir factura");
        jPanel1.add(jButton4);

        add(jPanel1, java.awt.BorderLayout.CENTER);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setToolTipText("");
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Control factura")));
        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jButton1.setText("Añadir producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Eliminar producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setText("Imprimir ticket");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Imprimir factura");
        jPanel1.add(jButton4);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try
        {
            Factura fac=(Factura) pan_datos.objeto_sel;
            VentanaProductos vp=new VentanaProductos(1,"Añadir",fac,this.pan_tab);
            vp.setVisible(true);
        }
        catch(Exception ex)
        {
            
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.pan_tab.deleteSelectedRow();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(this.pan_datos.objeto_sel!=null)
        {
            Factura fac=(Factura) this.pan_datos.objeto_sel;
            String texto=this.leerCabecera(fac);
            try {

                new VentanaTickets(texto,fac,this.pan_tab.lista_provisional).setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    //metodo para leer la cabecera del ticket desde un .txt
    private static String leerCabecera(Factura fac)  {
        String texto="";
        try
        {
            FileReader fr = new FileReader("tickets\\cabecera.txt");
            BufferedReader bf = new BufferedReader(fr);
            String sCadena="";

            int cont=0;
            while ((sCadena = bf.readLine())!=null) {
               texto+=sCadena+"\n";
               cont++;
               if(cont==15)
               {
                    Date date=fac.getFecha();

                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String fecha=df.format(date);
                    
                    texto+="\n       Fecha: "+fecha;
                   
               }
            }
            return texto;
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
            return null;
        }
        
        
        
    }
}
