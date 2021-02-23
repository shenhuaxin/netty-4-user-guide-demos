package com.particle.java.demo.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shenhuaxin
 * @date 2021/2/23
 */
public class Server {


    public static void main(String[] args) throws IOException {
        int port = 10080;

        ServerSocket socket = new ServerSocket(port);
        Socket client = socket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        String msg;
        while ((msg = reader.readLine()) != null) {
            writer.println("接收到发送的消息为： " + msg);
        }
        client.shutdownInput();
        client.shutdownOutput();
        client.close();
    }
}
