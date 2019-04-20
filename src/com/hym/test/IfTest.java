package com.hym.test;

import com.hym.mapper.CustomerMapper;
import com.hym.po.Customer;
import com.hym.util.MybatisUtill;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IfTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtill.getSqlSession(false);
        CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);

        String keyword="曹";
        String jobs="程序猿";
        int id =10;
        List<Customer> byLikeName = customerMapper.findAllByLikeName2(keyword,jobs,id);

        for (Customer customer:byLikeName) {
            System.out.println(customer);
        }

        MybatisUtill.closeSqlSession(sqlSession);
    }

    /**
     * 批量查
     */
    @Test
    public void findCustomerByIds(){
        SqlSession sqlSession = MybatisUtill.getSqlSession(false);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<Customer> customers = sqlSession.selectList("findCustomerByIds",ids);
        for (Customer customer:customers) {
            System.out.println(customer);
        }
        MybatisUtill.closeSqlSession(sqlSession);
    }
}
