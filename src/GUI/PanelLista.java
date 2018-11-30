
package GUI;

import java.util.List;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class PanelLista extends javax.swing.JPanel {


    private javax.swing.JList jList1;
    JScrollPane jScrollPane1;
    String titulo;
    List lista;
    
    public PanelLista(String s,List l) {
        this.titulo=s;
        this.lista=l;
        this.setOpaque(false);
        minitComponents();
    }

    private void minitComponents() {

        jList1 = new JList();
        jScrollPane1=new JScrollPane();
        
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
        this.setLayout(new java.awt.BorderLayout());

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Factura nº1: 12/06/2013 importe: 45.6e",
                "Factura nº2: 12/06/2013 importe: 65.6e", 
                "Factura nº3: 12/06/2013 importe: 15.6e",
                "Factura nº4: 12/06/2013 importe: 25.6e"};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        this.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
