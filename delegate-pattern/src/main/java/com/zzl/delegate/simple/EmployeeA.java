package com.zzl.delegate.simple;

public class EmployeeA implements IEmployee{

    public void doing(String command) {
        System.out.println("A 开始做事");
    }
}
