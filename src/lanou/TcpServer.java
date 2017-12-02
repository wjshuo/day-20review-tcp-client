package lanou;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dllo on 17/11/13.
 */
public class TcpServer extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            System.out.println("请输入连接");
            Socket socket=serverSocket.accept();
            System.out.println(serverSocket.getInetAddress()+"介入");
            InputStream is =socket.getInputStream();
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuffer buffer=new StringBuffer();
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
            

            byte[] bytes=new byte[1024];
            while(is.read(bytes)!=-1){

            }
            String str =new String(bytes,0,bytes.length);
            System.out.println(str);
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
