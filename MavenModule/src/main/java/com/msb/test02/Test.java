package com.msb.test02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            // print menu
            System.out.println("------ 欢迎来到【老马书城】-------");
            System.out.println("1.根据书籍编号查询书籍信息");
            System.out.println("2.查询所有书籍信息");
            System.out.println("3.删除指定书籍编号对应的书籍");
            System.out.println("4.退出系统");

            Scanner sc = new Scanner(System.in);

            System.out.println("输入功能编号：");
            int choice = sc.nextInt();

            if (choice == 1) {
                //键盘录入书籍编号：
                System.out.println("请输入你想查看的书籍编号:");
                int bno = sc.nextInt();
                //根据编号查询书籍
                Book b = findBookByBno(bno);
                //通过b来判断是否查询成功
                if (b == null) {
                    System.out.println("您想要查询的书籍不存在!");
                } else {
                    System.out.println("当前查询到一本书：《" + b.getName() + "》");
                }
            }
            if (choice == 2) {
                List<Book> books = findBooks();
                if (books.isEmpty()) {
                    System.out.println("没有查询到书籍");
                } else {
                    for (Book book : books) {
                        System.out.println(book.getId() + "---" + book.getName() + "---" + book.getAuthor() + "---" + book.getPrice());
                    }
                }
            }
            if (choice == 3) {
                //键盘录入要删除的书籍编号：
                System.out.println("请输入你想删除的书籍编号:");
                int bno = sc.nextInt();
                //根据编号查询书籍
                int i = delBookByBno(bno);
                //通过b来判断是否查询成功
                if (i > 0) {
                    System.out.println("删除成功!");
                } else {
                    System.out.println("删除失败!");
                }
            }
            if (choice == 4) {
                System.out.println("【老马书城】>>>>>>>4.退出系统");
                break;
            }
        }
    }

    //根据编号查询书籍
    public static Book findBookByBno(int bno) throws ClassNotFoundException, SQLException {
        Book b = null;

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
        ResultSet rs = sta.executeQuery("select * from t_book where id = " + bno);
        //处理结果
        if (rs.next()) {//判断是否有记录
//            System.out.println(rs.getInt("id") + "---" + rs.getString("name") + "---" + rs.getString("author") + "---" + rs.getDouble("price"));
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            double price = rs.getDouble("price");

            //封装对象
            b = new Book();
            b.setId(id);
            b.setName(name);
            b.setAuthor(author);
            b.setPrice(price);
        }

        //关闭资源
        sta.close();
        conn.close();
        return b;
    }

    public static List<Book> findBooks() throws ClassNotFoundException, SQLException {
        //定义集合
        List<Book> list = new ArrayList<>();
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
        ResultSet rs = sta.executeQuery("select * from t_book");
        //处理结果
        while (rs.next()) {//判断是否有记录
//            System.out.println(rs.getInt("id") + "---" + rs.getString("name") + "---" + rs.getString("author") + "---" + rs.getDouble("price"));
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            double price = rs.getDouble("price");

            //封装对象
            Book b = new Book();
            b.setId(id);
            b.setName(name);
            b.setAuthor(author);
            b.setPrice(price);
            list.add(b);
        }

        //关闭资源
        sta.close();
        conn.close();
        return list;
    }

    public static int delBookByBno(int bno) throws ClassNotFoundException, SQLException {
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
        int i = sta.executeUpdate("delete from t_book where id = " + bno);

        //关闭资源
        sta.close();
        conn.close();
        return i;
    }
}
