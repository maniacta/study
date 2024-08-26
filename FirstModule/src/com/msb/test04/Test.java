package com.msb.test04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true) {
            // print menu
            System.out.println("------ 欢迎来到【老马书城】-------");
            System.out.println("1.展示书籍");
            System.out.println("2.上架书籍");
            System.out.println("3.下架书籍");
            System.out.println("4.退出系统");

            Scanner sc = new Scanner(System.in);

            System.out.println("输入功能编号：");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("【老马书城】>>>>>>>1.展示书籍");
                //从文件中读取list
                File f = new File("D:\\Code\\Java\\Test\\study\\FirstModule\\src\\com\\msb\\test04\\demo.txt");

                if (f.exists()) {
                    //流
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    //读取集合
                    List<Book> list = (ArrayList) (ois.readObject());
                    for (Book b : list) {
                        System.out.println(b.getBno() + "---" + b.getbName() + "---" + b.getbAuthor());
                    }
                } else {
                    System.out.println("当前没有书籍,需要先上架书籍");
                }
            }
            if (choice == 2) {
                System.out.println("【老马书城】>>>>>>>2.上架书籍");

                System.out.println("请录入书籍编号：");
                String bNo = sc.next();
                System.out.println("请录入书籍名称：");
                String bName = sc.next();
                System.out.println("请录入书籍作者：");
                String bAuthor = sc.next();
                Book b = new Book();

                b.setbNo(bNo);
                b.setbName(bName);
                b.setbAuthor(bAuthor);

                //从文件中读取list
                File f = new File("D:\\Code\\Java\\Test\\study\\FirstModule\\src\\com\\msb\\test04\\demo.txt");

                if (f.exists()) {
                    //流
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    //读取集合
                    List<Book> list = (ArrayList) (ois.readObject());
                    list.add(b);
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    //将list写出
                    oos.writeObject(list);

                    //关闭流
                    oos.close();
                    fos.close();
                } else {
                    //集合存数据
                    List<Book> list = new ArrayList<>();
                    list.add(b);

                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    //将list写出
                    oos.writeObject(list);

                    //关闭流
                    oos.close();
                    fos.close();
                }

            }
            if (choice == 3) {
                System.out.println("【老马书城】>>>>>>>3.下架书籍");
                //从文件中读取list
                File f = new File("D:\\Code\\Java\\Test\\study\\FirstModule\\src\\com\\msb\\test04\\demo.txt");

                if (f.exists()) {
                    //流
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    //读取集合
                    List<Book> list = (ArrayList) (ois.readObject());
                    System.out.println("请输入要下架的书籍编号:");
                    String delNo = sc.next();
                    for (Book b : list) {
                        if (delNo.equals(b.getBno())) {
                            list.remove(b);
                            System.out.println("书籍下架成功");
                            FileOutputStream fos = new FileOutputStream(f);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);

                            //将list写出
                            oos.writeObject(list);

                            //关闭流
                            oos.close();
                            fos.close();
                            break;
                        }
                    }
                } else {
                    System.out.println("当前没有书籍可下架,需要先上架书籍");
                }

            }
            if (choice == 4) {
                System.out.println("【老马书城】>>>>>>>4.退出系统");
                break;
            }

        }
    }
}
