package me.mhlee.mentoring.mentoring.app.signUp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.mhlee.mentoring.mentoring.domain.point.IPoint;
import me.mhlee.mentoring.mentoring.domain.point_history.IPointHistory;
import me.mhlee.mentoring.mentoring.domain.point_history.PointHistory;
import me.mhlee.mentoring.mentoring.domain.users.IUsers;
import me.mhlee.mentoring.mentoring.domain.users.Users;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class SignUpApp implements UcSignUp{
    private final IUsers userService;
    private final IPoint pointService;
    private final IPointHistory pointHistoryService;

    private static long WELCOME_POINT = 10_000;

    @Override
    public Users.Vo create(String loginId, String password, String name, int age) {
        var newUser = userService.create(loginId, password, name, age);
        var point = pointService.create(newUser.id());
        pointHistoryService.write(
                newUser.id(),
                PointHistory.PointType.CREATED,
                0,
                0,
                0
        );

        // 웰컴포인트 10_000증정
        pointService.plus(newUser.id(), WELCOME_POINT);
        pointHistoryService.write(
                newUser.id(),
                PointHistory.PointType.WELCOME,
                point.balance(),
                WELCOME_POINT,
                point.balance() + WELCOME_POINT
        );

        return newUser;
    }
}
