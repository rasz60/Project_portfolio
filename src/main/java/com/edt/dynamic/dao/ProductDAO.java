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
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		
		pDto = new ProductDTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product3";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				pDto = getInstance();
				pDto.setpId(rs.getString(1));
				pDto.setpBrand(rs.getString(2));
				pDto.setpCollection(rs.getString(3));
				pDto.setpEname(rs.getString(4));
				pDto.setpKname(rs.getString(5));
				pDto.setpImage(rs.getString(6));
				pDto.setpGender(rs.getString(7));
				pDto.setpSize(rs.getInt(8));
				pDto.setpPrice(rs.getInt(9));
				pDto.setpStock(rs.getInt(10));
				pDto.setpDate(rs.getTimestamp(11));
				pDto.setpHit(rs.getInt(12));
				dtos.add(pDto);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			DBManager.queryClose(conn, pstmt, rs);
		}
		return dtos;
	}
}
