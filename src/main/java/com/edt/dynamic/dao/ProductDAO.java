package com.edt.dynamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.edt.dynamic.controller.DBManager;
import com.edt.dynamic.dto.ProductDTO;

public class ProductDAO {
	private ProductDTO pDto;

	public ProductDAO() {
	}

	public ProductDTO getInstance() {
		pDto = new ProductDTO();
		return pDto;
	}

	public List<ProductDTO> selectProductList(String brand, String filter, String gender) {
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		pDto = getInstance();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM product3";

		System.out.println(brand + " / " + filter + " / " + gender);
		
		if ( brand != null && gender != null ) {
			sql += " WHERE p_brand=" + brand + " AND p_gender=" + gender ; 
		} if ( brand != null && gender == null) {
			sql += " WHERE p_brand=" + brand; 
		} else if ( brand == null && gender != null ) { 
			sql += " WHERE p_gender=" + gender; 
		}

		if ( filter != null ) { 
			sql += " ORDER BY " + filter;
		}
		System.out.println(sql);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
	
	public ProductDTO getProduct(String p_id) {
		pDto = getInstance();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM product3 WHERE p_id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			DBManager.queryClose(conn, pstmt, rs);
		}
		return pDto;
	}
	
	public List<ProductDTO> recommandPage(String p_brand, String p_hit) {
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		pDto = getInstance();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT * FROM product3 ORDER BY ?) WHERE rownum < 6;";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < 2; i++) {
				if ( i == 0 ) {
					pstmt.setString(1, p_brand);
				} else {
					pstmt.setString(1, p_hit);
				}
				rs = pstmt.executeQuery();
				while (rs.next()) {
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
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			DBManager.queryClose(conn, pstmt, rs);
		}
		return dtos;
	}
}
