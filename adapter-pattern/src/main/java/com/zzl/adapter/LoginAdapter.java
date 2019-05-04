package com.zzl.adapter;

public interface LoginAdapter {
    boolean support(Object adapter);

    MsgResult login(String key, Object adapter);

}
