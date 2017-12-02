package com.lanou.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wubihang on 17/11/13.
 */
public class ServerThread extends Thread {

    private BufferedReader myReader;
    private Socket mySocket;
    private ServerSocket myServerSocket;

    @Override
    public void run() {
        try {
            // 1.通过端口号获取 服务连接 对象
            myServerSocket = new ServerSocket(TCPHelper.PORT);
            // 2.服务连接 对象 接收连接 获取到 连接对象
            mySocket = myServerSocket.accept();
            // 3.读取数据：获取输入流
            myReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            // 4.读流
            String line = "";
//            StringBuffer sb = new StringBuffer();
            StringBuilder builder = new StringBuilder();
            while ((line = myReader.readLine()) != null){
                builder.append(line);
            }

            // 获取最终结果
            String resultStr = builder.toString();
            System.out.println(resultStr);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            TCPHelper.close(myReader,mySocket,myServerSocket);
        }
    }
}
