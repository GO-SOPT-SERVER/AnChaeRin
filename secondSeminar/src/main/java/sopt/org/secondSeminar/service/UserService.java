package sopt.org.secondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.secondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.secondSeminar.domain.User;

import static sopt.org.secondSeminar.SecondSeminarApplication.userList;

@Service
public class UserService {
    public Long register(RegisterRequestDto request) {
        User newUser = new User(
                request.getGender(),
                request.getName(),
                request.getContact(),
                request.getAge()
        );

        userList.add(newUser);
        newUser.setId((long) userList.size());

        // 저장한 유저 아이디 값 반환
        return newUser.getId();
    }
}
