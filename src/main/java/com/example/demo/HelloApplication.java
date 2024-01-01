package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HelloApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team team1 = new Team("Team1");
            em.persist(team1);

            Team team2 = new Team("Team2");
            em.persist(team2);

            Member member1 = new Member("member1", team1);
            em.persist(member1);

            Member member2 = new Member("member2", team2);
            em.persist(member2);

            em.flush();
            em.clear();

            //일반적인 inner join.
            List<Member> resultList = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            for (Member member : resultList) {
                System.out.println(member);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}