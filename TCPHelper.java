package com.lanou.one;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by wubihang on 17/11/13.
 */
public final class TCPHelper {


    // 此类特点：1 不想让别人继承
    //         2 方法的使用全为静态，不想对外界提供对象
    //           私有构造器
    private TCPHelper(){}


    // 现在关于端口号和关流的方法
    // 多个地方需要多次使用
    // 并且在使用过程中，不需要进行任何修改
    // 因此为了方便，定义成静态方法/常量
    // 为了代码的结构更完整
    // 抽象一个工具类：可以将TCPHelper


    // 不需要创建对象就可以使用并且不能被修改的变量 - 常量
    // 常量命名规范1：全大写
    // 常量命名规范2：多个单词使用下划线区分

    // 端口号
    public static final int PORT = 8888;
    // ip地址
    public static final String IP = "172.16.17.37";

    // 关流的方法
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 重载关流方法：关多个流
    public static void close(Closeable... closeables) {
        for (Closeable c : closeables) {
            if (c != null){
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
