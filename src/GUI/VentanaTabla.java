

package GUI;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import pojos.Cliente;
import pojos.Factura;
import pojos.Producto;


public class VentanaTabla extends javax.swing.JFrame {

    
    String titulo;
    LinkedList lista;
    Class clase;
    Field[] campos;
    String[] lab_campos;
    DefaultTableModel modelo_tabla;
    PanelFondo jPanel1;
    
    public VentanaTabla(String tit,Class c) {
        
         jPanel1=new PanelFondo("fondo.jpg");
         
        minitComponents();
        
      
       
        this.setSize(650,500);
        this.setLocationRelativeTo(null);
        this.clase=c;
        campos= new Field[clase.getDeclaredFields().length];
        campos=clase.getDeclaredFields();
        int longitud=campos.length;
        
        if(this.clase==Factura.class) longitud--;
        if(this.clase==Producto.class) longitud--;
        
        lab_campos= new String[longitud];
        this.jPanel1.setOpaque(false);
        titulo=tit;
        this.setTitle(tit);
        
        int index=0;
        
        
        
        for (int i = index; i < longitud; i++) {
            lab_campos[i] = campos[i].getName();
            
        }
        
        modelo_tabla= new DefaultTableModel();
        modelo_tabla.setColumnIdentifiers(lab_campos);
        this.jTable2.setModel(modelo_tabla);
    }


    
    public void cargarTabla(List lista) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        
    
        if(clase==Cliente.class)
        {
            
            Object[] objs= new Object[Cliente.class.getDeclaredFields().length];
            Field[] campos= Cliente.class.getDeclaredFields();

            Method[] todos_metodos=clase.getDeclaredMethods();
            LinkedList<Method> getters=new LinkedList();
            for (Method method : todos_metodos) {
                if(method.getName().toLowerCase().contains("get"))
                {
                    getters.add(method);
                }
                
            }
        
            List list=lista;
            
            for (Object f : list) {
                for (int i = 0; i < campos.length; i++) {
                    
                    for (int j = 0; j < getters.size(); j++) {
                        if(getters.get(j).getName().toLowerCase().contains(campos[i].getName().toLowerCase()))
                        {
                            objs[i] = getters.get(j).invoke(f);  
                            break;
                        }
                    }
                     
                }
                modelo_tabla.addRow(objs);
               
            }
        }
        if(clase==Factura.class)
        {
            
            Object[] objs= new Object[Factura.class.getDeclaredFields().length];
            Field[] campos= Factura.class.getDeclaredFields();

            Method[] todos_metodos=clase.getDeclaredMethods();
            LinkedList<Method> getters=new LinkedList();
            for (Method method : todos_metodos) {
                if(method.getName().toLowerCase().contains("get"))
                {
                    getters.add(method);
                }
                
            }
        
            List list=lista;
            
            for (Object f : list) {
                for (int i = 0; i < campos.length; i++) {
                    
                    for (int j = 0; j < getters.size(); j++) {
                        
                        if(getters.get(j).getName().toLowerCase().contains(campos[i].getName().toLowerCase()))
                        {
                            
                                objs[i] = getters.get(j).invoke(f);  
                            
                            
                            break;
                        }
                    }
                     
                }
                modelo_tabla.addRow(objs);
               
            }
        }
        if(clase==Producto.class)
        {
            
            Object[] objs= new Object[Producto.class.getDeclaredFields().length];
            Field[] campos= Producto.class.getDeclaredFields();

            Method[] todos_metodos=clase.getDeclaredMethods();
            LinkedList<Method> getters=new LinkedList();
            for (Method method : todos_metodos) {
                if(method.getName().toLowerCase().contains("get"))
                {
                    getters.add(method);
                }
                
            }
        
            List list=lista;
            
            for (Object f : list) {
                for (int i = 0; i < campos.length; i++) {
                    
                    for (int j = 0; j < getters.size(); j++) {
                        if(getters.get(j).getName().toLowerCase().contains(campos[i].getName().toLowerCase()))
                        {
                            
                            objs[i] = getters.get(j).invoke(f);  
                            
                            
                            break;
                        }
                    }
                     
                }
                modelo_tabla.addRow(objs);
               
            }
        }
        
    }
    
    private void minitComponents() {

        
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable2.setAutoCreateRowSorter(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);

        this.setDefaultCloseOperation(VentanaTabla.DISPOSE_ON_CLOSE);
        
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
    

 /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/

   
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
*/
    }
