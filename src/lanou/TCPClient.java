package lanou;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dllo on 17/11/13.
 */
public class TCPClient extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Socket socket=new Socket("172.16.16.204",8080);
            OutputStream os=socket.getOutputStream();
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入内容");
            String str=scanner.nextLine();
            byte[] bytes=str.getBytes();
            os.write(bytes);
            os.close();
            socket.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
