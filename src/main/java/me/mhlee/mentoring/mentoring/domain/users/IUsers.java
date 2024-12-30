package me.mhlee.mentoring.mentoring.domain.users;

import java.util.Optional;

public interface IUsers {
    // 유저 생성
    Users.Vo create(String loginId, String encodedPassword, String name, int age);

    // id로 유저 찾기
    Optional<Users.Vo> findById(long id);
    Users.Vo getById(long id);

    // loginId로 유저 찾기
    Optional<Users.Vo> findByLoginId(long id);
    Users.Vo getByLoginId(long id);
}
