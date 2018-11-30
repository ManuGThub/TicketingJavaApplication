

package DAOs;

import data.HibernateUtil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Facprod;
import pojos.Producto;


public class FacProdDAO {
    Session sesion;
    Transaction tx;
    
    private void iniciaOperacion() throws HibernateException
    {

        SessionFactory sf=HibernateUtil.getSessionFactory();
        sesion = sf.openSession();
        tx = sesion.beginTransaction();
    }
    private void manejaExcepcion(HibernateException he) throws HibernateException
    {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }
    public void guardaFacProd(Facprod fp) throws HibernateException
    {
        int id;
        try
        {
            
            iniciaOperacion();
            sesion.saveOrUpdate(fp);
            tx.commit();
        } catch (HibernateException he) {
            System.out.println(""+he.getMessage());
            manejaExcepcion(he);
            
            throw he;
        } finally {
            sesion.close();
        }
        
    }
    public void actualizaFacprod(Facprod fp) throws HibernateException
    {
        try
        {
            iniciaOperacion();
            sesion.saveOrUpdate(fp);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    public void eliminaFacprod(Facprod fp) throws HibernateException
    {
        try
        {
            iniciaOperacion();
            sesion.delete(fp);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    public List<Facprod> obtenFacProdsFactura(int id) throws HibernateException
    {
        List<Facprod> facprod = new LinkedList();
        try
        {
            iniciaOperacion();
            Query query = sesion.createQuery("from Facprod where idFactura ="+id);
            facprod = query.list();
            
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return facprod;
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
    
    public Facprod obtenFacprod(int id) throws HibernateException
    {
        Facprod f;
        try
        {
        
            iniciaOperacion();
            f = (Facprod) sesion.get(Facprod.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return f;
    }

    public List<Facprod> obtenFacProds() {
        List<Facprod> facprod = new LinkedList();
        try
        {
            iniciaOperacion();
            Query query = sesion.createQuery("from Facprod ");
            facprod = query.list();
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return facprod;
    }

    public List<Facprod> obtenFacProdsProducto(Integer id) {
        List<Facprod> facprod = new LinkedList();
        try
        {
            iniciaOperacion();
            Query query = sesion.createQuery("from Facprod where idProducto ="+id);
            facprod = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return facprod;
    }
}
