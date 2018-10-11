package frode.jinx.service.impl;

import frode.jinx.dao.UserRepository;
import frode.jinx.domain.User;
import frode.jinx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: frode
 * @Date: 2018/9/29 15:47
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public String validateLogin(String name, String password) {
        User user = userRepository.findUserByName(name);//账号密码不能为空在前台判断
        if (password.equals(user.getPassword())){
            return "true";
        }else {
            return "false";
        }
    }
}
