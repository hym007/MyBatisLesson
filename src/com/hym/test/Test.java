package com.hym.test;

import com.hym.mapper.CustomerMapper;
import com.hym.po.Customer;
import com.hym.util.MybatisUtill;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtill.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        List<Customer> customer = customerMapper.findAll();
        for (Customer customer1: customer) {
            System.out.println(customer1);
        }
    }

}
