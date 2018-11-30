/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import data.Main;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojos.Cliente;
import pojos.Facprod;
import pojos.Factura;
import pojos.Producto;


public class PanelTabla extends javax.swing.JPanel {

    String titulo;
    LinkedList lista;
    Class clase;
    Field[] campos;
    String[] lab_campos;
    DefaultTableModel modelo_tabla;
    PanelControl panelcontrol;
    List lista_provisional;
    
    public PanelTabla(String tit,Class c,PanelControl pc) {
        
        this.panelcontrol=pc;
        minitComponents();
        this.clase=c;
        
        this.setOpaque(false);
        titulo=tit;
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(tit));
            
        if(clase!=Producto.class)
        {
            campos= new Field[clase.getDeclaredFields().length];
            campos=clase.getDeclaredFields();
            lab_campos= new String[clase.getDeclaredFields().length-1];
            

            for (int i = 0; i < campos.length-1; i++) {
                lab_campos[i] = campos[i].getName();

            }
        }
        else
        {
            
            lab_campos= new String[4];
            

            lab_campos[0]="Idproducto";
            lab_campos[1]="Nombre";
            lab_campos[2]="Cantidad";
            lab_campos[3]="Importe";
        }
        
        
        modelo_tabla= new DefaultTableModel();
        modelo_tabla.setColumnIdentifiers(lab_campos);
        jTable1.setModel(modelo_tabla);
       
        
       
    }

    private void minitComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.BorderLayout());

        jTable1.setAutoCreateRowSorter(true);
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
        jScrollPane1.setAutoscrolls(true);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        jTable1.setPreferredScrollableViewportSize(new Dimension(500, 80));
        jTable1.setFillsViewportHeight(true);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }
    
    public void cargarTabla(List lista) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        if(lista_provisional==null)
        {
            this.lista_provisional=lista;
        }
        else
        {
            int x=0;
            x+=1;
        }
        
        if(clase==Factura.class)
        {
          
            List<Factura> list;
            list = Main.getfDAO().obtenFacturasCliente(((Cliente)this.panelcontrol.objeto_sel));
            Object[] objs= new Object[Factura.class.getDeclaredFields().length];
            int i=0;
            for (Factura fac : list) {
                 objs[0]=fac.getIdFactura();
                 objs[1]=fac.getDniCliente();
                 objs[2]=fac.getFecha();
                 objs[3]=fac.getAtendido();
                 objs[4]=fac.getImporte();
                 modelo_tabla.addRow(objs);
                 
            }
                 
                
            
            
        }
        if(clase==Producto.class)
        {
           
            List<Producto> list=Main.getpDAO().obtenProductosFactura(((Factura)this.panelcontrol.objeto_sel).getIdFactura());
            List<Facprod> facprods= Main.getFpDAO().obtenFacProdsFactura(((Factura)this.panelcontrol.objeto_sel).getIdFactura());
            Object[][] objs= new Object[facprods.size()][2];
            Object[][] objs2= new Object[facprods.size()][2];
            Object[][] objs3= new Object[facprods.size()][4];
            int i=0;
            for (Producto prod : list) {
                 objs[i][0]=prod.getIdProducto();
                 objs[i][1]=prod.getNombre();
                 i++;
                 
            }
            i=0;
            for (Facprod fp:facprods) {
                objs2[i][0]=fp.getCantidad();
                objs2[i][1]=fp.getImporte();
                i++;
            }
            for (i = 0; i < objs3.length;i++) {
                for (int j = 0; j < 4; j++) 
                {
                    if(j<=1)
                    {
                        objs3[i][j]=objs[i][j];
                    }
                    else
                    {
                        if(j==2)
                        {
                             objs3[i][j]=objs2[i][0];
                        }
                        else
                        {
                             objs3[i][j]=objs2[i][1];
                        }

                    }

                    

                }
                modelo_tabla.addRow(objs3[i]);
                
            }
            
            
             
        }
        
    }
    public void recargar() 
    {
        try
        {
            this.resetear();
            this.cargarTabla(lista_provisional);
        }
        catch(Exception ex)
        {
            
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.BorderLayout());

        jTable1.setAutoCreateRowSorter(true);
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    void resetear() {
        
        modelo_tabla.setRowCount(0);
       
        
    }
    void resetearLista() {
        
        modelo_tabla.setRowCount(0);
        lista_provisional=null;
        
    }

    void deleteSelectedRow() {
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
            try
            {
                
                     Producto prod=new Producto();
                     prod.setIdProducto((Integer) valor[0]);
                     prod.setNombre((String) valor[1]);
                     prod.setStock((Integer) valor[2]);
                     prod.setPrecio((Float) valor[3]);
                     
                     eliminarProducto(prod);
                
                    
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Cantidad introducida no válida");
            }
        }
    }

    private void eliminarProducto(Producto prod) {
        
        Facprod fp_elim=null;
        Factura factura=(Factura)this.panelcontrol.objeto_sel;
        
        List<Facprod> facprods=Main.getFpDAO().obtenFacProdsFactura(factura.getIdFactura());
        for (Facprod fp : facprods) {
            if((fp.getProducto().getIdProducto()==prod.getIdProducto()) && fp.getFactura().getIdFactura()
               ==
               factura.getIdFactura())
            {
                fp_elim=fp;
            }
        }
        factura.setImporte(factura.getImporte()-fp_elim.getCantidad()*prod.getPrecio());
        Main.getfDAO().actualizaFactura(factura);
        if(fp_elim!=null)
        {
            try
            {
                Main.getFpDAO().eliminaFacprod(fp_elim);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
            }
            
        }
        JOptionPane.showMessageDialog(null,"Producto eliminado");
        this.panelcontrol.jButton1.doClick();
        this.recargar();
    }

  
}
