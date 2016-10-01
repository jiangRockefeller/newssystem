package com.bdqn.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.Comments;
import com.bdqn.news.entity.News;
import com.bdqn.news.service.CommentsService;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.impl.CommentsServiceImpl;
import com.bdqn.news.service.impl.NewsServiceImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NestedParticle;

public class ContextServlet extends HttpServlet {

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
		
													/*
													*//**
													 * 侧边标题栏 暂时使用index的作用域
													 *//*
													//国内新闻
													List<News> side_list_1 = news.getNewsTiltle(1);
													request.getSession().setAttribute("side_list_1", side_list_1);
													//国际新闻
													List<News> side_list_2 = news.getNewsTiltle(2);
													request.getSession().setAttribute("side_list_2", side_list_2);
													//娱乐新闻
													List<News> side_list_5 = news.getNewsTiltle(5);
													request.getSession().setAttribute("side_list_5", side_list_5);*/
		/**
		 * 获取新闻正文
		 */
		NewsService news=new NewsServiceImpl();
		String paraNid=request.getParameter("nid");
		int nid;
		if (paraNid==null) {
			nid=48;
			//System.out.println("参数nid为空,赋值成功");
		}
		else{
			nid=Integer.valueOf(paraNid);
			//System.out.println("参数获取nid成功");
		}
		request.getSession().setAttribute("cnid", nid);
		//System.out.println("即将传入nid:"+nid);
		News context=news.getNewsByNid(nid);
		//System.out.println("跳转到新闻:"+context.getnTitle());
		request.getSession().setAttribute("context", context);
		/**
		 * 获取新闻评论
		 */
		CommentsService instance=new CommentsServiceImpl();
		List<Comments> comments=instance.getCommentByNid(nid);
		request.getSession().setAttribute("comments", comments);
		/**
		 * 获取客户IP
		 */
		String cIP=this.getRemoteAddress(request);
		request.getSession().setAttribute("cIP", cIP);
		response.sendRedirect("../context.jsp");
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
		CommentsService comments=new CommentsServiceImpl();

		int cnid=Integer.valueOf(request.getParameter("cnid"));
		String cContent=request.getParameter("ccontent");
		String cDate="";
		String cIP=this.getRemoteAddress(request);
		String cAuthor=request.getParameter("cauthor");
		comments.addComments(cnid, cContent, cDate, cIP, cAuthor);
		response.sendRedirect("ContextServlet?nid="+cnid);
		out.flush();
		out.close();
	}
	/**
	 * 获取ip
	 */
	public String getRemoteAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
}
