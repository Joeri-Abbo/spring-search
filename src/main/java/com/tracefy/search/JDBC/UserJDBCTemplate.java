package com.tracefy.search.JDBC;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.tracefy.search.Dao.UserDao;
import com.tracefy.search.Mapper.UserMapper;
import com.tracefy.search.Models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;

public class UserJDBCTemplate implements UserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<User> listUsers(String name, int amount) {
        String sql = "SELECT `users`.`id`,\n" +
                "       CONCAT(`users`.`first_name`,\" \" ,`users`.`last_name`) AS name,\n" +
                "       `users`.`city`,\n" +
                "       `users`.`email`,\n" +
                "       `users`.`phone`,\n" +
                "       `users`.`role_id`,\n" +
                "       `users`.`address`,\n" +
                "       `users`.`postcode`,\n" +
                "       `device_entity_user`.`imei`     AS `device_imei`,\n" +
                "       `businesses`.`id`     AS `businesses_id`,\n" +
                "       `businesses`.`name`   AS `businesses_name`,\n" +
                "       `businesses`.`address`   AS `businesses_address`,\n" +
                "       `businesses`.`postcode`   AS `businesses_postcode`,\n" +
                "       `businesses`.`city`   AS `businesses_city`,\n" +
                "       `businesses`.`email`   AS `businesses_email`,\n" +
                "       `businesses`.`phone`   AS `businesses_phone`,\n" +
                "       `business_tree`.`depth`   AS `businesses_depth`,\n" +
                "       `entities`.`id`   AS `entity_id`,\n" +
                "       `entities`.`name`   AS `entity_name`,\n" +
                "        SUM(IF(`entities`.`id` IS NULL, 0, 1))as `entity_count`,\n" +
                "        SUM(IF(`subscription_instances`.`id` IS NULL, 0, 1))as `subscriptions_count`\n" +
                "\n" +
                "FROM   `users`\n" +
                "       LEFT JOIN `businesses` ON `businesses`.`id` = `users`.`business_id`\n" +
                "       LEFT JOIN `business_tree` ON `business_tree`.`id` = `businesses`.`id`\n" +
                "       LEFT JOIN `subscription_instances` ON `subscription_instances`.`user_id` = `users`.`id`\n" +
                "       LEFT JOIN `entities` ON `entities`.`id` = `subscription_instances`.`entity_id`\n" +
                "       LEFT JOIN `device_entity_user`\n" +
                "              ON `device_entity_user`.`entity_id` =\n" +
                "                 `subscription_instances`.`entity_id`\n" +
                "                 AND `device_entity_user`.`deleted_at` IS NULL\n" +
                "-- WHERE  ( `users`.`id` LIKE '%" + name + "%'\n" +
                "--           OR `users`.`first_name` LIKE '%" + name + "%'\n" +
                "--           OR `users`.`last_name` LIKE '%" + name + "%'\n" +
                "--           OR `users`.`email` LIKE '%" + name + "%'\n" +
                "--           OR `businesses.`name` LIKE '%" + name + "%'\n" +
                "--           OR `device_entity_user`.`imei` LIKE '%" + name + "%' )\n" +
                "--         OR Concat(`users`.`first_name`, ' ', `users`.`last_name`) LIKE '%" + name + "%'\n" +
                " GROUP  BY `users`.`id`\n" +
                "LIMIT  " + amount;
        SqlQuery<User> sqlQuery = new SqlQuery<User>() {
            @Override
            protected RowMapper<User> newRowMapper(Object[] parameters, Map<?, ?> context) {
                return new UserMapper();
            }
        };
        sqlQuery.setDataSource(dataSource);
        sqlQuery.setSql(sql);
        return sqlQuery.execute();
    }
}