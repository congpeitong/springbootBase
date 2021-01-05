package com.JPA.Interface;

import com.JPA.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 16:04
 * @Package: com.JPA.Interface
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAddress(String name);
    Person findByNameAndAddress(String name, String address);
    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
    Person withNameAndAddressNamedQuery(String name, String address);
}