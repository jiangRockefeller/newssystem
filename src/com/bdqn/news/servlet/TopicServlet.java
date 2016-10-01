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

public class TopicServlet extends HttpServlet {
	
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TopicService topicService=new TopicServiceImpl();
		NewsService news=new NewsServiceImpl();
		/**
		 * ɾ������ Ҫ�ȵ���NewsServic�ķ��� ɾ��topic���ӱ������
		 * ������ntid��ȡ���� getNewsTiltle---newsdaoimpl:getNewsByTopic
		 * ������idɾ������ deleteNewsByID
		 */
			//���в�������tid,����ɾ��ҵ��
		if(request.getParameter("tid")!=null){
			int ntid=Integer.valueOf(request.getParameter("tid"));
			//������ntid�����ŷ���list
			List<News> topicNewsList=news.getNewsTiltle(ntid);
				//������������nid������ֵ
			int[]nidArray;
			nidArray=new int[topicNewsList.size()];
				//����list,��nid��ֵ������
			for (int i = 0; i < topicNewsList.size(); i++) {
				nidArray[i]=topicNewsList.get(i).getNid();
			}
				//��������,����nid����ɾ�����ŷ���
			for (int i = 0; i < nidArray.length; i++) {
				news.deleteNewsByID(nidArray[i]);
			}
				//��ʽɾ������
			topicService.delTopic(ntid);
		}
		/**
		 * <topic_list.jsp>���ݴ���,����������list
		 */
		List<Topic> topicList=topicService.getTopic("*");
		request.getSession().setAttribute("topicList", topicList);
		/*-------------�������,ҳ����ת---------------------------*/
		response.sendRedirect("../topic_list.jsp");
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
