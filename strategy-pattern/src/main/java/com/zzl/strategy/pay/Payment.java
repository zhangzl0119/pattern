package com.zzl.strategy.pay;

public abstract class Payment {

    public abstract String getName();

    public abstract double queryBalance(String uid);

    public MsgResult pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new MsgResult(500, "支付宝", "余额不足");
        }
        return new MsgResult(200, "支付成功", "支付金额" + amount);
    }
}
