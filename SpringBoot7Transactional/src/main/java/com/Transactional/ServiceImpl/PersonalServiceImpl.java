package com.Transactional.ServiceImpl;

import com.Transactional.Entity.Personal;
import com.Transactional.Repository.PersonRepository;
import com.Transactional.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 16:49
 * @Package: com.Transactional.ServiceImpl
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Service
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    PersonRepository personRepository;
    @Transactional(rollbackOn = {IllegalArgumentException.class})
    @Override
    public Personal savePersonWithRollBack(Personal person) {
        Personal p = personRepository.save(person);
        if (person.getName().equals("程序职场")) {
            throw new IllegalArgumentException("程序职场 已存在，数据将回滚");
        }
        return p;
    }
    @Transactional(dontRollbackOn= {IllegalArgumentException.class})
    @Override
    public Personal savePersonWithoutRollBack(Personal person) {
        Personal p = personRepository.save(person);
        if (person.getName().equals("程序职场")) {
            throw new IllegalArgumentException("程序职场 已存在，但数据不会回滚");
        }
        return p;
    }

}
