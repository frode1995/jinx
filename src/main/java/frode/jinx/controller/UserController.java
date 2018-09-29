package frode.jinx.controller;

import frode.jinx.dao.UserRepository;
import frode.jinx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: frode
 * @Date: 2018/9/15 10:02
 * @Description:
 */

//@RequestMapping("")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/add")
    public String add(){
        User user = new User();
//        user.setId(Long.valueOf("1"));//自动递增
        user.setName("frode");
        user.setPassword("1234");
        user.setRemark("这是备注");
        userRepository.save(user);
        System.out.println("添加成功");
        return "添加成功";
    }

    @RequestMapping("/query")
    public User getUserById(Long id){//http://localhost:8080/query?id=2可以用这种方式进入
        User user = userRepository.findOne(id);
        System.out.println("userRepository:"+userRepository);
        System.out.println("id:"+ id);
        return user;
    }


}
