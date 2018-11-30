package data;

import DAOs.ClienteDAO;
import DAOs.FacProdDAO;
import DAOs.FacturaDAO;
import DAOs.ProductoDAO;
import GUI.VentanaPrincipal;
import java.awt.Font;
import java.util.List;
import javax.swing.UIManager;
import pojos.Cliente;
import pojos.Facprod;
import pojos.Factura;
import pojos.Producto;




public class Main {


    static List<Cliente> lista_clientes;
    static List<Factura> lista_facturas;
    static List<Producto> lista_productos;
    static List<Facprod> lista_fac_prods;

    public static List<Facprod> getLista_fac_prods() {
        return lista_fac_prods;
    }

    public static void setLista_fac_prods(List<Facprod> lista_fac_prods) {
        Main.lista_fac_prods = lista_fac_prods;
    }
    static String[] arguments;
    static Font fuente=new Font("TimesRoman", Font.BOLD, 15);
    static ClienteDAO cDAO;
    static FacturaDAO fDAO;
    static ProductoDAO pDAO;
    static FacProdDAO fpDAO;

    public static FacProdDAO getFpDAO() {
        return fpDAO;
    }

    public static void setFpDAO(FacProdDAO fpDAO) {
        Main.fpDAO = fpDAO;
    }
    static int c=0;
    
    public static void main(String[] args) {
        
        arguments=args;
        aplicarLookAndFeel();
       
        cDAO = new ClienteDAO();
        fDAO = new FacturaDAO();
        pDAO = new ProductoDAO();
        fpDAO = new FacProdDAO();
        
        lista_clientes=cDAO.obtenListaPersonas();
        lista_facturas=fDAO.obtenListaFactura();
        lista_productos=pDAO.obtenListaProductos();
        lista_fac_prods=fpDAO.obtenFacProds();
        

        
        new VentanaPrincipal().setVisible(true);
        
    }

    public static ProductoDAO getpDAO() {
        return pDAO;
    }

    public static void setpDAO(ProductoDAO pDAO) {
        Main.pDAO = pDAO;
    }

    public static ClienteDAO getcDAO() {
        return cDAO;
    }

    public static void setcDAO(ClienteDAO cDAO) {
        Main.cDAO = cDAO;
    }

    public static FacturaDAO getfDAO() {
        return fDAO;
    }

    public static void setfDAO(FacturaDAO fDAO) {
        Main.fDAO = fDAO;
    }

    
    public static String[] getArguments() {
        return arguments;
    }

    public static Font getFuente() {
        return fuente;
    }
    
    
    private static void aplicarLookAndFeel() {
         try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    public static List<Cliente> getLista_clientes() {
        c++;
        lista_clientes=cDAO.obtenListaPersonas();
        if(c==2)
        {
            c=c;
        }
        return lista_clientes;
    }

    public static void setLista_clientes(List<Cliente> lista_clientes) {
        Main.lista_clientes = lista_clientes;
    }

    public static List<Factura> getLista_facturas() {
        lista_facturas=fDAO.obtenListaFactura();
        return lista_facturas;
    }

    public static void setLista_facturas(List<Factura> lista_facturas) {
        
        Main.lista_facturas = lista_facturas;
    }

    public static List<Producto> getLista_productos() {
        lista_productos=pDAO.obtenListaProductos();
        return lista_productos;
    }

    public static void setLista_productos(List<Producto> lista_productos) {
      
        Main.lista_productos = lista_productos;
    }
    
    
    
}
