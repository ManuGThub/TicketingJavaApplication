/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOs;


import data.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Cliente;



public class ClienteDAO {
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
    public void guardaCliente(Cliente c) throws HibernateException
    {
        int id;
        try
        {
           
            iniciaOperacion();
            sesion.save(c);     
            
            tx.commit();
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        //return id;
    }
    public boolean actualizaCliente(Cliente c,int id) throws HibernateException
    {
        boolean ver = false;
        try
        {
            iniciaOperacion();
            
            //sesion.load(Cliente.class,id);
            sesion.saveOrUpdate(c);  
            
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
    
    public void eliminaCliente(Cliente c) throws HibernateException
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
    
    public Cliente obtenPersona(int id) throws HibernateException
    {
    Cliente c = null;
    try
    {
        iniciaOperacion();
        
        c = (Cliente) sesion.get(Cliente.class, id);
    } catch (HibernateException he) {
        manejaExcepcion(he);
    throw he;
    } finally {
        sesion.close();
    }
    return c;
    }
    public List<Cliente> obtenListaPersonas() throws HibernateException
    {
        List<Cliente> listaPersonas = null;
        try
        {
            iniciaOperacion();
            Query q=sesion.createQuery("from Cliente");
            listaPersonas = q.list();

        } catch (HibernateException he) {
             manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return listaPersonas;
    }
}

