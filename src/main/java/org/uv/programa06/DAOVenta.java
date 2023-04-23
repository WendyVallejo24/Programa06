/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wbpat
 */
public class DAOVenta implements IDAOGeneral<Venta, Long>{
    @Override
    public Venta create(Venta p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        session.save(p);
        Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se guardo ...");
        
        t.commit(); //hacer persistente la conexion a la BD
        session.close();
       
        return p;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean res = false;
        
        Venta venta = findById(id);
        if(venta == null)
            res = false;
        else {
            session.delete(venta);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se elimino ...");
            res = true;
        }
        
        t.commit();
        session.close();
        return res;
    }

    @Override
    public Venta update(Venta p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Venta empleado = findById(id);
        if(empleado == null)
            session.update(empleado);
        Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Venta actualizada ...");
        
        t.commit();
        session.close();
        return empleado;
    }

    @Override
    public List<Venta> findAll() {
        List<Venta> lstRes = null;
        
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        lstRes = session.createQuery("from Venta").list();
        
        t.commit();
        session.close();
        return lstRes;
    }

    @Override
    public Venta findById(Long id) {
        Venta venta = null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        venta = session.get(Venta.class, id);
        
        t.commit();
        session.close();
        return venta;
    }
}
