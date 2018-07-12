package br.com.rapha.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String args[]){

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");

        EntityManager em = entityManagerFactory.createEntityManager();

        Lembrete lembrete = null;

        try {
            lembrete = em.find(Lembrete.class, 2L);
                } finally {
                   em.close();
                 }

            System.out.println(lembrete);
          }




}
