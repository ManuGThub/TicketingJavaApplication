
package GUI;

import data.Main;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import pojos.Facprod;
import pojos.Factura;
import pojos.Producto;


public class VentanaTickets extends javax.swing.JFrame {

   String texto="";
   float total;
   float entregado;
   float cambio;
   float base;
   
   Graphics pagina;
   PrintJob pj;
   Font fuente;
   
   JTextField campo_base;
           
   JTextField campo_iva;
   boolean valido=false;
   DecimalFormat df;
   Factura fac;
   List lista;
   
    public VentanaTickets(String txt,Factura f,List l) throws IOException {
        
        fac=f;
        lista=l;
        df = new DecimalFormat();
        
        if(txt!=null)
        {
           texto=txt; 
        }
        
        //le aplico un look and feel        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            
        }
        
        fuente = new Font("Lucida Console", Font.PLAIN, 8);
        
        //relleno con los datos de la factura y los productos
        
        texto+="     Atendido por: "+fac.getAtendido()+"\n\n\n";
        List<Producto> prods=Main.getFpDAO().obtenProductosFactura(fac.getIdFactura());
        List<Facprod> lista_facprods=Main.getFpDAO().obtenFacProdsFactura(fac.getIdFactura());
        
        for (Facprod facprod : lista_facprods) {
            for (Producto produc : prods) {
                texto+="   "+facprod.getCantidad()+" X "+produc.getNombre()+" = "+facprod.getImporte()+"\n\n";
                
            }
            
        }
        
