package com.msb.test03;

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//功能：读取文件内容
public class Test01 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\Code\\Java\\Test\\study\\FirstModule\\src\\com\\msb\\test03\\test1.txt");
        //输入流
        FileReader fr = new FileReader(f);
        int n = fr.read();
        while (n != -1) {
            System.out.println(n);
            n = fr.read();
        }
        //流关闭
        fr.close();
    }
}
