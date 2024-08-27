package com.msb.pojo;

public class Book {
    private int id;
    private String name;

    public Book() {
        System.out.println("空构造器");
    }

    public Book(int id, String name) {
        System.out.println("有参数的构造器");
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        System.out.println("set_id");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("set_name");
        this.name = name;
    }
}
