package com.example.servelthometask_new;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * Основное задание
 * 1. Создать сервлет для вывода текущей даты и времени.
 * Дополнительное задание
 * 2. Создать сервлет для вывода дня недели по введенной дате.
 * 3. Создать сервлет для вывода номера дня в году по введенной дате.
 * */

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</br>");
        out.println("<h2>" + "текущее время: " + formatter.format(now) + "</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}