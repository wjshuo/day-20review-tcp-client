package com.lanou;

import com.lanou.one.ClientThread;
import com.lanou.one.ServerThread;
import com.lanou.one.TCPHelper;

import java.net.HttpURLConnection;

/**
 * Created by wubihang on 17/11/13.
 */
public class Main {
    /*
    一、利用TCP和Socket
        实现 客户端向服务端 文字的传输
    1.创建客户端线程和服务端线程
    2.配置客户端：
        - ip地址和端口号创建Socket连接
        - 通过Socket获取输出流
        - 把字节流转换为字符流
        - 写入数据
    3.配置服务端：
        - 通过端口号创建ServerScoket连接
        - 通过accept获取Socket连接
        - 通过Socket获取输入流，
        - 把字节流转换为字符流，读取数据
     */

    public static void main(String[] args) {
        new ServerThread().start();

        // 创建线程启动 客户端
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    new ClientThread().start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}
