

package GUI;

import DAOs.ClienteDAO;
import DAOs.FacturaDAO;
import DAOs.ProductoDAO;
import data.HibernateUtil;
import data.Main;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pojos.Cliente;
import pojos.Facprod;
import pojos.Factura;
import pojos.Producto;


public class PanelControl extends javax.swing.JPanel {


    PanelDatos panel_datos;
    Class clase;
    Object objeto_sel;
    public JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    
    public PanelControl(PanelDatos pan,Class c) {
        this.panel_datos=pan;
        clase=c;
        this.setOpaque(false);
        minitComponents();
        
    }

    
    public List buscar()
    {
        List objs = new LinkedList();
        List lista=null;
        if(clase.getName().toLowerCase().contains("cliente"))
        {
            lista=Main.getLista_clientes();
            for (Object o : lista) {
                Cliente c=(Cliente)o;
                if(c.getDnicliente().compareToIgnoreCase(panel_datos.getPrimary())==0)
                {
                    objs.add(c);
                    break;
                }                
                
            }
 
            if(objs.isEmpty())
            {
                if(!panel_datos.getSecondary().isEmpty())
                {
                    for (Object o : lista) {
                        Cliente c=(Cliente)o;
                        if(c.getNombre().compareToIgnoreCase(panel_datos.getSecondary())==0)
                        {
                            objs.add(c);
                        } 


                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Introduzca algun nombre");
                }
                
            }
            return objs;
        }
        if(clase.getName().toLowerCase().contains("factura"))
        {
            lista=Main.getLista_facturas();
            for (Object o : lista) 
            {
                Factura f=(Factura)o;
                if(f.getDniCliente().compareToIgnoreCase(panel_datos.getPrimary())==0)
                {
                   objs.add(f);
                   break;
                }
                
            }
            if(objs.isEmpty())
            {
                if(!panel_datos.getSecondary().isEmpty())
                {
                    for (Object o : lista) 
                    {
                        Factura f=(Factura)o;
                        if(f.getIdFactura()==Integer.parseInt(panel_datos.getSecondary()))
                        {
                           objs.add(f);
                        }

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Introduzca algun ID");
                }
            }
            return objs;

        }
        if(clase.getName().toLowerCase().contains("producto"))
        {
            lista=Main.getLista_productos();
            for (Object o : lista) {
                Producto p=(Producto)o;
                System.out.println("nombre: "+String.valueOf(p.getNombre()));
                System.out.println("primary: "+panel_datos.getPrimary());
                if(String.valueOf(p.getNombre()).compareToIgnoreCase(panel_datos.getPrimary())==0)
                {
                  objs.add(p);
                  break;
                          
                }
               
            }
            if(objs.isEmpty())
            {
                if(!panel_datos.getSecondary().isEmpty())
                {
                    for (Object o : lista) {
                        Producto p=(Producto)o;
                        if(p.getIdProducto()==Integer.parseInt(panel_datos.getSecondary()))
                        {
                          objs.add(p);
                        }

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Introduzca algun ID");
                }
            }
            
            return objs;
        }


        
        return objs;
    }
    
    public List listar(Class cla)
    {
        List objs=null;
        
        return objs;
    }
    
    private void minitComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 5, 5));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Listar todos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setText("Eliminar actual");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Guardar/Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.setText("Resetear campos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        add(jPanel1);
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 5, 5));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Listar todos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setText("Eliminar actual");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.setText("Resetear campos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
            //BUSCAR
        
            try
            {
                
                List l=this.buscar();
                List<JTextField> fields=panel_datos.getFields();
                List<JLabel> labels=panel_datos.getLabels();

                if(l.size()==1)
                {

                    panel_datos.resetearCampos();
                    Cliente cli=null;
                    Factura fac=null;
                    Producto prod=null;
                    Method[] metodos=null;
                    Field[] campos=null;

                    if(clase.getName().toLowerCase().contains("cliente"))
                    {
                        cli=(Cliente) l.remove(0);
                        this.objeto_sel=cli;
                        metodos=cli.getClass().getDeclaredMethods();
                        campos = cli.getClass().getDeclaredFields();
                    }
                    if(clase.getName().toLowerCase().contains("producto"))
                    {
                        prod=(Producto) l.remove(0);
                        this.objeto_sel=prod;
                        metodos=prod.getClass().getDeclaredMethods();
                        campos = prod.getClass().getDeclaredFields();
                    }
                    if(clase.getName().toLowerCase().contains("factura"))
                    {
                        fac=(Factura) l.remove(0);
                        this.objeto_sel=fac;
                        metodos=fac.getClass().getDeclaredMethods();
                        campos = fac.getClass().getDeclaredFields();
                    }



                    int i=0;
                    for (JLabel label : labels) {

                        for (Field field : campos) {

                            if(field.getName().compareToIgnoreCase(label.getText().toLowerCase())==0)
                            {
                                for (Method met: metodos) {
                                    //System.out.println(met.getName()+" - "+field.getName());
                                    if(met.getName().toLowerCase().contains(field.getName().toLowerCase()) &&
                                       met.getName().toLowerCase().contains("get"))
                                    {
                                        try {

                                            String s="";
                                            met.setAccessible(true);
                                            if(clase.getName().toLowerCase().contains("cliente"))
                                            {
                                                s=String.valueOf(met.invoke(cli));
                                            }
                                            if(clase.getName().toLowerCase().contains("producto"))
                                            {
                                                
                                                
                                                s=String.valueOf(met.invoke(prod));
                                                
                                            }
                                            if(clase.getName().toLowerCase().contains("factura"))
                                            {
                                                try
                                                {
                                                    s=String.valueOf(met.invoke(fac));
                                                }
                                                catch(Exception ex)
                                                {
                                                    s=(String) met.invoke(fac);
                                                }

                                            }

                                            fields.get(i).setText(s);
                                            i++;
                                            break;
                                        } catch (Exception ex) {
                                            Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                                            System.out.println(""+ex.getMessage());
                                        }
                                    }
                                }

                            }

                        }


                    }

                    if(clase.getName().toLowerCase().contains("cliente"))
                    {
                        List<Factura> facturas=Main.getfDAO().obtenFacturasCliente(cli);
                        VentanaPrincipal ven=panel_datos.getVentana();

                        try {
                            ven.getPanelTabla(1).cargarTabla(facturas);
                        } catch (Exception ex) {
                            System.out.println(""+ex.getMessage());
                            Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                    if(clase.getName().toLowerCase().contains("factura"))
                    {
                        List<Producto> productos=Main.getFpDAO().obtenProductosFactura(fac.getIdFactura());
                        
                        VentanaPrincipal ven=panel_datos.getVentana();

                        try {
                            ven.getPanelTabla(2).cargarTabla(productos);
                        } catch (Exception ex) {
                            Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }




                }
                else if(l.size()>1)
                {
                    panel_datos.resetearCampos();

                    VentanaTabla vt=null;
                    if(clase.getName().toLowerCase().contains("cliente"))   vt=new VentanaTabla("Lista Clientes",Cliente.class);
                    if(clase.getName().toLowerCase().contains("producto"))   vt=new VentanaTabla("Lista Productos",Producto.class);
                    if(clase.getName().toLowerCase().contains("factura"))   vt=new VentanaTabla("Lista Facturas",Factura.class);
                    try {
                        vt.cargarTabla(l);
                    } catch (Exception ex) {
                        Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vt.setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No se encontraron coincidencias");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
            }
            
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        //LISTAR TODOS
        
        try
        {
            if(Cliente.class==this.clase)
            {
                List<Cliente> l= Main.getLista_clientes();
                panel_datos.resetearCampos();
                VentanaTabla vt=new VentanaTabla("Lista Clientes",Cliente.class);
                try {
                    vt.cargarTabla(l);
                } catch (Exception ex) {
                    Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                vt.setVisible(true);
            }
            if(Factura.class==this.clase)
            {
                List<Factura> l= Main.getLista_facturas();
                panel_datos.resetearCampos();
                VentanaTabla vt=new VentanaTabla("Lista Facturas",Factura.class);
                try {
                    vt.cargarTabla(l);
                } catch (Exception ex) {
                    Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                vt.setVisible(true);
            }
            if(Producto.class==this.clase)
            {
                List<Producto> l= Main.getLista_productos();
                panel_datos.resetearCampos();
                VentanaTabla vt=new VentanaTabla("Lista Productos",Producto.class);
                try {
                    vt.cargarTabla(l);
                } catch (Exception ex) {
                    Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                vt.setVisible(true);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        //ELIMINAR
        
        try
        {
            if(this.objeto_sel!=null)
            {
                if(this.clase==Cliente.class)
                {
                    Cliente cli=(Cliente)this.objeto_sel;
                    ClienteDAO clidao=Main.getcDAO();
                    eliminarFacturasCliente(cli);
                    clidao.eliminaCliente(cli);
                    JOptionPane.showMessageDialog(null,"Cliente eliminado con éxito: ");
                    this.resetearCampos();
                }
                if(this.clase==Factura.class)
                {

                        Factura fac=(Factura)this.objeto_sel;
                        FacturaDAO facdao=Main.getfDAO();
                        eliminarFacprodsFactura(fac);
                        facdao.eliminaFactura(fac);
                        JOptionPane.showMessageDialog(null,"Factura eliminada con éxito: ");
                        this.resetearCampos();



                }  
                if(this.clase==Producto.class)
                {

                        Producto pro=(Producto)this.objeto_sel;
                        ProductoDAO prodao=Main.getpDAO();
                        eliminarFacprodsProducto(pro);
                        prodao.eliminaProducto(pro);
                        JOptionPane.showMessageDialog(null,"Producto eliminado con éxito: ");
                        this.resetearCampos();



                }  

                

            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        //GUARDAR / ACTUALIZAR CLIENTE
        
        try
        {
            if(this.objeto_sel!=null)
            {

                if(this.clase.getName().toLowerCase().contains("cliente"))
                {
                    
                        Cliente cli=(Cliente)this.objeto_sel;
                        boolean v=rellenarCliente(cli);
                        if(v)
                        {
                            ClienteDAO clidao=Main.getcDAO();
                            int i=cli.getIdcliente();
                            boolean ver=clidao.actualizaCliente(cli,i);

                            if(ver==true)
                            {
                                JOptionPane.showMessageDialog(null,"Cliente actualizado con éxito");
                                this.resetearCampos();
                            }
                        }
                        
                   
                }
                if(this.clase.getName().toLowerCase().contains("factura"))
                {
                    
                        Factura fac=(Factura)this.objeto_sel;
                        boolean v=rellenarFactura(fac);
                        if(v)
                        {
                            FacturaDAO facdao=Main.getfDAO();
                            int i=fac.getIdFactura();
                            facdao.actualizaFactura(fac);


                            JOptionPane.showMessageDialog(null,"Factura actualizada con éxito");
                            this.resetearCampos();
                        }
                        

                    
                }
                if(this.clase.getName().toLowerCase().contains("producto"))
                {
                    

                        Producto prod=(Producto)objeto_sel;
                        boolean v=rellenarProducto(prod);
                        if(v)
                        {
                            ProductoDAO prodao=Main.getpDAO();
                            prodao.actualizaProducto(prod);
                            JOptionPane.showMessageDialog(null,"Producto actualizado con éxito");
                            this.resetearCampos();
                        }
                        
                    
                }



            }
            else
            {
                if(this.clase.getName().toLowerCase().contains("cliente"))
                {
                    

                        Cliente cli=new Cliente();
                        boolean v=rellenarCliente(cli);
                        if(v)
                        {
                            ClienteDAO clidao=Main.getcDAO();
                            clidao.guardaCliente(cli);
                            JOptionPane.showMessageDialog(null,"Cliente insertado con éxito");
                            this.resetearCampos();
                        }
                        
                    
                }
                if(this.clase.getName().toLowerCase().contains("factura"))
                {
                    

                        Factura fac=new Factura();
                        boolean v=rellenarFactura(fac);
                        if(v)
                        {
                            FacturaDAO facdao=Main.getfDAO();
                            facdao.guardaFactura(fac);
                            JOptionPane.showMessageDialog(null,"Factura insertada con éxito");
                            this.resetearCampos();
                        }
                        
                        
                   
                }
                if(this.clase.getName().toLowerCase().contains("producto"))
                {
                    

                        Producto prod=new Producto();
                        boolean v=rellenarProducto(prod);
                        if(v)
                        {
                            ProductoDAO prodao=Main.getpDAO();
                            prodao.guardaProducto(prod);
                            JOptionPane.showMessageDialog(null,"Producto insertado con éxito");
                            this.resetearCampos();
                        }
                        
                    
                }


            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        this.resetearCampos();
    }//GEN-LAST:event_jButton5ActionPerformed

    public void resetearCampos()
    {
        panel_datos.resetearCampos();
        this.objeto_sel=null;
    }
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
*/
    private boolean rellenarCliente(Cliente cli) {
        
            try
            {
                Field[] fields=Cliente.class.getDeclaredFields();
                Method[] me=Cliente.class.getDeclaredMethods();
                Method[] setters=new Method[fields.length];
                int i=0;
                for (Method method : me) {
                    if(method.getName().toLowerCase().contains("set"))
                    {
                        
                            setters[i]=method;
                            i++;
                        
                       
                    }
                }
                i=1;
                
                LinkedList<JTextField> texts=panel_datos.fields;
                for (Field fi :  fields) {
                    System.out.println("field: "+fi.getName());
                    for (Method method : setters) {
                        //System.out.println("met: "+method.getName());
                        if(method.getName().toLowerCase().contains(fi.getName().toLowerCase()))
                        {
                            if(!fi.getName().toLowerCase().startsWith("id"))
                            {
                                 
                                
                                    method.invoke(cli, texts.get(i).getText());
                                    System.out.println(""+texts.get(i).getName());
                                    i++;
                                
                            }

                        }


                    }

                }
                boolean v=comprobarCliente(cli);
                return v;
                
                
                
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
                return false;
            }
                

                
    }

    private boolean rellenarFactura(Factura fac) throws ParseException {
        
        try
        {
            LinkedList<JTextField> texts=panel_datos.fields;
            String dni=texts.get(1).getText();
            List<Cliente> cliente=HibernateUtil.executeQuery("from Cliente where dnicliente='"+dni+"'");
            if(cliente.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"No se encontro ningún DNI: "+texts.get(1).getText());
            }
            else
            {

                fac.setDniCliente(cliente.get(0).getDnicliente());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dateInString = texts.get(2).getText();

                if(dateInString.isEmpty())
                {
                    Date date = new Date();
                    fac.setFecha(date);
                        
                }
                else
                {
                    try                    
                    {
                        
                        
                        Date date = formatter.parse(dateInString);
                        fac.setFecha(date);
                    }
                    catch(Exception ex)
                    {

                        JOptionPane.showMessageDialog(null,"Error al convertir fecha, formato valido: AAAA-MM-DD");
                        
                        return false;
                    } 
                }
                


                fac.setAtendido(texts.get(3).getText());
                try                    
                {
                    float flo=Float.parseFloat(texts.get(4).getText());
                    fac.setImporte(flo);
                }
                catch(Exception ex)
                {
                    fac.setImporte(0.0f);
                }
                
                
            }
            return true;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
            return false;
        }
        
        
        
        
        
        
       
    }

    private boolean rellenarProducto(Producto prod) {
        
        boolean v=true;
        try
        {
            LinkedList<JTextField> texts=panel_datos.fields;
        
            
            prod.setNombre(texts.get(1).getText());

            prod.setStock(Integer.parseInt(texts.get(2).getText()));


            prod.setPrecio(Float.parseFloat(texts.get(3).getText()));
            if(prod.getNombre().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null,"El producto debe tener un nombre");
                return false;
                
            }
            if(prod.getStock()<0) 
            {
                JOptionPane.showMessageDialog(null,"El producto debe tener un  stock igual o mayor a 0");
                return false;
                
            }
            if(prod.getPrecio()<=0) 
            {
                JOptionPane.showMessageDialog(null,"El producto debe tener un precio mayor que 0");
                return false;
                
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex.getMessage());
            return false;
        }
        return v;
        
        
    }

    private boolean comprobarDniCliente(String dnicliente) {
        
        boolean v=true;
        dnicliente=dnicliente.toLowerCase();
        if(dnicliente.length()>9 || dnicliente.length()<9)
        {
            return false;
        }
        int cl=0;
        int cn=0;
        for (int i = 0; i < dnicliente.length(); i++) {
            if(dnicliente.charAt(i)>='0' && dnicliente.charAt(i)<='9')
            {
                cn++;
            }
            if(dnicliente.charAt(i)>='a' && dnicliente.charAt(i)<='z')
            {
                cl++;
            }
            
        }
        if(cn!=8 || cl!=1)
        {
            return false;
        }
        return v;
    }

    private boolean comprobarCliente(Cliente cli) {
        
        boolean v=false;
        if(!cli.getDnicliente().isEmpty())
        {
            if(comprobarDniCliente(cli.getDnicliente()))
            {
                if(!cli.getNombre().isEmpty())
                {
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Debe introducir el nombre del cliente");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"DNI no válido: debe introducir 9 caracteres sin guiones");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El DNI del cliente debe rellenarse");
        }
        return v;
    }

    private void eliminarFacturasCliente(Cliente cli) {
        List<Factura> facturas = Main.getfDAO().obtenFacturasCliente(cli);
        for (Factura factura : facturas) {
            Main.getfDAO().eliminaFactura(factura);
        }
    }

    private void eliminarFacprodsFactura(Factura fac) {
        List<Facprod> facprods=Main.getFpDAO().obtenFacProdsFactura(fac.getIdFactura());
        for (Facprod facprod : facprods) {
            Main.getFpDAO().eliminaFacprod(facprod);
        }
    }

    private void eliminarFacprodsProducto(Producto pro) {
        List<Facprod> facprods=Main.getFpDAO().obtenFacProdsProducto(pro.getIdProducto());
        for (Facprod facprod : facprods) {
            Main.getFpDAO().eliminaFacprod(facprod);
        }
    }
}
