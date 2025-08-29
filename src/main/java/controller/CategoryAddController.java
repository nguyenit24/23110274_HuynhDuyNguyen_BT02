package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.core.FileUploadException;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import util.Constant;

/**
 * Servlet implementation class CategoryAddController
 */

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService cateService = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/views/admin/addcategory.jsp");
				dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
	    DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	    JakartaServletFileUpload servletFileUpload = new JakartaServletFileUpload(diskFileItemFactory);
	    servletFileUpload.setHeaderEncoding("UTF-8");

	    try {
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");

	        List<FileItem> items = servletFileUpload.parseRequest(request);
	        for (FileItem item : items) {
	            if (item.isFormField() && item.getFieldName().equals("name")) {
	                category.setName(item.getString("UTF-8"));
	            } else if (!item.isFormField() && item.getFieldName().equals("icon")) {
	                if (item.getSize() > 0) {
	                    String originalFileName = item.getName();
	                    int index = originalFileName.lastIndexOf(".");
	                    String ext = originalFileName.substring(index + 1);
	                    String fileName = System.currentTimeMillis() + "." + ext;
	                    File file = new File(Constant.DIR + "/category/" + fileName);
	                    item.write(file.toPath()); // commons-fileupload2 dùng Path
	                    category.setIcon("category/" + fileName);
	                }
	            }
	        }

	        // gọi service để lưu vào DB
	        cateService.insert(category);

	        // redirect về list
	        response.sendRedirect(request.getContextPath() + "/admin/category/list");
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}

}
