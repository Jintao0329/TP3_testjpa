package com.isep.repository;

/**
 * @program: TP3_testjpa
 * @description:
 * @author: Jintao
 * @create: 2024-03-31 22:50
 **/
import com.isep.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {

}

