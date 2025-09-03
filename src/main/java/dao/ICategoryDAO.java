package dao;

import java.util.List;

import model.Category;

public interface ICategoryDAO {
    void insert(Category category);
    void edit(Category category);
    void delete(int id);
    Category get(int id);
    Category get(String name);
    List<Category> getAll();

    List<Category> getAll(String user_id);

    List<Category> search(String keyword);
}
