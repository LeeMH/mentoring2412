package me.mhlee.mentoring.mentoring.domain.users.service;

import lombok.AllArgsConstructor;
import me.mhlee.mentoring.mentoring.common.BaseService;
import me.mhlee.mentoring.mentoring.common.exceptions.ApiException;
import me.mhlee.mentoring.mentoring.domain.users.IUsers;
import me.mhlee.mentoring.mentoring.domain.users.Users;
import me.mhlee.mentoring.mentoring.domain.users.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService extends BaseService implements IUsers {
    private UsersRepository repository;

    @Override
    public Users.Vo create(String loginId, String encodedPassword, String name, int age) {
        // loginId가 중복되었따면, 에러를 던진다.

        var newUser = Users.of(loginId, encodedPassword, name, age);

        return repository.save(newUser).toVo();
    }

    @Override
    public Optional<Users.Vo> findById(long id) {
        return repository.findById(id).map(Users::toVo);
    }

    @Override
    public Users.Vo getById(long id) {
        var mayBeUser = findById(id);
        if (mayBeUser.isEmpty()) {
            throw new ApiException("존재하지 않는 ID 입니다. id=" + id);
        } else {
            return mayBeUser.get();
        }
    }

    @Override
    public Optional<Users.Vo> findByLoginId(String loginId) {
        return Optional.empty();
    }

    @Override
    public Users.Vo getByLoginId(String loginId) {
        return null;
    }

    @Override
    public Users.Vo changeName(long id, String newName) {
        return null;
    }
}
