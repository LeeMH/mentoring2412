package me.mhlee.mentoring.mentoring.domain.point_history;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Table(name = "POINT")
public class PointHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Long userId;

    @Column
    @Enumerated(EnumType.STRING)
    private PointType pointType;

    @Column
    private long beforeBalance;

    @Column
    private long amount;

    @Column
    private long afterBalance;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Version
    @Column(name = "version", nullable = false)
    private long version;

    public static PointHistory of(long userId, PointType pointType, long beforeBalance, long amount, long afterBalance) {
        return PointHistory.builder()
                .userId(userId)
                .pointType(pointType)
                .beforeBalance(beforeBalance)
                .amount(amount)
                .afterBalance(afterBalance)
                .createdAt(Timestamp.from(Instant.now()))
                .build();
    }

    @Getter
    @AllArgsConstructor
    public enum PointType {
        CREATED("생성"),
        WELCOME("가입축하"),
        BONUS("보너스"),
        ;

        private String desc;
    }

    public Vo toVo() {
        return new Vo(id, userId, pointType, beforeBalance, amount, afterBalance, createdAt);
    }

    public record Vo(
        long id,
        long userId,
        PointType pointType,
        long beforeBalance,
        long amount,
        long afterBalance,
        Timestamp createdAt
    ) {}
}
