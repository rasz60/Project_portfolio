package com.edt.dynamic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.go")
public class GoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		request.setCharacterEncoding("UTF-8");
		actionGo(request, response);
	}

	protected void actionGo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionGo()");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String viewPage = null;
		String uri = request.getRequestURI();
		String cntxtPath = request.getContextPath();
		String cmd = uri.substring(cntxtPath.length());
		
		if ( cmd.equals("/main.go") || cmd.equals("/") || cmd == null ) {
			viewPage = "";
		} else if ( cmd.equals("/draw.go") ) {
			viewPage = "draw.jsp";
		} else if ( cmd.equals("/join.go") ) {
			viewPage = "join.jsp";
		} else if ( cmd.equals("/login.go") ) {
			viewPage = "login.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		System.out.println(viewPage + "∑Œ ¿Ãµø.");
		dispatcher.forward(request, response);
	}
}
