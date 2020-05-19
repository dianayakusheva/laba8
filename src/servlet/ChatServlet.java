package servlet;

import entity.ChatMessage;
import entity.ChatUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "ChatServlet")
public class ChatServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    protected HashMap<String, ChatUser> activeUsers; // Карта текущих пользователей
    protected ArrayList<ChatMessage> messages;// Список сообщений чата

    @SuppressWarnings("unchecked")
    public void init() throws ServletException { // Вызвать унаследованную от HttpServlet версию init()

        super.init();
        activeUsers = (HashMap<String, ChatUser>)// Извлечь из контекста карту пользователей и список сообщений
                getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>)
                getServletContext().getAttribute("messages");
        if (activeUsers==null) {
            activeUsers = new HashMap<String, ChatUser>();
            getServletContext().setAttribute("activeUsers",
                    activeUsers);
        }
        if (messages==null) {
            messages = new ArrayList<ChatMessage>(100);
            getServletContext().setAttribute("messages", messages);
        }
    }
}
