package com.fdc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
    private String passWord;
    private String birth;
    private String money;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
