package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import service.ICategoryService;
import service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryController
 */
//@WebServlet(urlPatterns = { "/admin/categories" , "/admin/category/add" , "/admin/category/edit" , "/admin/category/insert" })

@WebServlet(urlPatterns = { "/admin/categories" , "/admin/category/add" , "/admin/category/edit" , "/admin/category/insert"  , "/admin/category/update", "/admin/category/delete"} )
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICategoryService cateService = new CategoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        if(request.getRequestURI().contains("/admin/categories")) {
            List<Category> lists = cateService.getAll();
            request.setAttribute("cateList", lists);
            request.getRequestDispatcher("/views/admin/listcategory.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("add")) {
            request.getRequestDispatcher("/views/admin/addcategory.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = cateService.get(id);
            request.setAttribute("cate", category);
            request.getRequestDispatcher("/views/admin/editcategory.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cateService.delete(id);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();

        if(uri.contains("insert")) {
            Category category = new Category();

            category.setCategoryname(request.getParameter("categoryname"));
            category.setImages("1.jpg");
            category.setStatus(Integer.parseInt(request.getParameter("status")));
            cateService.insert(category);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        } else if (uri.contains("update")) {
            System.out.println(request.getParameter("categoryname"));
            System.out.println(request.getParameter("image"));
            System.out.println(request.getParameter("status"));
            System.out.println(request.getParameter("categoryid"));
            Category category = new Category();
            category.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
            category.setCategoryname(request.getParameter("categoryname"));
            category.setImages("1.jpg");
            category.setStatus(Integer.parseInt(request.getParameter("status")));
            System.out.println(category.getCategoryid() + category.getCategoryname() + category.getStatus()+ category.getImages());

            cateService.update(category);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        } else if (uri.contains("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cateService.delete(id);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        }
	}

}
