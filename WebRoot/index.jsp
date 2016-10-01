<%@page import="com.bdqn.news.service.impl.TopicServiceImpl"%>
<%@page import="com.bdqn.news.service.TopicService"%>
<%@page import="com.bdqn.news.service.NewsService"%>
<%@page import="com.bdqn.news.service.impl.NewsServiceImpl"%>
<%@page import="com.bdqn.news.entity.News"%>
<%@page import="com.bdqn.news.entity.Topic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function check(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请确认！");
			login_username.focus();	
			document.getElementById("uname").value="请输入用户名";
			document.getElementById("upwd").value="请输入密码";
		}
	}
	function subCheck(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请确认！");
		
			login_username.focus();	
			return false;
		}
		if(login_password.value==""){
			alert("密码不能为空！请确认！");
			login_password.focus();
			return false;
		}
		return false;
	}
	function test(){
		return false;
	}
	function clearLoginTips(){
			var name=document.getElementById("uname").value;
			var pwd=document.getElementById("upwd").value;
			if(name=="请输入用户名"&&pwd=="请输入密码"){
				document.getElementById("uname").value="";
				document.getElementById("upwd").value="";
			}
		}
	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();	
	}
</script>
</head>

<body onload="focusOnLogin()">
  
<div id="header">
  <div id="top_login">
    <form action="servlet/admin" method="post" onsubmit="test()">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="请输入用户名" class="login_input"  onclick="clearLoginTips()" onblur="" autocomplete="off"/>
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="请输入密码" class="login_input" onclick="clearLoginTips()" onblur="" autocomplete="off"/>
      <input type="submit" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <a href="servlet/index" ><img src="images/logo.jpg" alt="新闻中国" /></a> </div>
    <div id="a_b01"> <img id="logopic" src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">

<div class="sidebar">
    <h1><img src="images/title_1.gif" alt="国内新闻" /></h1>
    <div class="side_list">
      <ul>      
      	<c:forEach items="${side_list_1}" var="side_list_1" end="5" >
      		<li>
      			<a href="servlet/ContextServlet?nid=${side_list_1.getNid()}"><b>${side_list_1.getnTitle()}</b></a>
      		</li>
      	</c:forEach>      	
      </ul>
    </div>
    <h1><img src="images/title_2.gif" alt="国际新闻" /></h1>
    <div class="side_list">
      <ul>   
      	<c:forEach items="${side_list_2}" var="side_list_2" end="5" >
      			<li>
      				<a href="servlet/ContextServlet?nid=${side_list_2.getNid()}"><b>${side_list_2.getnTitle()}</b></a>
      			</li>
      	</c:forEach>  
      </ul>
    </div>
    <h1><img src="images/title_3.gif" alt="娱乐新闻" /></h1>
    <div class="side_list">
      <ul>
          <c:forEach items="${side_list_5}" var="side_list_5" end="5" >
      		<li>
      			<a href="servlet/ContextServlet?nid=${side_list_5.getNid()}"><b>${side_list_5.getnTitle()}</b></a>
      		</li>
      	  </c:forEach>
      </ul>
    </div>
  </div>

  <div class="main">
    <div class="class_type"><img src="images/class_type.gif" alt="新闻中心" /></div>
    <div class="content">
      <ul class="class_date">
      	 <li id='class_month'>
      		<c:forEach items="${tName}" var="tName" end="10"><a href="servlet/index?ntid=${tName.getTid()}"> <b>${tName.gettName()}</b> </a></c:forEach>  	      
		</li>
      	<li id='class_month'>
      		<c:forEach items="${tName}" var="tName" begin="11"><a href="servlet/index?ntid=${tName.getTid()}"> <b>${tName.gettName()}</b> </a></c:forEach>  	
     	 </li> 
      </ul>
      <ul class="classlist">
     
      		<c:forEach items="${mainTitle}" var="mainTitle" varStatus="Status" > 
      			<li><a href="servlet/ContextServlet?nid=${mainTitle.getNid()}">${mainTitle.getnTitle()} </a><span>${mainTitle.getnCreatDate()} </span></li>
      			<c:if test="${Status.count%2==0}"><li class='space'></li></c:if>
      		</c:forEach> 
   
	        <p  style="position: absolute;left:650px; top: 450px;">当前页数:[${pageNum}/${MaxPage}]
		   		<a href="${prePage}">上一页</a>
		   	  	<a href="${nextPage}">下一页</a>
		   	</p>
	     	     		
      </ul>
    </div>   
<div class="picnews">
  <ul>
    <li> <a href="#"><img src="images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
    <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
    <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
    <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
  </ul>
</div>
  </div>
</div>
  <div id="friend">
  <h1 class="friend_t"> <img src="images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">百度</a> </li>
      <li> <a href="#">谷歌</a> </li>
      <li> <a href="#">新浪</a> </li>
      <li> <a href="#">网易</a> </li>
      <li> <a href="#">搜狐</a> </li>
      <li> <a href="#">人人</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 </p>
</div>
</body>
</html>
