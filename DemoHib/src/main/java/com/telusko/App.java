package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {



        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        con.addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
                                .buildServiceRegistry();

        SessionFactory sf =con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        Alien a1 = (Alien) session.get(Alien.class,1);

        System.out.println(a1);

        tx.commit();
    }
}
