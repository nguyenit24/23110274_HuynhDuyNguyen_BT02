package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class ForgetPassController
 */

@WebServlet(urlPatterns = "/forgetpass")
public class ForgetPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/forgetpass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		if(request.getParameter("email") != null && request.getParameter("newpass") !=null ) {
			String email = request.getParameter("email");
			String newPass = request.getParameter("newpass");
			if(userService.checkExistEmail(email)) {
				if(userService.updatePass(email, newPass)) {
					request.setAttribute("alert", "Đổi mật khẩu thành công!");
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "Đổi mật khẩu thất bại!");
					request.getRequestDispatcher("/views/forgetpass.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("message", "Email không tồn tại!");
				request.getRequestDispatcher("/views/forgetpass.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Nhập Email và Password");
			request.getRequestDispatcher("/views/forgetpass.jsp").forward(request, response);
		}
	}

}
