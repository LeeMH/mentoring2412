package me.mhlee.mentoring.mentoring.domain.point_history;

public interface IPointHistory {
    PointHistory.Vo write(long userId, PointHistory.PointType pointType, long beforeBalance, long amount, long afterBalance);
}
