package com.edt.dynamic.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edt.dynamic.dao.ProductDAO;
import com.edt.dynamic.dto.ProductDTO;

public class ExecuteProduct implements Execute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pDao = new ProductDAO();
		
		String p_id = request.getParameter("p_id");
		ProductDTO pDto = pDao.getProduct(p_id);
		request.setAttribute("product", pDao.getProduct(p_id));
		request.setAttribute("pList", pDao.recommandPage(pDto.getpBrand(), "p_hit"));
	}

}
