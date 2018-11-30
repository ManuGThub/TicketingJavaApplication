package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
          
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        
        return sessionFactory;
    }
    
    public static List executeQuery(String query)
    {
        List lista = new LinkedList();
        Session sesion=null;
      
        try
        {
            SessionFactory sf=HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            Transaction tx = sesion.beginTransaction();
            Query q = sesion.createQuery(query);
            lista = q.list();
        } catch (HibernateException he) {
          
        throw he;
        } finally {
            sesion.close();
        }
        return lista;
    }
}
