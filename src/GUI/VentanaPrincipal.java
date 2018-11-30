
package GUI;

import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pojos.Cliente;
import pojos.Factura;
import pojos.Producto;


public class VentanaPrincipal extends javax.swing.JFrame {

    


    PanelTabla jPanel_tab2=null;
    
    public VentanaPrincipal() {
        Field[] campos=Cliente.class.getDeclaredFields();
        for (int i = 0; i < campos.length; i++) {
            System.out.println(campos[i].getName());
            
        }
        minitComponents();
        this.setTitle("Ispercolor");
        this.setSize(600,700);
        this.setLocationRelativeTo(null);
        
        
    }
    
    public void escribirEnLista(List<String> lista)
    {
        
        for (String s : lista) {
            this.jList1.add(s, this);
        }
        
    }

    public PanelTabla getPanelTabla()
    {
        return (PanelTabla) jPanel6;
    }
    
     private void minitComponents() {

         /*tabbed pane 1*/
         
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelFondo jPanel1 = new PanelFondo("fondo.jpg");
        PanelFondo jPanel2 = new PanelFondo("fondo.jpg");
        PanelFondo jPanel3 = new PanelFondo("fondo.jpg");
        PanelFondo jPanel4 = new PanelFondo("fondo.jpg");
        PanelDatos jPanel5 = new PanelDatos(Cliente.class,"Datos cliente",this);
     
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        PanelControl jPanel8 = new PanelControl(jPanel5,Cliente.class);
        jPanel6 = new PanelTabla("Lista facturas", Factura.class,jPanel8);
        
     

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.setBorder(new EmptyBorder(10,10,10,10));

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);
        

        

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel7.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jButton1.setText("Buscar");
        jPanel7.add(jButton1);

        jButton2.setText("Listar todos");
        jPanel7.add(jButton2);

        jButton3.setText("Eliminar actual");
        jPanel7.add(jButton3);

        jButton4.setText("Guardar cambios");
        jPanel7.add(jButton4);
        
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        
        //jPanel8.setLayout(new java.awt.GridLayout(2, 1));
        
        //jPanel8.add(jPanel7);

        jPanel1.add(jPanel8, java.awt.BorderLayout.EAST);

        jTabbedPane1.addTab("Clientes", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Facturas", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Productos", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        

        getContentPane().add(jTabbedPane1);
        
        /*tabbed pane 2*/
        
        PanelDatos jPanel9 = new PanelDatos(Factura.class,"Datos facturas",this);
        
        PanelControl jPanel_con2 = new PanelControl(jPanel9,Factura.class);
        
        
        jPanel_tab2 = new PanelTabla("Lista productos",Producto.class,jPanel_con2);
        PanelFactura pan_fac=new PanelFactura(jPanel_con2,jPanel_tab2);
        jPanel_con2.add(pan_fac);
        JPanel jPanel11 = new JPanel();
        jPanel11.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel11.setLayout(new GridLayout(2,1));
        jPanel11.add(jPanel9);
        JPanel pan_fon= new JPanel();
        pan_fon.setOpaque(false);
        jPanel11.add(jPanel_tab2);
        
        jPanel2.add(jPanel11, java.awt.BorderLayout.CENTER);
        jPanel2.add(jPanel_con2, java.awt.BorderLayout.EAST);
        
        
        /*tabbed pane 3*/
        
        PanelDatos jPanel12 = new PanelDatos(Producto.class,"Datos productos",this);
        PanelControl jPanel13 = new PanelControl(jPanel12,Producto.class);
        
        JPanel jPanel14 = new JPanel();
        
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel14.setLayout(new GridLayout(2,1));
        jPanel14.add(jPanel12);
       
        jPanel14.setOpaque(false);
   
        JPanel panel_trans=new JPanel();
        panel_trans.setOpaque(false);
        jPanel14.add(panel_trans);
        jPanel3.add(jPanel14, java.awt.BorderLayout.CENTER);
        jPanel3.add(jPanel13, java.awt.BorderLayout.EAST);
        
       

        pack();
    }

    @SuppressWarnings("unchecked")
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Lista clientes")));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel8.setLayout(new java.awt.GridLayout(2, 1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel7.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jButton1.setText("Buscar");
        jPanel7.add(jButton1);

        jButton2.setText("Listar todos");
        jPanel7.add(jButton2);

        jButton3.setText("Eliminar actual");
        jPanel7.add(jButton3);

        jButton4.setText("Guardar cambios");
        jPanel7.add(jButton4);

        jPanel8.add(jPanel7);

        jPanel1.add(jPanel8, java.awt.BorderLayout.EAST);

        jTabbedPane1.addTab("Clientes", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel9, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel10, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel11, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Facturas", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Productos", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Datos tienda", jPanel4);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private PanelTabla jPanel6 ;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
*/
    void resetearLista() {
        this.jPanel6.resetearLista();
        jPanel_tab2.resetearLista();
    }

    PanelTabla getPanelTabla(int i) {
        
        PanelTabla ret=null;
        
        switch(i)
        {
            case 1:
                ret=(PanelTabla) jPanel6;
            break;
                
            case 2:
                ret= jPanel_tab2;
            break;
                
            default:
            
                ret= null;
            break;
            
        }
        return ret;
    
        
    }

}
