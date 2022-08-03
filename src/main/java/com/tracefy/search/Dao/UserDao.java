package com.tracefy.search.Dao;

import com.tracefy.search.Models.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDao {
    /**
     * This is the method to be used to initialize
     * database resources i.e. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to list down
     * all the records from the business table.
     */
    public List<User> listUsers(String name, int amount);
}
