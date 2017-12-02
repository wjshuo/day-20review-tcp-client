package lanou.Practice;

import java.io.*;
import java.net.Socket;

/**
 * Created by dllo on 17/11/13.
 */
public class TCPClient extends Thread{
    private String ip="172.16.16.208";
    private int port=9999;

    @Override
    public void run() {
        super.run();
//        try {
//            //客户端发图片.
//            Socket socket=new Socket(ip,port);
//            //输出流
//            OutputStream os =socket.getOutputStream();
//            //输出图片(图片源)
//            //通过输入流把文件读成字节数组byte[]
//            File file =new File("/Users/dllo/Desktop/a.jpg");
//            InputStream is =new FileInputStream(file);
//            int length=0;
//            byte[] bytes=new byte[1024];
//            while ((length=is.read(bytes))!=-1){
//                os.write(bytes,0,length);
//            }
//            //从桌面读出图片
//            //写入Socket的输出流中
//            is.close();
//            os.close();
//            socket.close();
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //客户端发送图片
        try {
                Socket socket=new Socket("172.16.16.128",9999);
                //输出流
                OutputStream os =socket.getOutputStream();
                //输出图片 ,通过输入流把文件读成数组
                File file=new File("/Users/dllo/Desktop/a.jpg");
                InputStream is =new FileInputStream(file);
                int length=0;
                byte[]bytes=new byte[1024];
                while((length=is.read(bytes))!=-1){
                    os.write(bytes,0,length);
                }
                is.close();
                os.close();
                socket.close();




        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
