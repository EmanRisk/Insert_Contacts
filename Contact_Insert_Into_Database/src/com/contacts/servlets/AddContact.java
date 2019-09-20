package com.contacts.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contacts.beans.Contact;
import com.contacts.dao.DAOContacts;


/**
 * Servlet implementation class AddContact
 */
@WebServlet("/add")
public class AddContact extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameters
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("number");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
				
		//Get a contact bean from the Model
		Contact contact = new Contact(name, phoneNumber, address, email);
		DAOContacts.addContact(contact);
		
		//Store the bean in an attribute
		//request.setAttribute("meow", contact);
		response.sendRedirect("NewContacts.html");
				
		//WHen doing requestDispatcher, throws must be added to declaration.
		//This will go to our JSP
		//request.getRequestDispatcher("showContacts.jsp").forward(request, response);
		
				
		
	}

}
