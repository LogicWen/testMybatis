package com.mybatis;


import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void test() throws IOException {

        Logger logger = Logger.getLogger(MybatisTest.class);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.mybatis.pojo.UserMapper.selectUser", 4);
        System.out.println("user:" + user.getUsername());
        logger.info(user);
    }

    @Test
    public void test1() throws IOException {

        Logger logger = Logger.getLogger(MybatisTest.class);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //User user = sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 1);
        User user = userMapper.selectByPrimaryKey(3L);//查出来的结果是一样
        logger.info("+++++++");
        logger.info(user.getUsername());
    }
}
