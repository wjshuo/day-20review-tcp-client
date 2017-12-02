package lanou;

/**
 * Created by dllo on 17/11/13.
 */
public class ClientMain {
    public static void main(String[] args) {//主函数需要在主方法里使用
        TCPClient client=new TCPClient();
        client.start();
    }


}
