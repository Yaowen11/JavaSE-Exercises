package network.echo;

import java.io.*;
import java.net.Socket;

/**
 * @author zyw
 * @date 2020/7/7 21:29
 */
public class EchoClient {
    private String host = "localhost";
    private int port = 8000;
    private Socket socket;

    public EchoClient() throws IOException {
        socket = new Socket(host, port);
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }

    private PrintWriter getWrite(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    public void talk() throws IOException {
        try {
            BufferedReader bufferedReader = getReader(socket);
            PrintWriter printWriter = getWrite(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {
                printWriter.println(msg);
                System.out.println(bufferedReader.readLine());
                if (msg.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
