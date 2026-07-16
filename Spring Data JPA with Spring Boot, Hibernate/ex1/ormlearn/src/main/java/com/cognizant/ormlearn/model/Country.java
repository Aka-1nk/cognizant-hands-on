package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;     // ← Changed from javax to jakarta
import jakarta.persistence.Entity;     // ← Changed from javax to jakarta
import jakarta.persistence.Id;         // ← Changed from javax to jakarta
import jakarta.persistence.Table;      // ← Changed from javax to jakarta

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}