package com.ebay.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerSocketTest {

	public static void main(String[] args) throws Exception {
		ServerSocketChannel channel = ServerSocketChannel.open();
		
		channel.socket().bind(new InetSocketAddress("127.0.0.1", 9080));
		
		for(;;) {
			SocketChannel socketChannel = channel.accept();
			if(null != socketChannel) {
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
				
				while(0 != socketChannel.read(byteBuffer)) {
					System.out.print(new String(byteBuffer.array(), Charset.forName ("UTF-8")));
					byteBuffer.clear();
				}
				socketChannel.close();
			} else {
				// System.out.println("waiting for connection...");
			}
		}
	}
}
