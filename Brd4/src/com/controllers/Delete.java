package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbInsert;
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String[] recordName = new String[17];
		recordName[0]="CUSTOMERID";
		recordName[1]="CUSTOMERCODE";
		recordName[2]="CUSTUMERNAME";
		recordName[3]="CUSTOMERADDRESS1";
		recordName[4]="CUSTOMERADDRESS2";
		recordName[5]="CUSTOMERPINCODE";
		recordName[6]="EMAILADDRESS";
		recordName[7]="CONTACTNUMBER";
		recordName[8]="PRIMARYCONTACTPERSON";
		recordName[9]="RECORDSTATUS";
		recordName[10]="ACTIVEINACTIVFLAG";
		recordName[11]="CREATEDATE";
		recordName[12]="CREATEDBY";
		recordName[13]="MODIFIEDDATE";
		recordName[14]="MODIFIEDBY";
		recordName[15]="AUTHORIZEDDATE";
		recordName[16]="AUTHORIZEDBY";
		String record[] = null;
		PrintWriter out=response.getWriter();
		String customerCode=request.getParameter("id");
		try {
		    record=DbInsert.getRecord(customerCode);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Error connecting to dao for deleting");
		}
	    out.println("<!DOCTYPE html>\r\n" + 
	    		"<html>\r\n" + 
	    		"<head>\r\n" + 
	    		"<style>\r\n" + 
	    		"#customers {\r\n" + 
	    		"  font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\r\n" + 
	    		"  border-collapse: collapse;\r\n" + 
	    		"  width: 100%;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"#customers td, #customers th {\r\n" + 
	    		"  border: 1px solid #ddd;\r\n" + 
	    		"  padding: 8px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"#customers tr:nth-child(even){background-color: #f2f2f2;}\r\n" + 
	    		"\r\n" + 
	    		"#customers tr:hover {background-color: #ddd;}\r\n" + 
	    		"\r\n" + 
	    		"#customers th {\r\n" + 
	    		"  padding-top: 12px;\r\n" + 
	    		"  padding-bottom: 12px;\r\n" + 
	    		"  text-align: left;\r\n" + 
	    		"  background-color: #4CAF50;\r\n" + 
	    		"  color: white;\r\n" + 
	    		"}\r\n" + 
	    		"</style>\r\n" + 
	    		"</head>\r\n" + 
	    		"<body>\r\n" + 
	    		"\r\n" + 
	    		"<table id=\"customers\">\r\n" + 
	    		"  <tr>\r\n" + 
	    		"    <th>CustomerCode</th>\r\n" + 
	    		"    <th></th>\r\n" + 
	    		"  </tr>");
		for(int i=0;i<record.length;i++)
		{
			
			out.println("<tr>\r\n" + 
					"    <td>"+recordName[i]+"</td>\r\n" + 
					"    <td>"+record[i]+"</td>\r\n" + 
					"  </tr>");
		}
		
		delete(customerCode);
		out.println("This record deleted successfully");
		out.println("<link rel=\"stylesheet\"\r\n" + 
				"    href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"    <form action=\"ViewRecords\" method=\"Get\"style=\"width: 500px\"> \r\n" + 
				"        <input type=\"submit\" value=\"View available Records\" class=\"btn btn-success\">\r\n" + 
				"    </form>");
}
public void delete(String customerCode)
{
	try {
		DbInsert.deleteRecord(customerCode);
		DbInsert.commit();
	} catch (SQLException sqlException) {
		sqlException.printStackTrace();
		System.out.println("Error deleting record");
	}
}

}
