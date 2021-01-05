package com.vue.Controller;

import com.vue.Entity.User;
import com.vue.Response.Result;
import com.vue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
/**
 * @Auther: MaleHunter
 * @Date: 2020/12/28 20:42
 * @Package: com.vue.Controller
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Controller
public class LoginController {
  @Autowired
  UserService userService;

  @RequestMapping("/test")
  public void test(){
    System.out.println("sucess");
  }

  @CrossOrigin
  @RequestMapping(value = "/login")
  @ResponseBody
  public Result login(@RequestBody User requestUser){
    String username = requestUser.getUsername();
    //HtmlUtils.htmlEscape将html编码进行转译，不解释html编码
    username = HtmlUtils.htmlEscape(username);
    User user = userService.get(username, requestUser.getPassword());
    if(user == null){
      return new Result(400);
    } else {
      return new Result(200);
    }
  }
}
