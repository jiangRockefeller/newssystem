package com.bdqn.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.news.entity.News;
import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.NewsService;
import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.NewsServiceImpl;
import com.bdqn.news.service.impl.TopicServiceImpl;

public class index extends HttpServlet {

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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		NewsService news=new NewsServiceImpl();
		/**
		 * 侧边标题栏
		 */
		//国内新闻
		List<News> side_list_1 = news.getNewsTiltle(1);
		request.getSession().setAttribute("side_list_1", side_list_1);
		//国际新闻
		List<News> side_list_2 = news.getNewsTiltle(2);
		request.getSession().setAttribute("side_list_2", side_list_2);
		//娱乐新闻
		List<News> side_list_5 = news.getNewsTiltle(5);
		request.getSession().setAttribute("side_list_5", side_list_5);
		/**
		 * 分类导航
		 */
			TopicService topic=new TopicServiceImpl();
			List<Topic> tName=topic.getTopic("*");
			request.getSession().setAttribute("tName", tName);
		/**
		 * 新闻标题分页
		 */
			int ntid=1;
          	int pageNum;
          	int pageSize=6;
          	Object testAttribute = request.getSession().getAttribute("ntid");
          	String testParameter = request.getParameter("ntid");
          	String pageNum1=request.getParameter("pageNum");

          	//参数ntid传入,转型
          	if(testParameter!=null){
          		ntid=Integer.valueOf(request.getParameter("ntid"));
          	}
          	else if (testAttribute!=null) {
          		ntid=(Integer)testAttribute;
			}
          	/*else{
          	ntid=Integer.valueOf(request.getParameter("ntid"));
          	}*/
          	//参数pageNum传入,转型
          	if(pageNum1==null){
          		pageNum=1;
          	}
          	else{
          	pageNum=Integer.valueOf(request.getParameter("pageNum"));
          	}
          	
          	//计算最大页数
          	int MaxPage=news.getMaxPage(ntid, pageSize);
            //调用分页方法
          	List<News> mainTitle=news.getPagingNewsTitleByTopic(ntid, pageNum, pageSize);
          	request.getSession().setAttribute("mainTitle", mainTitle);
          	//设置jsp页面,分页的JSTL参数
          	request.getSession().setAttribute("ntid", ntid);
          	request.getSession().setAttribute("pageNum", pageNum);
          	request.getSession().setAttribute("MaxPage", MaxPage);
          	String prePage;String nextPage;
          	if (pageNum>1&&pageNum<MaxPage) {
          		prePage="servlet/index?pageNum="+(pageNum-1);
          		nextPage="servlet/index?pageNum="+(pageNum+1);
          		request.getSession().setAttribute("prePage", prePage);
              	request.getSession().setAttribute("nextPage", nextPage);
			}
          	else if(pageNum==1){
          		prePage="javascript:void()";
          		nextPage="servlet/index?pageNum="+(pageNum+1);
          		if(MaxPage==0||MaxPage==1){
          			prePage="javascript:void()";
              		nextPage="javascript:void()";
              		//没啥用,只为没数据是不会显示1/0这么奇怪 显示1/1
              		MaxPage=1;
              		request.getSession().setAttribute("MaxPage", MaxPage);
          		}
          		request.getSession().setAttribute("prePage", prePage);
              	request.getSession().setAttribute("nextPage", nextPage);
          	}
          	else if(pageNum==MaxPage) {
          		prePage="servlet/index?pageNum="+(pageNum-1);
          		nextPage="javascript:void()";
          		request.getSession().setAttribute("prePage", prePage);
              	request.getSession().setAttribute("nextPage", nextPage);
			}

          	
		/**
		 * 数据提取完成,跳转页面
		 */
          	
          /*	//测试:控制台输出ntid和标题
           * for(int i=0;i<mainTitle.size();i++){
          		System.out.println("ntid="+ntid+"\n"+mainTitle.get(i).getnTitle());
          	}*/
          	
			response.sendRedirect("../index.jsp");
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
