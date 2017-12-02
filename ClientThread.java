package com.lanou.one;

import java.io.*;
import java.net.Socket;

/**
 * Created by wubihang on 17/11/13.
 */
public class ClientThread extends Thread {

    private OutputStream myOutput;
    private OutputStreamWriter osw;
    private BufferedWriter myWriter;
    private Socket mySocket;

    @Override
    public void run() {
        try {
            // 局部变量 转 全局变量
            // 快捷键-  cmd+ alt +f

            // 使用帮助类提供的静态常量：端口号
            // 使用方式：类名.常量名
            mySocket = new Socket(TCPHelper.IP, TCPHelper.PORT);
            // 2.通过Socket（套接字/子）连接 获取 输出流
            myOutput = mySocket.getOutputStream();
            // 把字节输出流转为 字符输出流
            osw = new OutputStreamWriter(myOutput);
            // 最常用的是 带缓冲区的字符输出流
            myWriter = new BufferedWriter(osw);
            String str = "我是数据";

            myWriter.write(str);
            myWriter.newLine();
            myWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 使用自定义方法：关流
            TCPHelper.close(myWriter,osw,myOutput,mySocket);
        }



}
