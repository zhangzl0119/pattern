package com.zzl.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String, IEmployee> target = new HashMap<String, IEmployee>();

    public Leader() {
        target.put("登录", new EmployeeA());
        target.put("退出", new EmployeeB());
    }

    public void doing(String command) {
        target.get(command).doing(command);
    }
}
