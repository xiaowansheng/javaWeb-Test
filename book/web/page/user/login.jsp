<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会员登录界面</title>
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/login-style.css">
    <script type="text/javascript">
        $(function () {
            $(".btn-login input").click(function () {
                //获取用户名输入框值
                var username=$(".name input").val();
                var password=$(".password input").val();
                var reminder=$(".login .reminder span");
                if(username==null||password==null||username==""||password==""){
                    reminder.text("用户名或密码不能为空。");
                    reminder.css({color:"red"});
                    return false;
                }else{
                    reminder.text("请输入用户名和密码。");
                    reminder.css({color:""});
                }
                $(".login form").submit();
            });
        });
    </script>
</head>

<body>
    <header>
        <div class="ico">
            <a href="">
                <img src="static/img/title.gif"
                     alt="书城">
            </a>
        </div>
    </header>
    <main class="clearfix">
        <div class="main-common w">
            <div class="title">欢迎登录网上书城</div>
            <div class="login">
                <div class="member clearfix">
                    <div class="title">书城会员</div>
                    <div class="register"><a href="page/user/register.jsp">立即注册</a></div>
                </div>
                <div class="reminder"><img src="static/img/reminder.png"><span style="color: <%=request.getAttribute("msg")==null?"":"red"%>" class="reminderSpan">${empty requestScope.msg?"请输入用户名和密码。":requestScope.msg}</span></div>
                <form action="userServlet" method="post">
                    <input type="hidden" name="action" value="login">
                    <div class="name">
                        用户名称：<input type="text" name="username" value="${requestScope.username}">
                    </div>
                    <div class="password">
                        用户密码：<input type="text" name="password" value="${requestScope.password}">
                    </div>
                    <div class="btn-login">
                        <input type="button" value="登录">
                    </div>
                   
                </form>
            </div>
        </div>
    </main>
    <%@include file="../common/footer.jsp"%>
</body>

</html>