package io;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangyaowen
 */

public class DemoServer extends Thread {
    private ServerSocket serverSocket;
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public int getPort() {
        return  5800;
    }
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(getPort());
            while (true) {
//                Socket socket = serverSocket.accept();
//                RequestHandler requestHandler = new RequestHandler(socket);
//                requestHandler.start();
                executorService.execute(new RequestHandler(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        DemoServer server = new DemoServer();
        server.start();
        int port = server.getPort();
        System.out.println("port: " + port);
        for (int i = 0; i < 12000; i++) {
            try (Socket client = new Socket(InetAddress.getLocalHost(), port)) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                bufferedReader.lines().forEach(System.out::println);
            }
        }
    }
}
// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;
    RequestHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
