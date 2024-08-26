package com.msb.test06;

import java.io.*;
import java.net.Socket;

public class TestClient {//客户端
    public static void main(String[] args) throws IOException {
        System.out.println("启动客户端");
        //套接字
        Socket s = new Socket("192.168.110.43",8888);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("你好，我是客户端");

        //接受服务器端数据
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println("服务器说：" + str);

        //释放资源
        dos.close();
        os.close();
        s.close();
        dis.close();
        is.close();
    }
}
