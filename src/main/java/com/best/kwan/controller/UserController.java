package com.best.kwan.controller;

import com.best.kwan.service.UserService;
import com.best.kwan.util.ValidationUtil;
import com.best.kwan.vo.UserPageVO;
import com.best.kwan.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @RequestMapping("/home")
    public String getHome() {

        return "Start Project";
    }

    @PostMapping
    public String createTest(@RequestBody UserVO userVO) {

        boolean checkPwd = ValidationUtil.checkPwd(userVO.getPwd());
        boolean checkEmail = ValidationUtil.checkEmail(userVO.getEmail());
        if (!checkPwd) {
            return "비밀번호 유효성 체크부탁드립니다.";
        }
        if (!checkEmail) {
            return "이메일 유효성 체크부탁드립니다.";
        }

        userService.createUser(userVO);
        return "Success";
    }

    @GetMapping
    public UserPageVO getUsers(@RequestParam int page, @RequestParam int size) {
        page = page - 1;
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());

        return userService.getUsers(pageable);
    }

    @GetMapping("/{id}")
    public UserVO getUser(@PathVariable Long id) {

        return userService.getUser(id);
    }

    //단건 수정 : patchMapping
    //전체 수정 : PutMapping
    // ORM 사용하는경우  Put으로 통일하는경우가 많음
    @PutMapping("/{id}")
    public String updateUser(@RequestBody UserVO userVO, @PathVariable Long id) {

        boolean checkPwd = ValidationUtil.checkPwd(userVO.getPwd());
        boolean checkEmail = ValidationUtil.checkEmail(userVO.getEmail());
        if (!checkPwd) {
            return "비밀번호 유효성 체크부탁드립니다.";
        }
        if (!checkEmail) {
            return "이메일 유효성 체크부탁드립니다.";
        }

        userService.updateUser(userVO, id);
        return "SUCCESS";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
    }


    @PostMapping("/login")
    public String login(@RequestParam UserVO userVO, HttpSession session) {

        UserVO loginReulst = userService.login(userVO , session);

        if (loginReulst != null) {
            System.out.println("TEST Sueece!!");
            return "main";
        } else {
            return "login";
        }
    }


}
