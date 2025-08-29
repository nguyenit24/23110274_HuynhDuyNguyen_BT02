package service;

import java.util.List;

import model.Category;

public interface ICategoryService {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category get(int id);
    Category get(String name);
    List<Category> getAll();
    List<Category> search(String keyword);
}

