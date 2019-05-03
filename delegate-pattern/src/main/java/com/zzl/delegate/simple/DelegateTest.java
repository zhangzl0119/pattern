package com.zzl.delegate.simple;

public class DelegateTest {

    public static void main(String[] args) {
//        new Boss().command("登录",new Leader());
        new Boss().command("退出",new Leader());
    }
}
