package com.msb.test06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动");
        //套接字
        ServerSocket ss = new ServerSocket(8888);
        //等待客户端发送数据
        Socket s = ss.accept();
        //服务器端感受到的输入流
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        //接受客户端数据
        String str = dis.readUTF();
        System.out.println("客户端说：" + str);

        //向客户端发送数据
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("你好客户端");

        //释放资源
        dis.close();
        is.close();
        s.close();
        ss.close();
        dos.close();
        os.close();
    }
}
