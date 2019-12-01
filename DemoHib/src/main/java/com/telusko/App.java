package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Alien alien = new Alien();
        alien.setAid(101);
        alien.setAname("maksatbek");
        alien.setColor("Black");

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);

        SessionFactory sf =con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(alien);

        tx.commit();

    }
}
