package com.vueHeBing.interceptor;

import com.vueHeBing.Entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/1 9:58
 * @Package: com.vueHeBing.interceptor
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    //getServletContext：获取page的上下文
    //getConextPath:获取项目的根路径，
    String contextPath = session.getServletContext().getContextPath();
    System.out.println("contextPath项目的根路径（上下文路径）为：" + contextPath);
    //需要拦截的路径
    String[] requireAuthPages = new String[]{
            "index",
    };
    //uri除去域名（ip)部分的路径
    String uri = request.getRequestURI();
    System.out.println("uri路径为" + uri);
    //remove 字符串删除指定字符串
    uri = StringUtils.remove(uri, contextPath + "/");
    String page = uri;
    System.out.println("uri路径删除了Contextpath/之后为： " + page);
    if (begingWith(page, requireAuthPages)) {

      User user = (User) session.getAttribute("userinfo");
      if (user == null) {
        response.sendRedirect("login");
        return false;
      }
    }
    return true;
  }

  private boolean begingWith(String page, String[] requiredAuthPages) {
    boolean result = false;
    for (String requiredAuthPage : requiredAuthPages) {
      //startsWith:字符串以requiredAuthPage开始
      if (StringUtils.startsWith(page, requiredAuthPage)) {
        result = true;
        break;
      }
    }
      return result;

  }
}
