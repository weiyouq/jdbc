package com.kenny.test;

import java.sql.*;

public class Test {

    public static void main(String[] args) {
        Connection ct;
        PreparedStatement ps;

        try {
            //1.加载驱动(开发推荐的方式)
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.得到连接(1433表示sql server的默认端口)
            ct= DriverManager.getConnection("jdbc:mysql://192.168.8.217:3306/telecom_app","root","Start123");
            //3.创建Preparestatement,创建数据
//            ps=ct.prepareStatement("create table test(id int)");
//            ps = ct.prepareStatement("insert into test values(1)");
            ps = ct.prepareStatement("select * from text_telecom");
//			ps=ct.prepareStatement("create table xxx");//创建表
//			ps=ct.prepareStatement("backup database shen to disk='F:/123.bak'");//备份数据库

            ResultSet b = ps.executeQuery();
            if(b.next())
            {
                b.next();

                System.out.println(b.getObject("text_word"));
                System.out.println("创建成功！");
            }else {
                System.out.println("失败");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }



    }
}
