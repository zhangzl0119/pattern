package com.zzl.adapter;

public class LoginForQQ implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQ;
    }

    public MsgResult login(String key, Object adapter) {
        return null;
    }
}
