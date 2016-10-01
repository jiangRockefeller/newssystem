<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>新闻发布系统管理后台</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function check(){
				var tname = document.getElementById("tname");
		
				if(tname.value == ""){
					alert("请输入主题名称！！");
					tname.focus();
					return false;
				}
				var coj=confirm("添加完成!\n\n  '确定'  继续添加\n\n  '取消'  跳转到主题编辑页");	
				if(coj==true){
					document.getElementById("action").value="continueToAdd";
				}
				else{
					document.getElementById("action").value="jumpToModify";
				}	
				return true;
			}
		</script>
	</head>
	<body>
		<div id="header">
		  <div id="welcome">欢迎使用新闻管理系统！</div>
		  <div id="nav">
		    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
		    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
		  </div>
		</div>
		<div id="admin_bar">
		  <div id="status">管理员：&nbsp;${userID}&#160;&#160;&#160;&#160; <a href="servlet/admin?logout=true">login out</a></div>
		  <div id="channel"> </div>
		</div>
		<div id="main">
		  <div id="opt_list">
		  <ul>
		    <li><a href="servlet/AddNewsServelet">添加新闻</a></li>
		    <li><a href="admin.jsp">编辑新闻</a></li>
		    <li><a href="#">添加主题</a></li>
		    <li><a href="servlet/TopicServlet">编辑主题</a></li>
		  </ul>
		</div>
		
		  <div id="opt_area">
		    <h1 id="opt_type"> 添加主题： </h1>
		    <form action="servlet/AddTopicServlet" method="post" onsubmit="return check()">
		      <p>
		        <label> 主题名称 </label>
		        <input name="tname" type="text" class="opt_input" id="tname"/>
		      </p>
		      <input name="action" type="hidden" id="action" />
		      <input type="submit" value="提交" class="opt_sub" />
		      <input type="reset" value="重置" class="opt_sub" />
		    </form>
		  </div>
		</div>
		<div id="footer">
		  <div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
		<div id="footer">
		  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
		    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
		  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
		    新闻中国   版权所有</p>
		</div>
	</body>
</html>
