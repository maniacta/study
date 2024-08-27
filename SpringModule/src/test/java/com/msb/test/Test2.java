package com.msb.test;

import com.msb.pojo.Boy;
import com.msb.pojo.Girl;

public class Test2 {
    public static void main(String[] args) {
        //boy
        Boy b = new Boy();
        b.setAge(17);
        b.setName("小刚");
        //girl
        Girl g = new Girl();
        g.setAge(18);
        g.setName("莉莉");
        g.setBoyfriend(b);

        System.out.println("girl:"+g.getName()+" LOVE boy:"+g.getBoyfriend().getName());
    }
}
