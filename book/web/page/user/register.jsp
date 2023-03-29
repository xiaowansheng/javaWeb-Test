<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会员注册界面</title>
    <base href="http://localhost:8080/book/">
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/register-style.css">
    <script type="text/javascript" src="static/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".btn-register input").click(function () {
                //获取提示框对象
                var reminder=$(".reminder");
                //获取用户框输入的内容
                var username=$(".name input").val();
                //创建正则表达式验证
                //用户名由字母数字下划线组成,长度5-12
                var usernamePatt=/^\w{5,12}$/;
                if(!usernamePatt.test(username)){
                    reminder.text("用户名格式错误.");
                    return false;
                }
                //获取密码框输入的值
                var password=$(".password input").val();
                //创建正则表达式验证
                //密码由字母数字下划线组成,长度5-12
                var passwordPatt=/^\w{5,12}$/;
                if(!passwordPatt.test(password)){
                    reminder.text("密码格式错误.");
                    return false;
                }
                //验证两次密码是否相同
                var passwoordTwo=$(".confirm-password input").val();
                if(password!==passwoordTwo){
                    reminder.text("两次密码不一致。")
                    return false;
                }
                //获取邮箱输入框值
                var email=$(".email input").val();
                //创建邮箱验证的正则表达式
                //xxxxx@xxx.com
                var emailPatt=/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                if(!emailPatt.test(email)){
                    reminder.text("邮箱格式不正确");
                    return  false;
                }
                //获取验证码输入框值
                var verificationCode=$(".verify input").val().trim();//去除前后空格
                if(verificationCode===null||verificationCode===""){
                    reminder.text("验证码不能为空。");
                    return  false;
                }
                reminder.text("");
                //页面跳转
                // window.location.href="page/register-success.jsp";
                //提交表单
                $(".register form").submit();
            });
            $("#code").click(function () {
                this.src="kaptcha.jpg?d="+new Date();
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
            <div class="title">欢迎注册网上书城</div>
            <div class="register">
                <div class="head">
                    <div class="title">书城会员</div>
                    <div class="reminder">${requestScope.msg}</div>
                </div>

                <form action="userServlet" method="post">
                    <input type="hidden" name="action" value="register">
                    <div class="name">
                        用户名称：<input type="text" name="username" value="${requestScope.username}">
                    </div>
                    <div class="password">
                        用户密码：<input type="text" name="password" value="${requestScope.password}">
                    </div>
                    <div class="confirm-password">
                        确认密码：<input type="text">
                    </div>
                    <div class="email">
                        电子邮箱：<input type="text" name="email" value="${requestScope.email}">
                    </div>
                    <div class="verify">
                        验证码：<input type="text" name="verificatiionCode"><div class="img"><img id="code" src="kaptcha.jpg"></div>
                    </div>
                    <div class="btn-register">
                        <input type="button" value="注册">
                    </div>
                   
                </form>
            </div>
        </div>
    </main>
    <%@include file="../common/footer.jsp"%>
</body>

</html>