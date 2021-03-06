package com.edt.dynamic.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edt.dynamic.dao.ProductDAO;

public class ExecuteProducts implements Execute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = new ProductDAO();
		
		String brand = request.getParameter("brand");
		String filter = request.getParameter("filter");
		String gender = request.getParameter("gender");
		
		request.setAttribute("pList", pDao.selectProductList(brand, filter, gender));
	}


}
