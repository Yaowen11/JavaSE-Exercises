package network.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zyw
 * @date 2020/7/7 21:22
 */
public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;
    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public String echo(String msg) {
        return "echo: " + msg;
    }

    private PrintWriter getWrite(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                BufferedReader bufferedReader = getReader(socket);
                System.out.println("New connection accepted " + socket.getInetAddress() + " : " + socket.getPort());
                PrintWriter printWriter = getWrite(socket);
                String msg = null;
                while ((msg = bufferedReader.readLine()) != null) {
                    System.out.println(msg);
                    printWriter.println(echo(msg));
                    if (msg.equals("bye")) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}
