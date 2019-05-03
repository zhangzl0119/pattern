package com.zzl.strategy.pay;

public class Alipay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public double queryBalance(String uid) {
        return 900;
    }
}
