

package GUI;

import data.Main;
import java.lang.reflect.Field;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import pojos.Cliente;


public class PanelDatos extends javax.swing.JPanel {

    String titulo;
    Class clase;
    JTextField primary;
    

    JTextField secondary;
    LinkedList<JTextField> fields;
    LinkedList<JLabel> labels;
    VentanaPrincipal ventana;

    public LinkedList<JLabel> getLabels() {
        return labels;
    }

    public void setLabels(LinkedList<JLabel> labels) {
        this.labels = labels;
    }

    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }



    public LinkedList<JTextField> getFields() {
        return fields;
    }

    public void setFields(LinkedList<JTextField> fields) {
        this.fields = fields;
    }
    
    public void resetearCampos()
    {
        for (JTextField text : fields) {
            text.setText("");
        }
        this.ventana.resetearLista();
    }
    
   
    
    
    
    public PanelDatos(Class c,String s,VentanaPrincipal ven) {
        this.ventana=ven;
        
        this.fields=new LinkedList();
        this.labels=new LinkedList();
        this.titulo=s;
        this.clase=c;
        this.setOpaque(false);
        minitComponents();
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    public String getPrimary()
    {
        return this.primary.getText();
    }
    
    public String getSecondary()
    {
        return this.secondary.getText();
    }
    
   private void minitComponents() {

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
         Field[] campos_mostrar = this.clase.getDeclaredFields();
    
         boolean ver=false;
         for (Field field : campos_mostrar) {
           if(field.getName().toLowerCase().contains("facturas")
                      ||
              field.getName().toLowerCase().contains("productos")
                   ||
              field.getName().toLowerCase().contains("facprod"))
                {
                    ver=true;
                }
         }
         int longitud=0;
         if(!ver)
         {
             this.setLayout(new java.awt.GridLayout(campos_mostrar.length,2,5,5));
             longitud=campos_mostrar.length;
         }
         else
         {
             this.setLayout(new java.awt.GridLayout(campos_mostrar.length-1,2,5,5));
             longitud=campos_mostrar.length-1;
         }
         
         for (int i = 0; i < longitud; i++) 
         {
 
                if(!campos_mostrar[i].getName().toLowerCase().contains("facturas")
                       &&
                    !campos_mostrar[i].getName().toLowerCase().contains("productos"))
                {
                    JLabel label=new JLabel();
                    label.setFont(Main.getFuente());
                    label.setText(campos_mostrar[i].getName());
                    CampoTexto text=new CampoTexto(); 

                    if(this.clase==Cliente.class)
                    {
                        if(i==1)
                        {
                            this.primary=text;
                        }
                        if(i==2)
                        {
                            this.secondary=text;
                        }
                        
                    }
                    else
                    {
                        if(i==0)
                        {
                            this.secondary=text;
                        }
                        if(i==1)
                        {
                            this.primary=text;
                        }
                        
                    }
                    text.setName("txt"+label.getText());
                    this.fields.add(text);
                    this.labels.add(label);
                    this.add(label);
                    this.add(text);
                     
                }               
             
           
             
         }
         this.setBorder(new EmptyBorder(15,15,15,15));
         this.setBorder(javax.swing.BorderFactory.createTitledBorder(titulo));
                 
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

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

