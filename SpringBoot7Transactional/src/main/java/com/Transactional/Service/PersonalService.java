package com.Transactional.Service;

import com.Transactional.Entity.Personal;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 16:48
 * @Package: com.Transactional.Service
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
public interface PersonalService {
    public Personal savePersonWithRollBack(Personal person);

    public Personal savePersonWithoutRollBack(Personal person);
}
