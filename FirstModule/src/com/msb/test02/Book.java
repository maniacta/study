package com.msb.test02;

// 书籍
public class Book {
    //属性:
    //书籍编号:
    private String bNo;
    //书籍名称:
    private String bName;
    //书籍作者:
    private String bAuthor;

    public Book() {
    }

    public Book(String bNo, String bName, String bAuthor) {
        this.bNo = bNo;
        this.bName = bName;
        this.bAuthor = bAuthor;
    }

    public void setbNo(String bNo) {
        this.bNo = bNo;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getBno() {
        return bNo;
    }

    public String getbName() {
        return bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }
}
