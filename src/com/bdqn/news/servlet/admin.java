package com.bdqn.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.News;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.News_UserService;
import com.bdqn.news.service.impl.NewsServiceImpl;
import com.bdqn.news.service.impl.News_UserServiceImpl;

public class admin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public admin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// out.print("<script>alert('Hey buddy i think you've got the wrong door');location.href='index.jsp'</script>");
		// 创建页面实例
		NewsService news = new NewsServiceImpl();
		List<News> newsEL = news.getAllNewsTitle();
		request.getSession().setAttribute("news", newsEL);
		/**
		 * 删除新闻
		 */
		String nid1 = request.getParameter("nid");
		
		if (nid1 == null) {
			int nid = 0;
			System.out.println(nid1);
		} else {
			int nid = Integer.valueOf(request.getParameter("nid"));
			news.deleteNewsByID(nid);
			/*以post形式重新载入页面
			 *如果session中的用户为空,则进入验证失败分支,
			 *这里还没有考虑如何在进行删除操作前先验证一次session用户的有效性
			 */
			
		}
		/**
		 * 注销
		 */
		String logout=request.getParameter("logout");
		if(logout==null){
			this.doPost(request, response);
		}
		else if (logout.equals("true")) {
			request.getSession().invalidate();
			response.getWriter().write("<script>alert('注销成功')</script>");
			response.sendRedirect("../servlet/index");
		}
		else {
			this.doPost(request, response);
		}
		out.close();

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String name;String password;
		News_UserService user = new News_UserServiceImpl();
		// 新闻业务实例
		NewsService news = new NewsServiceImpl();
		/**
		 * 用户认证
		 */
		if(request.getSession().getAttribute("userID")==null){
			// 获取用户名
			 name = request.getParameter("uname");
			// 获取密码
			 password = request.getParameter("upwd");
			
		}
		else {
			 name=(String)request.getSession().getAttribute("userID");
			 password=(String)request.getSession().getAttribute("password");
		}
		// 调用用户业务
		boolean auth = user.login(name, password);
		/**
		 * 执行用户登录业务,login方法返回密码, 比较密码是否相等,如果密码相等就...如果不相等就alert提示
		 */
		if (auth) {
			request.getSession().setAttribute("userID", name);
			request.getSession().setAttribute("password", password);
			// 跳转页面
			response.sendRedirect("../admin.jsp");
			// 创建页面实例

			List<News> newsEL = news.getAllNewsTitle();
			request.getSession().setAttribute("news", newsEL);
		} else {
			String javascript = "<script>alert('notice:账号认证失败');location.href='index';</script>";
			out.print(javascript);
		}
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
