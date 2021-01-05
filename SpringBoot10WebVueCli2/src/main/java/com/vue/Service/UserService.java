package com.vue.Service;

import com.vue.Dao.UserDao;
import com.vue.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/28 17:25
 * @Package: com.vue.Service
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Service
public class UserService {

  @Autowired
  UserDao userDao;

  public boolean isExist(String username) {
    User user = getByName(username);
    return null!=user;
  }

  public User getByName(String username) {

    return userDao.findByUsername(username);
  }

  public User get(String username, String password){

    return userDao.getByUsernameAndPassword(username, password);
  }

  public void add(User user) {

    userDao.save(user);
  }
}