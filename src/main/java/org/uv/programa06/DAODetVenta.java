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
public class DAODetVenta implements IDAOGeneral<DetVenta, Long>{
    @Override
    public DetVenta create(DetVenta p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        session.save(p);
        Logger.getLogger(DAODetVenta.class.getName()).log(Level.INFO, "Se guardo ...");
        
        t.commit(); //hacer persistente la conexion a la BD
        session.close();
       
        return p;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean res = false;
        
        DetVenta detalleVenta = findById(id);
        if(detalleVenta == null)
            res = false;
        else {
            session.delete(detalleVenta);
            Logger.getLogger(DAODetVenta.class.getName()).log(Level.INFO, "Se elimino ...");
            res = true;
        }
        
        t.commit();
        session.close();
        return res;
    }

    @Override
    public DetVenta update(DetVenta p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        DetVenta detalleVenta = findById(id);
        if(detalleVenta == null)
            session.update(detalleVenta);
        Logger.getLogger(DAODetVenta.class.getName()).log(Level.INFO, "Empleado actualizado ...");
        
        t.commit();
        session.close();
        return detalleVenta;
    }

    @Override
    public List<DetVenta> findAll() {
        List<DetVenta> lstRes = null;
        
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        lstRes = session.createQuery("from DetVenta").list();
        
        t.commit();
        session.close();
        return lstRes;
    }

    @Override
    public DetVenta findById(Long id) {
        DetVenta detalleVenta = null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        detalleVenta = session.get(DetVenta.class, id);
        
        t.commit();
        session.close();
        return detalleVenta;
    }
}
