package com.best.kwan.service;

import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.eums.ErrorCode;
import com.best.kwan.exception.CustomException;
import com.best.kwan.vo.PasswordVO;
import com.best.kwan.vo.UserPageVO;
import com.best.kwan.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
// controller -> service - repository -> DB

@Service
@RequiredArgsConstructor
// private final 같이 쓰기
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void createUser(UserVO userVO) {

        UserEntity userEntity = new UserEntity(userVO);
        System.out.println("USER DATA Check : " + userVO.getAddress());
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


    public void updateUser(UserVO userVo , HttpSession session) {

        String email = (String) session.getAttribute("loginEmail");
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
        session.setAttribute("loginEmail", vo.getEmail());

        return vo;
    }

    public ResponseEntity changeUserPassword(PasswordVO passwordVO , HttpSession session) {

        String email = passwordVO.getEmail();

        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        System.out.println("TEST user Info : " + user);

        String oldPwd = passwordVO.getOldPwd();
        System.out.println("TEST oldPwd : " +  oldPwd);

        if (!passwordEncoder.matches(oldPwd, user.getPwd())) {
            throw new CustomException(ErrorCode.PASSWORD_MISMATCH);
        }

        if (passwordEncoder.matches(passwordVO.getNewPwd(), user.getPwd())) {
            throw new CustomException(ErrorCode.PASSWORD_SAME);
        }


        user.setPwd(passwordEncoder.encode(passwordVO.getNewPwd()));
        userRepository.save(user);
        return ResponseEntity.ok().body(ErrorCode.SUCCESS);
    }

}