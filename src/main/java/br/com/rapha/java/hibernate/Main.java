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


            lembrete.setDescricao("5:00h");
            lembrete.setTitulo("Estudar PHP");

            em.getTransaction().begin();
            em.merge(lembrete);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("UPDATE: " + e.getMessage());
        }
        finally {
            em.close();
        }
    }
}


