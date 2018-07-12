package br.com.rapha.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String args[]) {

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            Lembrete lembrete = em.find(Lembrete.class, 1L);

            em.getTransaction().begin();
            em.remove(lembrete);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("DELETE: " + e.getMessage());
        }
        finally {
            em.close();
        }
    }
}


