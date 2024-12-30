package me.mhlee.mentoring.mentoring.domain.users;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
import java.time.Instant;

@Slf4j
@Getter
@Builder
@Accessors(chain = true)
@DynamicInsert
@DynamicUpdate
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login_id", columnDefinition = "varchar(16)", nullable = false)
    private String loginId;

    @Column(name = "password", columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(name = "name", columnDefinition = "varchar(16)", nullable = false)
    private String name;

    @Column(name = "age", columnDefinition = "tinyint", nullable = false)
    private int age;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Version
    @Column(name = "version", nullable = false)
    private long version;

    public static Users of(String loginId, String encodedPassword, String name, int age) {
        return Users.builder()
                .loginId(loginId)
                .password(encodedPassword)
                .name(name)
                .age(age)
                .createdAt(Timestamp.from(Instant.now()))
                .updatedAt(Timestamp.from(Instant.now()))
                .build();
    }

    public Vo toVo() {
        return new Vo(id, loginId, name, age, createdAt, updatedAt);
    }

    public record Vo(
            long id,
            String loginId,
            String name,
            int age,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {}
}