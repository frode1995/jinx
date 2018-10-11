package frode.jinx.service;

/**
 * @Author: frode
 * @Date: 2018/9/29 15:45
 * @Description:
 */
public interface UserService {
    //弃用  改用得到对象的方式
    String validateLogin(String name,String password);
}
