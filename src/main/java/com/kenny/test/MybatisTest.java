package com.kenny.test;

import com.kenny.bean.Test;
import com.kenny.dao.TestDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis/mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从SqlSessionFactory中获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            TestDao testDao = openSession.getMapper(TestDao.class);
            List<Test> tests = testDao.selectEmp();

            for (Test test : tests){
                System.out.println(test.getId()+"------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //关闭Session
            openSession.close();
        }
    }
}
