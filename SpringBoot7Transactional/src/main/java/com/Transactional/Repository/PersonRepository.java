package com.Transactional.Repository;

import com.Transactional.Entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 16:46
 * @Package: com.Transactional.Repository
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
public interface PersonRepository extends JpaRepository<Personal,Long> {
}