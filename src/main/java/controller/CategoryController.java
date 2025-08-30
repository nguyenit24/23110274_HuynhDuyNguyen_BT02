package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Category;
import service.ICategoryService;
import service.impl.CategoryServiceImpl;
import util.Constant;

/**
 * Servlet implementation class CategoryController
 */
//@WebServlet(urlPatterns = { "/admin/categories" , "/admin/category/add" , "/admin/category/edit" , "/admin/category/insert" })
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50 )
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

            // upload file image
            String fname = "";
            String uploadPath = Constant.DIR;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part filePart = request.getPart("image");
                if(filePart.getSize() > 0) {
                    fname = filePart.getSubmittedFileName();
                    int index = fname.lastIndexOf(".");
                    String ext = fname.substring(index);
                    fname = System.currentTimeMillis() + ext;
                    filePart.write(uploadPath + File.separator + fname);
                    category.setImages(fname);
                } else {
                    category.setImages("1.jpg");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cateService.insert(category);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        } else if (uri.contains("update")) {
            Category category = new Category();
            category.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
            category.setCategoryname(request.getParameter("categoryname"));

            Category oldCate = cateService.get(category.getCategoryid());

            // upload file image
            String fname = "";
            String uploadPath = Constant.DIR;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part filePart = request.getPart("image");
                if(filePart.getSize() > 0) {
                    fname = filePart.getSubmittedFileName();
                    int index = fname.lastIndexOf(".");
                    String ext = fname.substring(index);
                    fname = System.currentTimeMillis() + ext;
                    filePart.write(uploadPath + File.separator + fname);
                    category.setImages(fname);
                } else {
                    category.setImages(oldCate.getImages());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            category.setStatus(Integer.parseInt(request.getParameter("status")));
            cateService.update(category);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        } else if (uri.contains("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cateService.delete(id);
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        }
	}

}
