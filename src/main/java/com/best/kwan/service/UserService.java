package com.best.kwan.service;

import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.eums.ErrorCode;
import com.best.kwan.exception.CustomException;
import com.best.kwan.vo.PasswordVO;
import com.best.kwan.vo.UserPageVO;
import com.best.kwan.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
// controller -> service - repository -> DB

@Service
@RequiredArgsConstructor
// private final 같이 쓰기
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final HttpSession session;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    ObjectMapper objectMapper = new ObjectMapper();


    public void createUser(UserVO userVO) {

        UserEntity userEntity = new UserEntity(userVO);

        userEntity.setPwd(passwordEncoder.encode(userVO.getPwd()));

        userRepository.save(userEntity);
    }


    public UserPageVO getUsers(Pageable pageable) {

        Page<UserEntity> users = userRepository.findAll(pageable);

        List<UserVO> resultList = new ArrayList<>();
        for (int i = 0; i < users.getContent().size(); i++) {
            UserEntity userEntity = users.getContent().get(i);

            UserVO userVo = new UserVO(userEntity);
            resultList.add(userVo);
        }
        UserPageVO userPageVO = new UserPageVO(users.getTotalPages(), resultList);

        return userPageVO;
    }

    public UserVO getUser(Long id) {

        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        UserVO userVo = new UserVO(userEntity);

        return userVo;
    }


    public UserVO getUserEmail(String email) {

        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        UserVO userVo = new UserVO(userEntity);

        return userVo;
    }


    public void updateUser(UserVO userVo) {

        String email = (String) session.getAttribute("loginEmail");
        System.out.println("TEST UPDATE :: " + session);
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        UserEntity updateUserEntity = new UserEntity(userVo);
        updateUserEntity.setId(userEntity.getId());

        userRepository.save(updateUserEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public UserVO login(UserVO userVO, HttpSession session) {

        UserEntity user = userRepository.findByEmail(userVO.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(userVO.getPwd(), user.getPwd())) {
            throw new CustomException(ErrorCode.PASSWORD_MISMATCH);
        }

        UserVO vo = UserVO.toUserVO(user);
        // vo -> string 바꾸고
        try {
            String jsonString = objectMapper.writeValueAsString(vo);
            session.setAttribute("user", jsonString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }


        return vo;
    }

    public ResponseEntity changeUserPassword(PasswordVO passwordVO) {

        String userData = (String) session.getAttribute("user");
        UserVO userVO;

        try {
            userVO = objectMapper.readValue(userData, UserVO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error parsing session user data");
        }
        String email = userVO.getEmail();
        //세션에서 정보를 가져온다 .
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        String newPwd = passwordVO.getNewPwd();
        System.out.println("TEST newPwd : " + newPwd);

        if (passwordEncoder.matches(passwordVO.getNewPwd(), user.getPwd())) {
            throw new CustomException(ErrorCode.PASSWORD_SAME);
        }

        user.setPwd(passwordEncoder.encode(passwordVO.getNewPwd()));
        userRepository.save(user);
        return ResponseEntity.ok().body(ErrorCode.SUCCESS);
    }

    public void updateUserProfile(UserVO user) {
    }
}