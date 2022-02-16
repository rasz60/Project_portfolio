package com.edt.dynamic.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edt.dynamic.dao.ProductDAO;
import com.edt.dynamic.dto.ProductDTO;

public class ExecuteProducts implements Execute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = new ProductDAO();
		request.setAttribute("pList", pDao.selectProductList());
	}


}
