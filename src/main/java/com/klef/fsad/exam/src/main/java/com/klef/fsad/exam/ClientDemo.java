package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // INSERT
        Department d = new Department();
        d.setName("CSE");
        d.setDescription("Computer Science Department");
        d.setDate(new Date());
        d.setStatus("Active");

        session.save(d);
        System.out.println("Record Inserted");

        // DELETE by ID
        Department d2 = session.get(Department.class, 1);
        if(d2 != null)
        {
            session.delete(d2);
            System.out.println("Record Deleted");
        }

        tx.commit();
        session.close();
        sf.close();
    }
}
