package helloJpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Table(name = "Members") // Members라는 테이블에 셀행하라
public class Member {
    @Id
    private Long id;

    // @Column(name = "userName") // userName이라는 컬럼에 매핑하라
   private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