        minitComponents();
        this.campo_base.setText(String.valueOf(fac.getImporte()));
        this.setSize(500,650);
        this.setTitle("Isper Color");
        this.setLocationRelativeTo(null);
        
        
        
        
        
    }
    
    public void imprimir(String Cadena) { 
        
        //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION 
        
        try {
            pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Ticket", null);
            pagina = pj.getGraphics();
            pagina.translate(15,15);
            pagina.setFont(fuente);
            pagina.setColor(Color.black);
            jTextArea1.printAll(pagina); 
            pagina.dispose(); 
            pj.end(); 
            
        }catch(Exception e)
        { 
            JOptionPane.showMessageDialog(null,"LA IMPRESION HA SIDO CANCELADA...");
        }
    }
    
    private void calcular_costes() {
        
        try
        {
            
            df.setMinimumFractionDigits(3);
            df.setMaximumFractionDigits(2);
            float iva=1.0f;
            iva+=(Float.parseFloat(campo_iva.getText())/100.0);
            total = (Float.parseFloat(VentanaTickets.this.campo_base.getText())*iva);
           
            this.jTextField1.setText(String.valueOf(df.format(total)));
            entregado = Float.parseFloat(VentanaTickets.this.jTextField2.getText());
            cambio=(entregado-total);
            VentanaTickets.this.jTextField3.setText(String.valueOf(df.format(cambio)));
            
            valido=true;
            VentanaTickets.this.jTextArea1.append("\nBASE  "+df.format(base)+"    IVA  "+df.format(iva)+"%\n\n");
            VentanaTickets.this.jTextArea1.append("TOTAL IVA: "+String.valueOf(df.format(total-base))+"\n\n");
            VentanaTickets.this.jTextArea1.append("TOTAL A PAGAR: "+df.format(total)+"\n\n");
            VentanaTickets.this.jTextArea1.append("ENTREGADO: "+df.format(entregado)+" CAMBIO: "+df.format(cambio)+"\n\n");
            VentanaTickets.this.jTextArea1.append(" *** GRACIAS POR SU VISITA ***");




        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Deben rellenarse los campos 'base' 'IVA' y 'entregado'");
        }
    }
    
    private void generar_ticket() {
        
         String ruta=System.getProperty("user.dir");
         File archivo = new File(ruta+"/tickets/ticket.txt");
         BufferedWriter bw;
         try {

             if(valido)
             {
                 bw = new BufferedWriter(new FileWriter(archivo));
                 bw.write(jTextArea1.getText());
                 bw.close();
     
                 JOptionPane.showMessageDialog(null,"Ticket generado con exito ");
                
                 

             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Debe calcular los costes primero ");
             }



         } catch (IOException ex) {
             JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
         }
     }
    
    private void borrar() {
        VentanaTickets.this.jTextField1.setText("");
        VentanaTickets.this.jTextField2.setText("");
        VentanaTickets.this.jTextField3.setText("");
        VentanaTickets.this.campo_base.setText("");
        VentanaTickets.this.jTextArea1.setText("");
    }


    private void minitComponents() {

        //creacion de componentes visuales
        
        PanelFondo jPanel1 = new PanelFondo("fondo.jpg");
        PanelFondo jPanel2 = new PanelFondo("fondo.jpg");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        PanelFondo jPanel3 = new PanelFondo("fondo.jpg");
        jLabel1 = new javax.swing.JLabel();
        PanelFondo jPanel4 = new PanelFondo("fondo.jpg");
        jButton1 = new javax.swing.JButton();
        PanelFondo jPanel5 = new PanelFondo("fondo.jpg");
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        PanelFondo jPanel6 = new PanelFondo("fondo.jpg");
        PanelFondo jPanel7 = new PanelFondo("fondo.jpg");
        JButton calcular = new JButton();
        
        jPanel6.setLayout(new GridLayout(2,1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setLineWrap(true); 

        jPanel2.add(jScrollPane1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Texto:");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new FlowLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Generar ticket");
        
        //boton de generacion del ticket
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

               
                generar_ticket();
                
                
            }

            
        });
        
        //boton para generar e imprimir a la vez
        JButton boton_gen_imprimir= new JButton();
       
        boton_gen_imprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton_gen_imprimir.setText("Generar ticket e imprimir");

        boton_gen_imprimir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {


                if(valido)
                {
                    generar_ticket();
                    VentanaTickets.this.imprimir(jTextArea1.getText());   
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Debe calcular los costes primero ");
                }
                               
                    

            }
        });
        
        //boton para borrar el contenido del ticket
        JButton boton_borrar=new JButton();
        boton_borrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                borrar();
            }
        });
        boton_borrar.setText("Nuevo ticket");
        boton_borrar.setFont(new java.awt.Font("Tahoma", 1, 11));
        jPanel4.add(boton_borrar);
        jPanel4.add(jButton1);
        jPanel4.add(boton_gen_imprimir);
        

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new java.awt.GridLayout(6, 2, 5, 5));
        
        Border border = new TitledBorder("Costes");
        Border margin = new EmptyBorder(10,10,10,10);
        jPanel5.setBorder(new CompoundBorder(border, margin));


        
        JLabel label_base= new JLabel();
        label_base.setText("Base");
        campo_base= new JTextField();
        jPanel5.add(label_base);
        jPanel5.add(campo_base);
        JLabel label_iva= new JLabel();
        label_iva.setText("IVA");
        campo_iva= new JTextField();
        campo_iva.setText("21");
        jPanel5.add(label_iva);
        jPanel5.add(campo_iva);
        
        jLabel2.setText("Total");
        jPanel5.add(jLabel2);
        jPanel5.add(jTextField1);

        jLabel3.setText("Entregado");
        jPanel5.add(jLabel3);
        jPanel5.add(jTextField2);

        jLabel4.setText("Cambio");
        jPanel5.add(jLabel4);
        jPanel5.add(jTextField3);
        
        jPanel5.add(new JLabel());
        
        
        
        
         
        calcular.setText("Calcular");
        
        //boton para calcular el IVA etc.
        calcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                calcular_costes();
                
            }

            
        });
        jPanel5.add(calcular);

        jPanel6.add(jPanel5);
        
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10,10));        

        jPanel1.add(jPanel6, java.awt.BorderLayout.EAST);
        
        jTextArea1.setFont(new Font("Lucida Console", Font.PLAIN, 8));
        
        Border border2 = new TitledBorder("Fuente");
        Border margin2 = new EmptyBorder(10,10,10,10);

        jPanel7.setBorder(new CompoundBorder(border2, margin2));
        jPanel7.setLayout(new FlowLayout());
        JLabel lab_fuente= new JLabel();
        lab_fuente.setText("Tamaño fuente: ");
        jPanel7.add(lab_fuente);
        JComboBox combo= new JComboBox();
        for (int i = 4; i <= 20; i++) {
            combo.addItem(i);
            
        }
        combo.setSelectedIndex(4);
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 VentanaTickets.this.jTextArea1.setFont(new Font("Lucida Console", Font.PLAIN, (Integer) combo.getSelectedItem()));
               
            }
        });
        jPanel7.add(combo);
        
        
        
        jPanel6.add(jPanel7);

        getContentPane().add(jPanel1);

        pack();
        
        this.jTextArea1.append(texto);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Texto:");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Generar ticket");
        jPanel4.add(jButton1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel6.setLayout(new java.awt.GridLayout(2, 1));

        jPanel5.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        jLabel2.setText("Total");
        jPanel5.add(jLabel2);
        jPanel5.add(jTextField1);

        jLabel3.setText("Entregado");
        jPanel5.add(jLabel3);
        jPanel5.add(jTextField2);

        jLabel4.setText("Cambio");
        jPanel5.add(jLabel4);
        jPanel5.add(jTextField3);

        jPanel6.add(jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7);

        jPanel1.add(jPanel6, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    
    
}
