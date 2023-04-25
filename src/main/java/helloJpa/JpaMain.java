package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 엔티티 매니저: 엔티티 저장 또는 조회
        EntityManager em = emf.createEntityManager();
        // 엔티티 매니저는 데이터 변경 시 트랜잭션을 시작해야 한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 엔티티 객체 생성. 아직 영속성 컨텍스트에 저장하지 않은 상태
            Member member = new Member();
            member.setRoleType(RoleType.ADMIN);
            member.setUsername("Kim");
            member.setId(100L);
            // 영속성 컨텍스트 persistence context: 엔티티를 영구 저장하는 환경
            // 엔티티 매니저는 영속성 컨텍스트에 엔티티 보관 및 관리
            // 영속성 컨텍스트에 저장된 영속 상태
            em.persist(member);
            // 여기까지는 데이터베이스에 INSERT SQL 보내지 않는다.
            // commit 하는 순간 데이터베이스에 INSERT SQL 보낸다.
            // (commit 하면 flush가 일어나서 변경 감ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ      )
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
