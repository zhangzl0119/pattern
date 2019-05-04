package com.zzl.template.jdbc;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        OrderDao dao = new OrderDao(null);
        dao.excuteAll();
    }
}
