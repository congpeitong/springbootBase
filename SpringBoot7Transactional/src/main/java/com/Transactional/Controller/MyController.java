package com.Transactional.Controller;

import com.Transactional.Entity.Personal;
import com.Transactional.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 17:05
 * @Package: com.Transactional.Controller
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@RestController
public class MyController {
    @Autowired
    private PersonalService personalService;

    @RequestMapping("/norollback")
    public Personal noRollback(Personal person) {
        return personalService.savePersonWithoutRollBack(person);
    }

    @RequestMapping("/rollback")
    public Personal rollback(Personal person) {
        return personalService.savePersonWithRollBack(person);
    }
}