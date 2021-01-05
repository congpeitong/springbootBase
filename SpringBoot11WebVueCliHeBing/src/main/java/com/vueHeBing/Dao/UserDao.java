package com.vueHeBing.Dao;

import com.vueHeBing.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/28 18:06
 * @Package: com.vue.Dao
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
public interface UserDao extends JpaRepository<User, Integer> {
  User findByUsername(String username);
  User getByUsernameAndPassword(String username, String password);
}
