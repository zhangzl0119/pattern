package com.zzl.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class OrderDao extends JdbcTemplate {
    public OrderDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> excuteAll() {
        String sql = "select * from t_order";
        return super.excuteQuery(sql, new RowMapper<Order>() {

            public Order mapRow(ResultSet rs, int rowNum) throws Exception {
                Order order = new Order();
                order.setOrderNo(rs.getString("order_no"));

                return order;
            }
        }, null);
    }
}
