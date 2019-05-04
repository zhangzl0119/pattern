package com.zzl.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> excuteQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = this.createPrepareStatement(connection, sql);
            ResultSet rs = this.excuteQuery(preparedStatement, values);

            List<?> result = this.parseResultSet(rs, rowMapper);

            this.closeResultSet(rs);

            this.closeStatement(preparedStatement);

            this.closeConnection(connection);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private void closeStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }


    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    private ResultSet excuteQuery(PreparedStatement preparedStatement, Object[] values) throws SQLException {
        int length = values.length;
        for (int i = 0; i < length; i++) {
            preparedStatement.setObject(i,values[i]);
        }
        return preparedStatement.executeQuery();
    }

    private PreparedStatement createPrepareStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
