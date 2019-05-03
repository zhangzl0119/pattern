package com.zzl.strategy.pay;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {

    public final static String ALIPAY = "alipay";
    public final static String WECHAT = "wechat";

    private static Map<String, Payment> payStrategy = new HashMap<String, Payment>();

    static {
        payStrategy.put(ALIPAY, new Alipay());
        payStrategy.put(WECHAT, new Wechatpay());
    }

    public static Payment get(String payKey) {
        return payStrategy.get(payKey);
    }

}
