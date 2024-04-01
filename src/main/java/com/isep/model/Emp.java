package com.isep.model;

/**
 * @program: TP3_testjpa
 * @description:
 * @author: Jintao
 * @create: 2024-03-31 22:48
 **/

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Emp {
    @Id
    @GeneratedValue
    private Long empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "efirst")
    private String efirst;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private Long mgr;
    @Column(name = "sal")
    private Long sal;
    public Long getEmpno() {
        return empno;
    }
    public void setEmpno(Long empno) {
        this.empno = empno;
    }
}

