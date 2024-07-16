package admin.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class AdminProductSelectAllDAO extends MySQLConnector{

	private MySQLConnector datasource = null;
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminProductSelectAllDAO() {
		this.connector = getConnection();
	}

	public List<UserProductVO> productSelectAll(UserProductVO productVO) {
		List<UserProductVO> productList = new ArrayList<UserProductVO>();
		
		int pageNum = Integer.parseInt(productVO.getPageNum()); // "1" => 1
		int listCount = productVO.getListCount();	// 한 페이지 게시물 갯수
		String searchType = productVO.getSearchType();	//  검색 종류
		String searchText = productVO.getSearchText();		// 검색어
		// 처음 호출 되었을 때 selectCount()에 의해 "" 값으로 초기화....
		
		String whereSQL = "";	
		
		try {
			
			if (!"".equals(searchText)) { // 만약 검색어가 ""이 아니면
				if ("ALL".equals(searchType)) {
					whereSQL = " WHERE NAME LIKE CONCAT('%',?,'%') OR CONTENT LIKE CONCAT('%',?,'%') OR CATEGORY LIKE CONCAT('%',?,'%') ";
				} else if ("NAME".equals(searchType)) {		// 이름에서만 확인
					whereSQL = " WHERE NAME LIKE CONCAT('%',?,'%') "; // order by가 오기때문에 맨 끝을 공백으로 비워둬야 함
				} else if ("CONTENT".equals(searchType)) {		// 글에서만 확인
					whereSQL = " WHERE CONTENT LIKE CONCAT('%',?,'%') ";
				} else if ("CATEGORY".equals(searchType)) {		// 카테고리에서만 확인
					whereSQL = " WHERE CATEGORY LIKE CONCAT('%',?,'%') ";
				}
			}
			
			String end = " order by product_id desc limit ?, ?";
			String first = "select * from product";
			String query = first + whereSQL + end;
			pstmt = connector.prepareStatement(query);
			
			if (!"".equals(whereSQL)) {		// 검색 쿼리가 있을 경우에만
				
				if ("ALL".equals(searchType)) {				// 전체검색일 경우 ? 다섯 개
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
					this.pstmt.setInt(4, listCount * (pageNum-1));	// 페이지의 시작 번호
					this.pstmt.setInt(5, listCount);							// 조회 갯수
				} else {
					this.pstmt.setString(1, searchText);			// 그 외의 검색일 경우 ? 세 개
					this.pstmt.setInt(2, listCount * (pageNum-1));
					this.pstmt.setInt(3, listCount);			
				}
			} else {	// 검색 쿼리(검색어)가 없을 경우
				this.pstmt.setInt(1, listCount * (pageNum-1));	// 페이지의 시작 번호
				this.pstmt.setInt(2, listCount);							// 조회 갯수
			}	
			
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				productVO = new UserProductVO();
				productVO.setProduct_id(rs.getInt("product_id"));
				productVO.setName(rs.getString("name"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setQuantity(rs.getInt("quantity"));
				productVO.setCategory(rs.getString("category"));
				productVO.setUpdated_at(rs.getTimestamp("updated_at"));
				
				productList.add(productVO);
			}
			
		} catch (Exception e) {
			System.err.println("상품 리스트 조회 실패 : " + e.getMessage());
		} finally {
			this.close(null, pstmt, rs);
		}
		return productList;
	}
	
	
	public int selectCount(UserProductVO productVO) {
		int totalCount = 0;
		String searchType = productVO.getSearchType();
		String searchText = productVO.getSearchText();
		String whereSQL = "";		// select 쿼리의 조건 부분만 저장
		
		
		
		try {
			if (!"".equals(searchText)) { // 만약 검색어가 ""이 아니면
				if ("ALL".equals(searchType)) {
					whereSQL = " WHERE NAME LIKE CONCAT('%',?,'%') OR CONTENT LIKE CONCAT('%',?,'%') OR CATEGORY LIKE CONCAT('%',?,'%') ";
				} else if ("NAME".equals(searchType)) {		// 이름에서만 확인
					whereSQL = " WHERE NAME LIKE CONCAT('%',?,'%') "; // order by가 오기때문에 맨 끝을 공백으로 비워둬야 함
				} else if ("CONTENT".equals(searchType)) {		// 글에서만 확인
					whereSQL = " WHERE CONTENT LIKE CONCAT('%',?,'%') ";
				} else if ("CATEGORY".equals(searchType)) {		// 카테고리에서만 확인
					whereSQL = " WHERE CATEGORY LIKE CONCAT('%',?,'%') ";
				}
			}	
			String query="SELECT COUNT(product_id) AS TOTAL FROM product " + whereSQL;
							// TOTAL로 변경시켜서 값을 가져옴
			pstmt = connector.prepareStatement(query);
			
			if (!"".equals(whereSQL)) {		// 검색어가 있을 경우에만
				if ("ALL".equals(searchType)) {		// 전체 검색일 경우 ? 세 개
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
				} else {
					this.pstmt.setString(1, searchText);		// 그 외의 검색일 경우 ? 한 개 
				}
			}
			
			rs = pstmt.executeQuery();
			
			if (this.rs.next()) {
				totalCount = this.rs.getInt("TOTAL");	//  결과 필드명을 이용
			}
		} catch (Exception e) {
			System.err.println("카운트 실패 : " + e.getMessage());
		} finally {
			this.close(null, pstmt, rs);
		}
		return totalCount;
	}
		
		
		
		
		
		
		

		
		
	
}
