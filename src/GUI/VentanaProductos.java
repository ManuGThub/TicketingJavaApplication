/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import data.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojos.Facprod;
import pojos.Factura;
import pojos.Producto;


public class VentanaProductos extends javax.swing.JFrame {

    
    int type;
    String string;
    String search="";
    String[] lab_campos;
    DefaultTableModel modelo_tabla;
    PanelTabla pan_tab;
    Factura fac;
    
    public VentanaProductos(int i,String s,Factura f,PanelTabla pt) {
        pan_tab=pt;
        fac=f;
        lab_campos=new String[Producto.class.getDeclaredFields().length-1];
        modelo_tabla = new DefaultTableModel();
        this.type=i;
        this.string=s;
        minitComponents();
        
        this.setTitle("Ventana selección productos");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
    }
    
    
    private void minitComponents() {

       
        PanelFondo jPanel1 = new PanelFondo("fondo.jpg");
        
        PanelFondo jPanel2 = new PanelFondo("fondo.jpg");
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        PanelFondo jPanel3 = new PanelFondo("fondo.jpg");
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        PanelFondo jPanel4 = new PanelFondo("fondo.jpg");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Producto");
        jPanel2.add(jLabel1);
        jPanel2.add(jTextField1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel2.setText("Cantidad");
        jPanel3.add(jLabel2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField2);

        jButton1.setText(string);
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        lab_campos=new String[Producto.class.getDeclaredFields().length-1];
        int n=0;
        for (Field fi : Producto.class.getDeclaredFields()) {
            lab_campos[n]=fi.getName();
            n++;
            if(n>=Producto.class.getDeclaredFields().length-1) break;
        }
        DefaultTableModel modelo_tabla = new DefaultTableModel();
        modelo_tabla.setColumnIdentifiers(lab_campos);
        
        List<Producto> productos=Main.getLista_productos();
        Object[] objs= new Object[Producto.class.getDeclaredFields().length-1];
 
        for (Producto producto : productos) 
        {
            for (int j = 0; j < (Producto.class.getDeclaredFields().length-1); j++) 
            {
                 switch(j)
                {
                    case 0:
                        objs[j]=producto.getIdProducto();
                    break;

                    case 1:
                        objs[j]=producto.getNombre();
                    break;                    

                    case 2:
                        objs[j]=producto.getStock();
                    break;

                    case 3:
                        objs[j]=producto.getPrecio();
                    break;
                }     
                
            }
                  
           
            modelo_tabla.addRow(objs);
            
        }
        
        
        
            
        
    
        jTable1.setModel(modelo_tabla);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.jTextField1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                if(ke.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
                {
                    VentanaProductos.this.search=(jTextField1.getText()+ke.getKeyChar());
                }
                else
                {
                    VentanaProductos.this.search=jTextField1.getText();
                }
                
                if(search.length()>2)
                {
                    int x=0;
                }
                List<Producto> productos=Main.getLista_productos();
                List<Producto> prods=new LinkedList();
                
                for (Object o : productos) {
                    Producto p=(Producto)o;
                    if(String.valueOf(p.getNombre()).toLowerCase().contains(VentanaProductos.this.search))
                    {
                      prods.add(p);
                      break;

                    }

                }
                VentanaProductos.this.cargar(prods);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if(search.compareTo("")==0)
                {
                    VentanaProductos.this.resetear();
                }
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                VentanaProductos.this.pan_tab.recargar();
                dispose();
              
            }
          });
        
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Producto");
        jPanel2.add(jLabel1);
        jPanel2.add(jTextField1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel2.setText("Cantidad");
        jPanel3.add(jLabel2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField2);

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        int r=jTable1.getSelectedRow();
        
        if(r==-1)
        {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un elemento haciendo click sobre el");
        }
        else
        {
            Object[] valor= new Object[lab_campos.length];
            for (int c = 0,j=0; c < lab_campos.length; c++,j++) {
                valor[j]=jTable1.getModel().getValueAt(r,c);

            }
            int num=-1;
            try
            {
                num=Integer.parseInt(jTextField2.getText());
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Cantidad introducida no válida");
            }
                if(num<=(int)(valor[2]))
                {
                     Producto prod=new Producto();
                     prod.setIdProducto((Integer) valor[0]);
                     prod.setNombre((String) valor[1]);
                     prod.setStock((Integer) valor[2]);
                     prod.setPrecio((Float) valor[3]);
                     anadirProducto(fac,prod);
                     fac.setImporte(fac.getImporte()+(prod.getPrecio()*num));
                     Main.getfDAO().actualizaFactura(fac);
                     VentanaProductos.this.search="";
                     VentanaProductos.this.jTextField1.setText("");
                     VentanaProductos.this.jTextField2.setText("");
                     VentanaProductos.this.resetear();
                     VentanaProductos.this.pan_tab.panelcontrol.jButton1.doClick();
                     
                     
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No hay suficiente stock");
                }
            
        }
        
        
        
        
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void resetear() {
        
        modelo_tabla = new DefaultTableModel();
        modelo_tabla.setColumnIdentifiers(lab_campos);
        
        List<Producto> productos=Main.getLista_productos();
        Object[] objs= new Object[Producto.class.getDeclaredFields().length-1];
 
        for (Producto producto : productos) 
        {
            for (int j = 0; j < (Producto.class.getDeclaredFields().length-1); j++) 
            {
                 switch(j)
                {
                    case 0:
                        objs[j]=producto.getIdProducto();
                    break;

                    case 1:
                        objs[j]=producto.getNombre();
                    break;                    

                    case 2:
                        objs[j]=producto.getStock();
                    break;

                    case 3:
                        objs[j]=producto.getPrecio();
                    break;
                }     
                
            }
                  
           
            modelo_tabla.addRow(objs);
            
        }
        VentanaProductos.this.jTable1.setModel(modelo_tabla);
    }

    private void cargar(List<Producto> prods) 
    {
        
        modelo_tabla = new DefaultTableModel();
        modelo_tabla.setColumnIdentifiers(lab_campos);
        
        Object[] objs= new Object[Producto.class.getDeclaredFields().length-1];
 
        for (Producto producto : prods) 
        {
            for (int j = 0; j < (Producto.class.getDeclaredFields().length-1); j++) 
            {
                 switch(j)
                {
                    case 0:
                        objs[j]=producto.getIdProducto();
                    break;

                    case 1:
                        objs[j]=producto.getNombre();
                    break;                    

                    case 2:
                        objs[j]=producto.getStock();
                    break;

                    case 3:
                        objs[j]=producto.getPrecio();
                    break;
                }     
                
            }
                  
           
            modelo_tabla.addRow(objs);
            
        }
        VentanaProductos.this.jTable1.setModel(modelo_tabla);
    }

    private void anadirProducto(Factura fac, Producto prod) 
    {
        try
        {
            int cant=Integer.parseInt(jTextField2.getText());
            prod.setStock(prod.getStock()-cant);
            Main.getpDAO().actualizaProducto(prod);
            List<Facprod> facprods=Main.getLista_fac_prods();
            boolean v=false;
            Facprod facprod_act;
            for (Facprod facprod : facprods) {
                if((facprod.getFactura().getIdFactura()==fac.getIdFactura()) && facprod.getProducto().getIdProducto()==prod.getIdProducto())
                {
                    v=true;
                    facprod.setCantidad(facprod.getCantidad()+cant);
                    facprod.setImporte((float)(cant*prod.getPrecio()));
                    facprod_act=facprod;
                    Main.getFpDAO().actualizaFacprod(facprod_act);


                }
            }
            if(!v)
            {
                Facprod fp=new Facprod();
                fp.setFactura(fac);
                fp.setProducto(prod);
                fp.setCantidad(cant);
                fp.setImporte((float)(cant*prod.getPrecio()));
                Main.getFpDAO().guardaFacProd(fp);
            }
            JOptionPane.showMessageDialog(null,"Producto añadido con éxito");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,""+ex.getMessage());
        }
        
        
    }
}
