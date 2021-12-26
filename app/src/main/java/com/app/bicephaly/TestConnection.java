package com.app.bicephaly;

import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class TestConnection extends Thread {
    private static final Logger logger = Logger.getLogger(TestConnection.class.getName());

    private final String ipAddress;
    private final int port;

    public TestConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void run() {
        try (Socket clientSocket = new Socket(ipAddress, port);
//             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             InputStreamReader inputStreamReader =
                     new InputStreamReader(clientSocket.getInputStream());
             BufferedReader br = new BufferedReader(inputStreamReader)) {
//            writer.println("Test");
//            writer.flush();
//            writer.close();
//            logger.info("============> written message");
//            logger.info("============> created input stream");
//
//            logger.info("============> created buffered reader");
            String message = br.readLine();
            logger.info("============>"+message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
