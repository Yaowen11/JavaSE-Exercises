package io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangyaowen
 * @date 2020/9/9 8:04 下午
 **/
public class NIOServer extends Thread {
    @Override
    public void run() {
        try (Selector selector = Selector.open(); ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey key = selectionKeyIterator.next();
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    selectionKeyIterator.remove();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void sayHelloWorld(ServerSocketChannel serverSocketChannel) throws IOException {
        try (SocketChannel clientChannel = serverSocketChannel.accept()) {
            clientChannel.write(Charset.defaultCharset().encode("Hello world!"));
        }
    }
}
