<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			/* 防止提交空白新闻 */
			function check(){
				var ntitle = document.getElementById("ntitle").value;
				var nauthor = document.getElementById("nauthor").value;
				var ncontent = document.getElementById("ncontent").value;
				if(ntitle == ""||nauthor== ""||ncontent== ""){
					alert("请确保,标题,作者,正文都不为空");
					
					return false;
				}
				return true;
			}
			/* 新闻提交确认提示,继续或跳转选择 */
			function subConfirm(add){
				var con=confirm('确认无误后提交新闻');
				if(con==true){
					if(add==null){
						var coj=confirm("提交完成!\n\n  '确定'  继续添加\n\n  '取消'  跳转到新闻编辑页");	
						if(coj==true){
							document.getElementById("action").value="continueToAdd";
						}
						else{
							document.getElementById("action").value="jumpToModify";
						}
					}
					return true;
				}
				return false;
			}
		</script>
	</head>
	<body>
		<div id="header">
		  <div id="welcome">欢迎使用新闻管理系统！</div>
		  <div id="nav">
		    <div id="logo"><a href="servlet/index"><img src="images/logo.jpg" alt="新闻中国" /></a></div>
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
			    <li><a href="servlet/admin">编辑新闻</a></li>
			    <li><a href="topic_add.jsp">添加主题</a></li>
			    <li><a href="servlet/TopicServlet">编辑主题</a></li>
			  </ul>
		  </div>
		  
		  <div id="opt_area">
		    <h1 id="opt_type"> ${aom}新闻： </h1>
		    <form action="servlet/AddNewsServelet"  method="post" onsubmit="return subConfirm(<c:if test='${instance!=null}'>'add'</c:if>)"><!-- ignore this js cannot return error --> <!-- enctype="multipart/form-data" -->
		      <p>
		        <label> 主题 </label>
		        <select name="ntid" id="ntid"  >
			        <c:forEach items="${topic}" var="topic" >
			        	<option value='${topic.getTid()}' <c:if test="${instance!=null&&instance.getNtid()==topic.getTid()}">selected</c:if> >${topic.gettName()}</option>
			        </c:forEach>        
		        </select>
		      </p>
		      <p>
		        <label> 标题 </label>
		        <input name="ntitle" id="ntitle" type="text" class="opt_input" value="${instance.getnTitle()}" />
		      </p>
		      <p>
		        <label> 作者 </label>
		        <input name="nauthor" id="nauthor" type="text" class="opt_input" value="${userID}"/>
		      </p>
		      <p>
		        <label> 摘要 </label>
		        <textarea name="nsummary" id="nsummary" cols="40" rows="3"  >${instance.getnSummary()}</textarea>
		      </p>
		      <p>
		        <label> 内容 </label>
		        <textarea name="ncontent"  id="ncontent" cols="70" rows="10">${instance.getnContent()}</textarea>
		      </p>
		      <p>
		        <label> 上传图片 </label>        
		        <input type="file" name="nfile"/>
		      </p>
		      <input name="action" type="hidden" value="<c:if test='${instance!=null}'>modify</c:if>"/>
		      <input name="nid" type="hidden" value="${nid}" >
		      <input name="noticeNction" type="hidden" id="action" />
		      <input type="submit" value="提交" class="opt_sub" onclick="return check()"/>
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
