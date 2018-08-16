package ru.lanit.servlets;

import ru.lanit.palindrome.Palindrome;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//import javax.servlet.annotation.WebServlet;


public class MainServlet extends HttpServlet {
    private String message = "Insert your text here to check it on palindromes";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //super.doGet(req, resp);
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("message", message); // This will be available as ${message}
        request.getRequestDispatcher("/WEB-INF/serverPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String yourText = request.getParameter("text");
        Palindrome palindrome = new Palindrome(yourText);
        palindrome.checkPalindrome();

        //super.doPost(request, response);

        List<String> wordsMassive = palindrome.wordPalindrome();
        List<String> sentencesMassive = palindrome.sentencePalindrome();

        //String words = palindrome.parseForHTML(wordsMassive);
        //String sentences = palindrome.parseForHTML(sentencesMassive);

        request.setAttribute("message", message); // This will be available as ${message}
        request.setAttribute("yourText",yourText);
        request.setAttribute("words", wordsMassive);
        request.setAttribute("sentences", sentencesMassive);
        request.getRequestDispatcher("/WEB-INF/serverPage.jsp").forward(request, response);
    }
}