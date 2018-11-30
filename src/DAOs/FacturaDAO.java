/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOs;

import data.HibernateUtil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Cliente;
import pojos.Factura;

/**
 *
 * @author m
 */
public class FacturaDAO {
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
    public void guardaFactura(Factura f) throws HibernateException
    {
        int id;
        try
        {
            
            iniciaOperacion();
            sesion.saveOrUpdate(f);
            tx.commit();
        } catch (HibernateException he) {
            System.out.println(""+he.getMessage());
            manejaExcepcion(he);
            
            throw he;
        } finally {
            sesion.close();
        }
        
    }
    public void actualizaFactura(Factura f) throws HibernateException
    {
        try
        {
            iniciaOperacion();
            sesion.update(f);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    public void eliminaFactura(Factura f) throws HibernateException
    {
        try
        {
            iniciaOperacion();
            sesion.delete(f);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    public Factura obtenFactura(int id) throws HibernateException
    {
    Factura f = null;
    try
    {
        iniciaOperacion();
        f = (Factura) sesion.get(Factura.class, id);
    } catch (HibernateException he) {
        manejaExcepcion(he);
    throw he;
    } finally {
        sesion.close();
    }
    return f;
    }
    
    public List<Factura> obtenFacturasCliente(Cliente cli) throws HibernateException
    {
        List<Factura> facturas = new LinkedList();
        try
        {
            iniciaOperacion();
            Query query = sesion.createQuery("from Factura where dnicliente ='"+cli.getDnicliente()+"'");
            facturas = query.list();
            for (Factura factura : facturas) {
                factura.setDniCliente(cli.getDnicliente());
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return facturas;
    }
    
    public List<Factura> obtenListaFactura() throws HibernateException
    {
        List<Factura> listaFacturas = null;
        try
        {
            iniciaOperacion();
            listaFacturas = sesion.createQuery("from Factura").list();
        } catch (HibernateException he) {
             manejaExcepcion(he);
        throw he;
        } finally {
            sesion.close();
        }
        return listaFacturas;
    }
}
