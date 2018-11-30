
package DAOs;

import data.HibernateUtil;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Facprod;
import pojos.Producto;

public class ProductoDAO {
    
     SessionFactory sf;
    Session sesion;
    Transaction tx;
    
    private void iniciaOperacion() throws HibernateException
    {

        sf=HibernateUtil.getSessionFactory();
        sesion = sf.openSession();
        tx = sesion.beginTransaction();
    }
    private void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        JOptionPane.showMessageDialog(null,"ERROR: "+he.getMessage());
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }
    public int guardaProducto(Producto c) throws HibernateException
    {
        int id;
        try
        {
            
            iniciaOperacion();
            id = (int) sesion.save(c);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }
    public boolean actualizaProducto(Producto c) throws HibernateException
    {
        boolean ver = false;
        try
        {
            iniciaOperacion();
            sesion.update(c);  
            
            tx.commit();
            ver=true;
        } catch (HibernateException he) {
            ver=false;
            manejaExcepcion(he);
            
            throw he;
            
        } finally {
            sesion.close();
            return ver;
        }
    }
    
    public void eliminaProducto(Producto c) throws HibernateException
    {
        try
        {
            iniciaOperacion();
            sesion.delete(c);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    public List<Producto> obtenProductosFactura(int id) throws HibernateException
    {
        List<Facprod> facprod = new LinkedList();
        List<Producto> productos = new LinkedList();
        try
        {
            iniciaOperacion();
            Query query = sesion.createQuery("from Facprod where idFactura ="+id);
            facprod = query.list();
            for (Facprod fp : facprod) {
                productos.add(((Producto)sesion.get(Producto.class,fp.getProducto().getIdProducto())));
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return productos;
    }
    
    public Producto obtenProducto(int id) throws HibernateException
    {
    Producto c = null;
    try
    {
        iniciaOperacion();
        c = (Producto) sesion.get(Producto.class, id);
    } catch (HibernateException he) {
        manejaExcepcion(he);
    throw he;
    } finally {
        sesion.close();
    }
    return c;
    }
    public List<Producto> obtenListaProductos() throws HibernateException
    {
        List<Producto> lista = null;
        try
        {
            iniciaOperacion();
            lista = sesion.createQuery("from Producto").list();
        } catch (HibernateException he) {
             manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return lista;
    }
}
