package com.edt.dynamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edt.dynamic.controller.DBManager;
import com.edt.dynamic.dto.ProductDTO;

public class ProductDAO {
	private ProductDTO pDto;

	public ProductDAO() {}
	
	public ProductDTO getInstance() {
		pDto = new ProductDTO();
		
		return pDto;
	}
	
	public List<ProductDTO> selectProductList() {
		ArrayList<ProductDTO> dtos = new ArrayList<ProductDTO>();
		
		pDto = new ProductDTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product3";
		
		try {
			conn = DBManager.DBConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
				pDto.setpId(rs.getString("P_ID"));
			}
			
		} catch (Exception e1 ) {
			
		} finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
		
		return dtos;
	}
}
