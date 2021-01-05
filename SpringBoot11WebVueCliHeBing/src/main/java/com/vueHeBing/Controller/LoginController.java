package com.vueHeBing.Controller;
import com.vueHeBing.Entity.User;
import com.vueHeBing.Response.Result;
import com.vueHeBing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/28 20:42
 * @Package: com.vue.Controller
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Controller
// @RequestMapping("/req")
public class LoginController {
  @Autowired
  UserService userService;
  @CrossOrigin
  @PostMapping("/login")
  @ResponseBody
  public Result login(@RequestBody User requestUser, HttpSession session){
    String username = requestUser.getUsername();
    //HtmlUtils.htmlEscape将html编码进行转译，不解释html编码
    username = HtmlUtils.htmlEscape(username);
    User user = userService.get(username, requestUser.getPassword());
    if(user == null){
      return new Result(400);
    } else {
      session.setAttribute("userinfo",user);
      return new Result(200);
    }
  }
}
