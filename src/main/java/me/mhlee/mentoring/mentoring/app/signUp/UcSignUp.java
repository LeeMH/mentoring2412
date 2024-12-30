package me.mhlee.mentoring.mentoring.app.signUp;

import me.mhlee.mentoring.mentoring.domain.users.Users;

public interface UcSignUp {
    Users.Vo create(String loginId, String password, String name, int age);
}
