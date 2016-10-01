<%@page import="com.bdqn.news.entity.News"%>
<%@page import="com.bdqn.news.service.impl.NewsServiceImpl"%>
<%@page import="com.bdqn.news.service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
/* Object obj = session.getAttribute("userID");
			if(obj == null){
				response.sendRedirect("index.jsp");
			} */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
<title>后台管理admin页</title>
<link href="css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body style="zoom: 1;">


<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><a href="servlet/index" ><img src="images/logo.jpg" alt="新闻中国"  /></a></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt=""/></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：&nbsp;${userID}&nbsp;&nbsp;&nbsp;&nbsp; <a href="servlet/admin?logout=true">login out</a></div>
  <div id="channel"> </div>
</div>



<div id="main">
  <div id="opt_list">
  <ul>
    <li><a href="servlet/AddNewsServelet">添加新闻</a></li>
    <li><a href="#">编辑新闻</a></li>
    <li><a href="topic_add.jsp">添加主题</a></li>
    <li><a href="servlet/TopicServlet">编辑主题</a></li>
  </ul>
</div>

  <div id="opt_area">    
<script language="javascript">
	function clickdel(){
		return confirm("进行此操作会同时删除相关评论数据,请确认是否删除");
	}
</script>

    <ul class="classlist">
    	<!-- 当前页[/]<a>上一页</a>|<a>下一页</a> -->
       <c:forEach  items="${news}"  var="news" varStatus="status">
	      <li>
	      		${news.getnTitle()}
	      		<span> 
	      			作者：${news.getnAuthor()} &nbsp;&nbsp;&nbsp;&nbsp; 
	      			<a href="servlet/AddNewsServelet?nid=${news.getNid()}">修改</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:if(clickdel()){location.href='servlet/admin?nid=${news.getNid()}';}" >删除</a>
	      		</span> 
	      </li>
	      <c:if test="${status.count%5==0}"><li class="space"></li></c:if>
	    </c:forEach>
	    
    </ul>
  </div>
</div>
<div id="footer">
  <div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <a href="#">常见问题解答</a> &nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<br/>
    文明办网文明上网举报电话：010-627488888  &nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright © 1999-2009 News China gov, All Right Reserver<br/>
    新闻中国   版权所有</p>
</div>


</div>


<div></div></body>
</html>
