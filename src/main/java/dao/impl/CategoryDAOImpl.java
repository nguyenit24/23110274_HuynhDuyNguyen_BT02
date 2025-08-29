package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBContextSQL;
import dao.ICategoryDAO;
import model.Category;

public class CategoryDAOImpl extends DBContextSQL implements ICategoryDAO {

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category(categoryname, images, status) VALUES(?, ?, ?)";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Category category) {

        String sql = "UPDATE Category SET categoryname = ?, images = ?, status = ?  WHERE categoryid = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE categoryid = ?";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM Category WHERE categoryid = ? ";
        try {
            Connection con = super.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM Category";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> search(String keyword) {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM Category WHERE cate_name LIKE ?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

}

