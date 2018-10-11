package frode.jinx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: frode
 * @Date: 2018/10/9 9:23
 * @Description:
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

}


