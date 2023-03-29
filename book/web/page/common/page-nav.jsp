<%--
  Created by IntelliJ IDEA.
  User: LDQ
  Date: 2020/8/18
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="paging-nav">
    <ul>
        <li><a href="${requestScope.page.url}&pageNo=1">首页</a></li>
        <li><a id="pre" href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a></li>
        <%--                    <li><a class="page" href="#">1</a></li>--%>
        <%--                    <li><a class="page" href="#">2</a></li>--%>
        <li><a class="page" href="javascript:;">【${requestScope.page.pageNo}】</a></li>
        <%--                    <li><a class="page" href="#">4</a></li>--%>
        <%--                    <li><a class="page" href="#">5</a></li>--%>
        <li><a id="next" href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a></li>
        <li><a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">尾页</a></li>
        <li>共<span class="pageNumber">${requestScope.page.pageTotal}</span>页</li>
        <li>共<span class="total">${requestScope.page.dataTotal}</span>条记录</li>
        <li class="clearfix">到 <input type="text" name="page" value="${requestScope.page.pageNo}"> 页 <a href="javascript:;" onclick="skip()" oninput="value=value.replace(/[^\d]/g,'')" id="skip">跳转</a></li>
    </ul>
</div>
