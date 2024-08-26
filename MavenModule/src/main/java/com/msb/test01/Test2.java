package com.msb.test01;

import java.sql.*;

public class Test2 {
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
        ResultSet rs = sta.executeQuery("select * from t_book where price < 46");
        //处理结果
        while (rs.next()) {//判断是否有记录
            System.out.println(rs.getInt("id") + "---" + rs.getString("name") + "---" + rs.getString("author") + "---" + rs.getDouble("price"));
        }

        //关闭资源
        sta.close();
        conn.close();
    }
}
