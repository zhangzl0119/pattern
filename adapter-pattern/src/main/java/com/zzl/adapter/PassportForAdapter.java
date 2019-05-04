package com.zzl.adapter;

public class PassportForAdapter extends SignService implements IPassportForThird {
    public MsgResult loginForQQ(String id) {
        return processLogin(id,LoginForQQ.class);
    }

    private MsgResult processLogin(String id, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter loginAdapter = clazz.newInstance();

            if (loginAdapter.support(loginAdapter)) {
                return loginAdapter.login(id, loginAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
