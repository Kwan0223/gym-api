package com.best.kwan.controller;

import com.best.kwan.service.UserService;
import com.best.kwan.util.ValidationUtil;
import com.best.kwan.validation.Password;
import com.best.kwan.vo.PasswordVO;
import com.best.kwan.vo.PointImageVO;
import com.best.kwan.vo.UserPageVO;
import com.best.kwan.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    private final  HttpSession session;
    //서비스에서 선언 하여 사용 하기때문에 지움 input파라미터도 지워라

    @RequestMapping("/home")
    public String getHome() {

        return "Start Project";
    }

    @PostMapping("/signUp")
    public String createTest(@RequestBody UserVO userVO) {

        boolean checkPwd = ValidationUtil.checkPwd(userVO.getPwd());
        boolean checkEmail = ValidationUtil.checkEmail(userVO.getEmail());
        if (!checkPwd) {
            return "PwdCheck"; //enum 만들어서 exception으로 처리  이걸 checkPwd안에서 처리
        }
        if (!checkEmail) {
            return "EmailCheck"; // 위에 동일
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

        userService.updateUser(userVO);
        return "SUCCESS";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        //컨트롤러에는 void 사용 안됨 RessposeEntity로 변경
        userService.deleteUser(id);
    }


    @PostMapping("/login")
    public ResponseEntity<UserVO> login(@RequestBody  UserVO userVO){

        UserVO loginReulst = userService.login(userVO , session);

        return ResponseEntity.ok().body(loginReulst);
    }
    @GetMapping("/by-email/{email}")
    public UserVO getUser(@PathVariable String email) {
        System.out.println("test Email: "+ email);
        return userService.getUserEmail(email);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody @Valid PasswordVO passwordVO) {
        System.out.println("TEST START !!!!!!!!! changePwd !!");
        return userService.changeUserPassword(passwordVO);
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        System.out.println("TEST logOut : " +  request);
        HttpSession session = request.getSession(false);
        System.out.println("TEST logOut : " +  session);

        if (session != null) {
            session.invalidate();
            System.out.println("Session OUT!!!");
        }
        return "You have been logged out successfully";
    }
    @PutMapping
    public String updateUser(@RequestBody UserVO userVO) {

        System.out.println("TEST Update UserVO :: " + userVO);

        return "SUCCESS";
    }

}
