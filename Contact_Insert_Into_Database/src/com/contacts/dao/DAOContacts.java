package com.contacts.dao;

import com.contacts.beans.Contact;
import java.sql.*;
import java.util.ArrayList;

public class DAOContacts {
	
	public static void addContact(Contact contact) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/Contacts?useSSL=false", "root", "4168319947");

            String Query = "INSERT INTO contact_info VALUES ('"
            		+ contact.getName()
            		+ "', '"
            		+ contact.getPhoneNumber()
            		+ "', '"
            		+ contact.getAddress()
            		+ "', '"
            		+ contact.getEmail()
            		+ "')";
            
            System.out.println(Query);
            
            Statement st = conn.createStatement();
            st.executeUpdate(Query);
            
            System.out.println("Query successful");
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }	
	}

	public void dummyContacts() {
		Contact c1 = new Contact("Emanuel", "911", "123 street", "huh.gmail.com");
		addContact(c1);	
	}
	
	public static ArrayList<Contact> getContacts(){
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/Contacts?useSSL=false", "root", "4168319947");

            String Query = "SELECT * FROM contact_info";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query);
            
            while (rs.next()) {
            	String name = rs.getString(1);
            	String number = rs.getString(2);
            	String address = rs.getString(3);
            	String email = rs.getString(4);
            	Contact c = new Contact(name, number, address, email);
            	contacts.add(c);
            }
            
            System.out.println("Query successful");
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }
		return contacts;
	}

}
