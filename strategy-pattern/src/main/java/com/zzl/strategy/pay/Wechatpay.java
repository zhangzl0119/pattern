package com.zzl.strategy.pay;

public class Wechatpay extends Payment {
    @Override
    public String getName() {
        return "微信";
    }

    @Override
    public double queryBalance(String uid) {
        return 800;
    }
}
