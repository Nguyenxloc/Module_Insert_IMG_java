/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author 84374
 */
public class Account {
    private String id;
    private String name;
    private Date DOB;
    private String gender;
    private byte[] img;

    public Account() {
    }

    public Account(String id, String name, Date DOB, String gender, byte[] img) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", DOB=" + DOB + ", gender=" + gender + ", img=" + img + '}';
    }

}
