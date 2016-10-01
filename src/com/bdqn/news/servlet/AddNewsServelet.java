package com.bdqn.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.dao.NewsDao;
import com.bdqn.news.entity.News;
import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.NewsServiceImpl;
import com.bdqn.news.service.impl.TopicServiceImpl;

public class AddNewsServelet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		/**
		 * 给新闻类型下拉框选项赋值
		 */
		TopicService list=new TopicServiceImpl();
		List<Topic> topic =list.getTopic("*");
		request.getSession().setAttribute("topic", topic);
		/**
		 * 给修改新闻页面传入所修改新闻的值
		 */
		NewsService news=new NewsServiceImpl();
		String nidTest=request.getParameter("nid");
			//如果请求中有参数nid,则调用修改功能,否则清除预设值并调用添加功能
		if(nidTest!=null){
			int nid=Integer.valueOf(nidTest);
			request.getSession().setAttribute("aom", "修改");//应该改用forword 总之考虑不要用session
			request.getSession().setAttribute("nid", nid);
			News instance=news.getNewsByNid(nid);
			request.getSession().setAttribute("instance", instance);
		}
		else {
			request.getSession().setAttribute("aom", "添加");//应该改用forword 总之考虑不要用session
			request.getSession().removeAttribute("instance");
		}
		response.sendRedirect("../news_add.jsp");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int ntid=Integer.valueOf(request.getParameter("ntid"));
		//获取post参数
		String nTitle=request.getParameter("ntitle");
		String nAuthor=request.getParameter("nauthor");
		String nSummary=request.getParameter("nsummary");
		String nContent=request.getParameter("ncontent");
		NewsService manageNews=new NewsServiceImpl();
			//action参数确定是修改还是添加
		String action=request.getParameter("action");
			//noticeNction参数确定是继续添加还是跳到修改页
		String noticeNction=request.getParameter("noticeNction");
		if(action.equals("modify")){
			int nid=Integer.valueOf(request.getParameter("nid"));
			System.out.println(nid);
			//调用新闻修改方法
			manageNews.modifyNews(nid, ntid, nTitle, nAuthor, nSummary, nContent, "", "");
			System.out.println("用户:"+nAuthor+"已修改新闻:"+nTitle);
			response.sendRedirect("admin");
		}
		else {
			//调用新闻添加方法
			manageNews.addNews(ntid, nTitle, nAuthor, nSummary, nContent, "", "");
			if(noticeNction.equals("continueToAdd")){
				response.sendRedirect("AddNewsServelet");
			}
			else {
				response.sendRedirect("admin");
			}
			System.out.println("用户:"+nAuthor+"已添加新闻:"+nTitle);
			//response.sendRedirect("ContextServlet?nid="+nid);
		}/*request.getRequestDispatcher("admin.jsp").forward(request, response);*/
		out.flush();
		out.close();	
	}

}
