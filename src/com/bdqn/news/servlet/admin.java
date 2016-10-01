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
		// ����ҳ��ʵ��
		NewsService news = new NewsServiceImpl();
		List<News> newsEL = news.getAllNewsTitle();
		request.getSession().setAttribute("news", newsEL);
		/**
		 * ɾ������
		 */
		String nid1 = request.getParameter("nid");
		
		if (nid1 == null) {
			int nid = 0;
			System.out.println(nid1);
		} else {
			int nid = Integer.valueOf(request.getParameter("nid"));
			news.deleteNewsByID(nid);
			/*��post��ʽ��������ҳ��
			 *���session�е��û�Ϊ��,�������֤ʧ�ܷ�֧,
			 *���ﻹû�п�������ڽ���ɾ������ǰ����֤һ��session�û�����Ч��
			 */
			
		}
		/**
		 * ע��
		 */
		String logout=request.getParameter("logout");
		if(logout==null){
			this.doPost(request, response);
		}
		else if (logout.equals("true")) {
			request.getSession().invalidate();
			response.getWriter().write("<script>alert('ע���ɹ�')</script>");
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
		// ����ҵ��ʵ��
		NewsService news = new NewsServiceImpl();
		/**
		 * �û���֤
		 */
		if(request.getSession().getAttribute("userID")==null){
			// ��ȡ�û���
			 name = request.getParameter("uname");
			// ��ȡ����
			 password = request.getParameter("upwd");
			
		}
		else {
			 name=(String)request.getSession().getAttribute("userID");
			 password=(String)request.getSession().getAttribute("password");
		}
		// �����û�ҵ��
		boolean auth = user.login(name, password);
		/**
		 * ִ���û���¼ҵ��,login������������, �Ƚ������Ƿ����,���������Ⱦ�...�������Ⱦ�alert��ʾ
		 */
		if (auth) {
			request.getSession().setAttribute("userID", name);
			request.getSession().setAttribute("password", password);
			// ��תҳ��
			response.sendRedirect("../admin.jsp");
			// ����ҳ��ʵ��

			List<News> newsEL = news.getAllNewsTitle();
			request.getSession().setAttribute("news", newsEL);
		} else {
			String javascript = "<script>alert('notice:�˺���֤ʧ��');location.href='index';</script>";
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
