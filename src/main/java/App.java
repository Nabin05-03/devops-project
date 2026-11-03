
package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

        server.createContext("/", (HttpExchange exchange) -> {

            String html = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Hello DevOps</title>
                    <style>
                        body {
                            background: #101827;
                            color: white;
                            font-family: Arial, sans-serif;
                            text-align: center;
                            padding-top: 150px;
                        }
                        h1 {
                            color: #38bdf8;
                            font-size: 48px;
                        }
                        p {
                            font-size: 22px;
                        }
                    </style>
                </head>
                <body>
                    <h1>Hello DevOps!</h1>
                    <p>Welcome to Our First DevOps Application!</p>
                    <p>Successfully deployed using Jenkins and Docker.</p>
                </body>
                </html>
                """;

            byte[] response = html.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                "Content-Type", "text/html; charset=UTF-8"
            );

            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(response);
            }
        });

        server.start();

        System.out.println("DevOps application running on port 8080");
    }
}
