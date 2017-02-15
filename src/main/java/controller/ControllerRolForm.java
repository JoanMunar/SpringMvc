package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RolDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by alea on 15/02/2017.
 */

public class ControllerRolForm extends HttpServlet{

    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    RolDaoImpl rolDaoImpl = (RolDaoImpl) beans.getBean("rolDaoImp");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomRol;
        String descripcioRol;

        /*Si no existeix en cream un de nou*/
        if (req.getParameter("nomRol") != null) {

            nomRol = req.getParameter("nom");
            descripcioRol = req.getParameter("desc");

            try {
                rolDaoImpl.altaRol(nomRol, descripcioRol);
            } catch (SQLException e) {
                e.printStackTrace();
                java.io.PrintWriter out = resp.getWriter();
                out.println("<p>Aquest rol ja existeix, per favor introdueix un nou rol</p>");
            }
        }

        resp.sendRedirect("llistaRol");

    }
}

