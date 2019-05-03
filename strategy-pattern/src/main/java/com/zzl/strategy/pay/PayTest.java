package com.zzl.strategy.pay;

public class PayTest {
    public static void main(String[] args) {

        Order order = new Order("1", "20190503", 122);

        MsgResult pay = order.pay(PayStrategy.ALIPAY);

        System.out.println(pay);
    }
}
