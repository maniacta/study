package com.msb.test03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) throws IOException {
        String str = "abc 你好";
        File f = new File("D:\\Code\\Java\\Test\\study\\FirstModule\\src\\com\\msb\\test03\\test2.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(str);
        fw.close();
    }
}
