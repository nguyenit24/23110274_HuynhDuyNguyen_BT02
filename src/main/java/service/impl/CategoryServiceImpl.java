package service.impl;

import java.io.File;
import java.util.List;

import dao.ICategoryDAO;
import dao.impl.CategoryDAOImpl;
import model.Category;
import service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDAO categoryDao = new CategoryDAOImpl();


    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void update(Category newCategory) {
        Category cate = new Category();
        cate = categoryDao.get(newCategory.getCategoryid());
        if(cate != null) {
            categoryDao.edit(newCategory);
        }
    }

    @Override
    public void delete(int id) {
        Category cate = new Category();
        cate = categoryDao.get(id);
        if(cate != null) {
            categoryDao.delete(id);
        }
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }

    @Override
    public List<Category> getAll(String user_id) {
        return categoryDao.getAll(user_id);
    }

}
