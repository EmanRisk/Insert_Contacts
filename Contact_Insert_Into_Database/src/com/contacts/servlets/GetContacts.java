package com.contacts.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contacts.beans.Contact;
import com.contacts.dao.DAOContacts;

/**
 * Servlet implementation class GetContacts
 */
@WebServlet("/GetContacts")
public class GetContacts extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Contact> c = DAOContacts.getContacts();
		
		//Store attribute
		request.setAttribute("meow", c);
		
		//Send to JSP
		request.getRequestDispatcher("ShowContacts.jsp").forward(request, response);
		
	}
}
