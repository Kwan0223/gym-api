package com.best.kwan.service;

import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.eums.ErrorCode;
import com.best.kwan.exception.CustomException;
import com.best.kwan.vo.UserPageVO;
import com.best.kwan.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// controller -> service - repository -> DB

@Service
@RequiredArgsConstructor
// private final 같이 쓰기
public class UserService {

    private final UserRepository userRepository;


    public void createUser(UserVO userVO) {

        UserEntity userEntity = new UserEntity(userVO);
        System.out.println("USER DATA Check : " + userVO.getAddress());

        userRepository.save(userEntity);
    }

    public UserPageVO getUsers(Pageable pageable) {
//    public Page<User> getUsers(Pageable pageable) {

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

    public void updateUser(UserVO userVo, Long id) {

        UserEntity userEntity = new UserEntity(userVo);
        userEntity.setId(id);

        userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public UserVO login(UserVO userVO, HttpSession session) {

        try {
            Optional<UserEntity> byUserEmail = userRepository.findByEmail(userVO.getEmail());
            System.out.println("TEST byUSerEail : " + byUserEmail);
            if (byUserEmail.isPresent()) {
                //조회결과가 있다 ( 해당 이메일을 가진 정보가 있다.)
                UserEntity userEntity = byUserEmail.get();

                if (userEntity.getPwd().equals(userVO.getPwd())) {
                    // 비밀번호가 일치
                    //Entity -> VO 변경
                    UserVO vo = UserVO.toUserVO(userEntity);
                    session.setAttribute("loginEmail", vo.getEmail());
                    return vo;
                } else {
                    // 비밀번호 불일치 -> 로그인실패
                    return null;
                }

            } else {
                //조회결과 X
                return null;
            }
            // ...
        } catch (Exception e) {
            System.out.println("Exception occurred during login:");
            e.printStackTrace();
            return null;
        }


    }
}