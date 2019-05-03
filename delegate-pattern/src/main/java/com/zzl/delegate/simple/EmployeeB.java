package com.zzl.delegate.simple;

public class EmployeeB implements IEmployee{

    public void doing(String command) {
        System.out.println("B 开始做事");
    }
}
