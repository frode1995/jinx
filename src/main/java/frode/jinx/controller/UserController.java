package frode.jinx.controller;

import frode.jinx.dao.UserRepository;
import frode.jinx.domain.User;
import frode.jinx.service.UserService;
import frode.jinx.utils.DataMap;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: frode
 * @Date: 2018/9/15 10:02
 * @Description:
 */

//@RequestMapping("")
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
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
    @ResponseBody
    public User getUserById(Long id){//http://localhost:8080/query?id=2可以用这种方式进入
        User user = userRepository.findOne(id);
        System.out.println("userRepository:"+userRepository);
        System.out.println("id:"+ id);
        return user;
    }
    @RequestMapping("/query2")//测试controller
    @ResponseBody
    public User getUserByName(String name){//http://localhost:8080/query?id=2可以用这种方式进入
        User user = userRepository.findUserByName(name);
        System.out.println("userRepository:"+userRepository);
        System.out.println("name:"+ name);
        return user;
    }

    //@RequestMapping(value = "/validateLogin",method = {RequestMethod.POST,RequestMethod.GET})
    @RequestMapping(value = "/validateLogin",method = RequestMethod.POST)
    @ResponseBody
    public DataMap ajaxLogin(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getServletMapping());
        System.out.println(request.getContextPath());

        String name = request.getParameter("name");
        User user = userRepository.findUserByName(name);
        String password = user.getPassword();
        //记住用户名、密码功能(注意：cookie存放密码会存在安全隐患)
        String remFlag = request.getParameter("remFlag");
        DataMap map = new DataMap();
        map.put("user",user);
        if("on".equalsIgnoreCase(remFlag)) { //"1"表示用户勾选记住密码

//            String loginInfo = name + "," + password;
//            Cookie userCookie = new Cookie("loginInfo", loginInfo);
            Cookie userCookie = new Cookie(name,password);//帐号密码存为cookie
            userCookie.setMaxAge(30 * 24 * 60 * 60);   //存活期为一个月 30*24*60*60
            userCookie.setPath("/");
            response.addCookie(userCookie);
        }

        return map;
        //传回去对象  让前端验证更好
    }

}
