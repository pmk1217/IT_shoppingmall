package admin.index.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.action.vo.UserVO;
import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class AdminIndexDAO extends MySQLConnector {

    private Connection connector = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public AdminIndexDAO() {
        this.connector = getConnection();
    }

    // 회원 수 조회
    public int userCount() {
        int count = 0;

        try {
            String query = "SELECT COUNT(*) AS count FROM user";
            pstmt = connector.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("회원 수 조회 실패: " + e.getMessage());
        } finally {
            close(null, pstmt, rs);
        }

        return count;
    }

    // 상품 수 조회
    public int productCount() {
        int count = 0;

        try {
            String query = "SELECT COUNT(*) AS count FROM product";
            pstmt = connector.prepareStatement(query);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("상품 수 조회 실패: " + e.getMessage());
        } finally {
            close(null, pstmt, rs);
        }

        return count;
    }


    public List<UserProductVO> productQuantity() {
        List<UserProductVO> productList = new ArrayList<>();

        try {
            String query = "SELECT * FROM product ORDER BY quantity ASC";
            pstmt = connector.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserProductVO product = new UserProductVO();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(rs.getString("category"));
                product.setImg(rs.getString("img"));
                

                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("상품 quantity순 조회 실패: " + e.getMessage());
        } finally {
            close(null, pstmt, rs);
        }

        return productList;
    }

    // 상품 likes순 조회
    public List<UserProductVO> productLikes() {
        List<UserProductVO> productList = new ArrayList<>();

        try {
            String query = "SELECT * FROM product ORDER BY likes DESC";
            pstmt = connector.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserProductVO product = new UserProductVO();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setImg(rs.getString("img"));
                product.setCategory(rs.getString("category"));
                product.setLikes(rs.getInt("likes"));

                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("상품 likes순 조회 실패: " + e.getMessage());
        } finally {
            close(null, pstmt, rs);
        }

        return productList;
    }
}
