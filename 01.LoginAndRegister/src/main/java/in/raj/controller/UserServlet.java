package in.raj.controller;

import in.raj.dao.UserDao;
import in.raj.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao = new UserDao();
        List<UserDto> users = dao.getUsers();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/viewUsers.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO -> Capturing Form Data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phono = req.getParameter("phono");

        //TODO -> Set Form data to userdto object for transfer
        UserDto dto = new UserDto();
        dto.setUserName(name);
        dto.setUserEmail(email);
        dto.setUserPhono(Integer.parseInt(phono));

        //TODO -> Call Dao method
        UserDao dao = new UserDao();
        boolean isSaved = dao.saveUser(dto);

        String msg = null;
        if (isSaved){
            msg = "User Saved";
        }else {
            msg = "User Not Saved";
        }
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
