package com.best.kwan.service;

import com.best.kwan.Entity.User;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.vo.UserPageVO;
import com.best.kwan.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// controller -> service - repository -> DB

@Service
@RequiredArgsConstructor
// private final 같이 쓰기
public class UserService {

    private final UserRepository userRepository;


    public void createUser(UserVO userVO) {

        User user  = new User(userVO);
        System.out.println("USER DATA Check : " + userVO.getAddress());

        userRepository.save(user);
    }

    public UserPageVO getUsers(Pageable pageable) {
//    public Page<User> getUsers(Pageable pageable) {

        Page<User> users = userRepository.findAll(pageable);

        List<UserVO> resultList = new ArrayList<>();
        for(int i=0; i<users.getContent().size(); i++){
          User user = users.getContent().get(i);

          UserVO userVo = new UserVO(user);
          resultList.add(userVo);
        }
        UserPageVO userPageVO = new UserPageVO(users.getTotalPages(), resultList);

        return userPageVO;
    }

    public UserVO getUser(Long id) {

        User user= userRepository.findById(id).orElseThrow();

        UserVO userVo = new UserVO(user);

        return userVo;
    }

    public void updateUser(UserVO userVo , Long id) {

        User user = new User(userVo);
        user.setId(id);

        userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

