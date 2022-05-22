package com.example.servelthometask_new;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "AdditionalTask", value = "/additional-task")
public class AdditionalTask extends HttpServlet {

    /**
     * Дополнительное задание
     * 2. Создать сервлет для вывода дня недели по введенной дате.
     * 3. Создать сервлет для вывода номера дня в году по введенной дате.
     */

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String s = request.getParameter("date");
        String[] enterDate = s.split("\\.");
        int day = Integer.parseInt(enterDate[0]);
        int month = Integer.parseInt(enterDate[1]);
        int year = Integer.parseInt(enterDate[2]);

        LocalDate localDate = LocalDate.of(year,month,day);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formatDate = formatter.format(localDate);

        out.println("<html><body>");
        out.println("<h1>" + "День недели:  " + localDate.getDayOfWeek() + "  -  " + formatDate + "</h1>");
        out.println("<h1>" + "День в году: " + localDate.getDayOfYear() + " - " + formatDate + "</h1>");
        out.println("<br/>");

        out.println("</body></html>");
    }

    public void destroy() {

    }
}
