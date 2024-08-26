package com.msb.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动:
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/mytestdb";
        String user = "root";
        String password = "15572522539";
        Connection conn = DriverManager.getConnection(url, user, password);
        //创建会话
        Statement sta = conn.createStatement();
        //发送SQL
        int i = sta.executeUpdate("insert into t_book (id,name,author,price) values (4,'c','aaa',49)");
        //处理结果
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

        //关闭资源
        sta.close();
        conn.close();
    }
}
