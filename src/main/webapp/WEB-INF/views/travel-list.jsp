<%--
  Created by IntelliJ IDEA.
  User: cihangir
  Date: 6/12/17
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/jquery/css/jquery-ui.css">

    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-1.12.4.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-ui.js"></script>
    <script src="${contextPath}/resources/jquery/i18n/datepicker-tr.js"></script>


    <%--<script>--%>
        <%--$( function() {--%>
            <%--$( "#datepicker1" ).datepicker({ dateFormat: 'dd-mm-yy' });--%>
            <%--$( "#datepicker2" ).datepicker({ dateFormat: 'dd-mm-yy' });--%>
        <%--} );--%>
    <%--</script>--%>


    <script>
        $( function() {
            $( "#datepicker1" ).datepicker({
//                dateFormat: 'dd/mm/yy',
                showOn:'both',
                changeMonth:true,
                changeYear:true,
            });
            $( "#datepicker2" ).datepicker({
                showOn:'both',
//                dateFormat: 'dd/mm/yy',
                changeMonth:true,
                changeYear:true,
            });
        } );
    </script>


    <style>
        #datatable{
            margin-top: 50px;
            margin-left: 30px;
            margin-right: 30px;
        }

        #add{
            margin-top: 30px;
            margin-bottom: 2px;
            margin-right: 20px;
        }

        #welcomeUser{
            margin-left: 1425px;
            margin-top:10px;
        }

    </style>
</head>
<body>

<br/><br/><br/><br/><br/>
<div class="container">
    <div class="row">
        <form class="form-inline" action="${contextPath}/search">
            <div class="form-group">
                <input type="text" id="datepicker1" name="datepicker1" placeholder="Başlangıç">
            </div>
            <div class="form-group">
                <input type="text" id="datepicker2" name="datepicker2" placeholder="Bitiş">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </div>
        </form>
    </div>
    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Destination/th>
                <th>Purpose</th>
                <th>Project Code</th>
                <th>Begin Time</th>
                <th>End time</th>
            </tr>
            </thead>
            <tbody>
                <!-- loop over and print our customers -->
                <c:forEach items="${travels}" var="travel">
                        <%--<!-- construct an "update" link with user id -->--%>
                        <%--<c:url var="updateLink" value="${contextPath}/admin/showFormForEdit">--%>
                            <%--<c:param name="userId" value="${user.id}" />--%>
                        <%--</c:url>--%>

                        <%--<!-- construct an "delete" link with user id -->--%>
                        <%--<c:url var="deleteLink" value="${contextPath}/admin/deleteUser">--%>
                            <%--<c:param name="userId" value="${user.id}" />--%>
                        <%--</c:url>--%>

                        <tr>
                            <td>
                                <c:out value="${travel.destination}" />
                            </td>
                            <td>
                                <c:out value="${travel.purpose}" />
                            </td>
                            <td>
                                <c:out value="${travel.projectCode}" />
                            </td>
                            <td>
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${travel.beginTime}" />
                            </td>
                            <td>
                                <fmt:formatDate pattern = "dd-MM-yyyy" value = "${travel.endTime}" />
                            </td>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
