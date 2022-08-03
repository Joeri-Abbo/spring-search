package com.tracefy.search.JDBC;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.tracefy.search.Dao.BusinessDao;
import com.tracefy.search.Mapper.BusinessMapper;
import com.tracefy.search.Models.Business;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;

public class BusinessJDBCTemplate implements BusinessDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Business> listBusinesses(String name, int amount) {
        String sql = "select " +
                "`businesses`.id," +
                "`businesses`.name," +
                "`businesses`.address," +
                "`businesses`.postcode," +
                "`businesses`.city," +
                "`businesses`.email," +
                "`businesses`.phone," +
                "`business_tree`.depth " +
                "from `businesses` " +
                "left join `business_tree` on `business_tree`.`id` = `businesses`.`id` " +
                "where (`businesses`.`name` like '%" + name + "%') " +
                "limit " + amount;
        SqlQuery<Business> sqlQuery = new SqlQuery<Business>() {
            @Override
            protected RowMapper<Business> newRowMapper(Object[] parameters, Map<?, ?> context) {
                return new BusinessMapper();
            }
        };
        sqlQuery.setDataSource(dataSource);
        sqlQuery.setSql(sql);
        return sqlQuery.execute();
    }
}