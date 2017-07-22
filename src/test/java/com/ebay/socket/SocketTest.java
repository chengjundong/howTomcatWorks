package com.ebay.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 9080);
		boolean autoflush = true;
		PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// send request
		out.println("GET / HTTP/1.1");
		out.println("Host: localhost:9080");
		out.println("Connection: Close");
		out.println("Connection: Close");
		out.println();

		// read the response
		boolean loop = true;
		StringBuffer sb = new StringBuffer(8096);
		while (loop) {
			if (in.ready()) {
				int i = 0;
				while (i != -1) {
					i = in.read();
					sb.append((char) i);
				}
				loop = false;
			}
			Thread.sleep(50);
		}

		// display the response to the out console
		System.out.println(sb.toString());
		socket.close();
	}
}
