package me.mhlee.mentoring.mentoring.domain.point;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import me.mhlee.mentoring.mentoring.domain.point_history.PointHistory;
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
@Table(name = "POINT")
public class Point {
    @Id @Column
    private Long userId;

    @Column
    private long balance;

    @Column
    private long beforeBalance;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Version
    @Column(name = "version", nullable = false)
    private long version;

    public static Point of(long userId) {
        return Point.builder()
                .userId(userId)
                .balance(0)
                .beforeBalance(0)
                .updatedAt(Timestamp.from(Instant.now()))
                .build();
    }

    public Vo toVo() {
        return new Vo(userId, beforeBalance, balance, updatedAt);
    }

    public record Vo(
            long userId,
            long beforeBalance,
            long balance,
            Timestamp updatedAt
    ) {}
}
