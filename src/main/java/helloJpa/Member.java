package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
// @Table(name = "Members") // Members라는 테이블에 셀행하라
public class Member {
    @Id
    private Long id;

    // @Column(name = "userName") // userName이라는 컬럼에 매핑하라
    @Column(name = "name", nullable = false, length = 10)
    private String username;

    private Integer age;

    // enum 타입이 없기 때문에 enum 타입 명시 시에는 @Enumerated 사용
    // EnumType.ORDINARY 숫자
    // EnumType.STRING 문자
    // 필수로 STRING!
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;

    @Lob
    private String description;

    // 특정 필드를 DB 말고 메모리에서만 사용하고 싶을 경우
    @Transient
    private int temp;

    public Member() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
