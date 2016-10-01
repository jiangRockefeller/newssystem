<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
<title>新闻浏览评论页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	function checkComment(){
		var cauthor = document.getElementById("cauthor");
		var content = document.getElementById("ccontent");
		if(cauthor.value == ""){
			alert("用户名不能为空！！");
			return false;
		}else if(content.value == ""){
			alert("评论内容不能为空！！");
			return false;
		}
		return true;
	}
	function clearAuthor(){
		if(document.getElementById("cauthor").value="这家伙很懒什么也没留下"){
			
			document.getElementById("cauthor").value="";
		}
		
	}
	function aTips(){
		var author=document.getElementById("cauthor").value;
		if(author==""){
		document.getElementById("cauthor").value="这家伙很懒什么也没留下";
		}
	}
</script>
</head>


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
    <div class="class_type"> <a href="servlet/index" ><img src="images/class_type.gif" alt="新闻中心" /></a> </div>
    <div class="content">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${context.getnTitle()}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">作者：${context.getnAuthor()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </a></td>
            <td align="left">发布时间：${context.getnCreatDate()}</td>
          </tr>          
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2">
            	${context.getnContent()}
			</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      
      <ul class="classlist">
        <table width="80%" align="center">
        <c:forEach items="${comments}" var="comments">
        	<tr>
            <td align="center">读者：${comments.getcAuthor()}&nbsp;&nbsp;&nbsp;IP:${comments.getCIP()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td align="left">发表于：${comments.getcDate()}</td>
          </tr>
        	<td colspan="6">${comments.getcContent()}</td>
	          <tr>
	            <td colspan="6"><hr />
	            </td>
	          </tr>
     	</c:forEach>
        </table>
      </ul>
      
      
      <ul class="classlist">
        <form action="servlet/ContextServlet" method="post" onSubmit="return checkComment()">
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td> 用户名： </td>
              <td>
              	 
	            	<input name="cnid" type="hidden" value="${cnid}" />
	              <input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下" onclick="clearAuthor()" onblur="aTips()"/>
	            
                IP：
                <input name="cip" id="cip" value="${cIP}" readonly="readonly" style="border:0px;"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" id="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
        </form>
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
