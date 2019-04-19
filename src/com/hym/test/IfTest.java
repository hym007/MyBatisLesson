package com.hym.test;

import com.hym.mapper.CustomerMapper;
import com.hym.po.Customer;
import com.hym.util.MybatisUtill;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IfTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtill.getSqlSession(false);
        CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);

        String keyword="曹";
        String jobs="程序员";
        int id =10;
        List<Customer> byLikeName = customerMapper.findAllByLikeName2(keyword,jobs,id);

        for (Customer customer:byLikeName) {
            System.out.println(customer);
        }

        MybatisUtill.closeSqlSession(sqlSession);
    }
}
