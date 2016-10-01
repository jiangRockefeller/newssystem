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
		 * ��߱�����
		 */
		//��������
		List<News> side_list_1 = news.getNewsTiltle(1);
		request.getSession().setAttribute("side_list_1", side_list_1);
		//��������
		List<News> side_list_2 = news.getNewsTiltle(2);
		request.getSession().setAttribute("side_list_2", side_list_2);
		//��������
		List<News> side_list_5 = news.getNewsTiltle(5);
		request.getSession().setAttribute("side_list_5", side_list_5);
		/**
		 * ���ർ��
		 */
			TopicService topic=new TopicServiceImpl();
			List<Topic> tName=topic.getTopic("*");
			request.getSession().setAttribute("tName", tName);
		/**
		 * ���ű����ҳ
		 */
			int ntid=1;
          	int pageNum;
          	int pageSize=6;
          	Object testAttribute = request.getSession().getAttribute("ntid");
          	String testParameter = request.getParameter("ntid");
          	String pageNum1=request.getParameter("pageNum");

          	//����ntid����,ת��
          	if(testParameter!=null){
          		ntid=Integer.valueOf(request.getParameter("ntid"));
          	}
          	else if (testAttribute!=null) {
          		ntid=(Integer)testAttribute;
			}
          	/*else{
          	ntid=Integer.valueOf(request.getParameter("ntid"));
          	}*/
          	//����pageNum����,ת��
          	if(pageNum1==null){
          		pageNum=1;
          	}
          	else{
          	pageNum=Integer.valueOf(request.getParameter("pageNum"));
          	}
          	
          	//�������ҳ��
          	int MaxPage=news.getMaxPage(ntid, pageSize);
            //���÷�ҳ����
          	List<News> mainTitle=news.getPagingNewsTitleByTopic(ntid, pageNum, pageSize);
          	request.getSession().setAttribute("mainTitle", mainTitle);
          	//����jspҳ��,��ҳ��JSTL����
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
              		//ûɶ��,ֻΪû�����ǲ�����ʾ1/0��ô��� ��ʾ1/1
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
		 * ������ȡ���,��תҳ��
		 */
          	
          /*	//����:����̨���ntid�ͱ���
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
