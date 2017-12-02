package lanou.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dllo on 17/11/13.
 */
public class GetNum extends Thread{
    String net="https://www.baidu.com";
    @Override
    public void run() {
        super.run();
        try {
            URL url=new URL(net);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            int code =connection.getResponseCode();
            InputStream is =connection.getInputStream();
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            System.out.println(code);
            String file="/Users/dllo/Desktop/baidu.html";
            File f =new File(file);
            FileWriter fw =new FileWriter(f);
            fw.write(code);
            fw.flush();
            is.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
