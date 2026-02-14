package com.example.webservice;

import java.io.Serializable;

public class SumaRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private int num1;
    private int num2;

    // Getters and Setters
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}