package me.mhlee.mentoring.mentoring.domain.point;

public interface IPoint {
    // 포인트 원장 생성, 계정 생성시 같이 생성된다.
    Point.Vo create(long userId);

    // 포인트 추가
    Point.Vo plus(long userId, long amount);

    // 포인트 차감
    Point.Vo minus(long userId, long amount);

    // 포인트 fetch
    Point.Vo getById(long userId);
}

