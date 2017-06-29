<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>Seyahat Tanımlama</title>

    <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/jquery/css/jquery-ui.css">


    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-1.12.4.js"></script>
    <script src="${contextPath}/resources/jquery/js/jquery-ui.js"></script>
    <script src="${contextPath}/resources/jquery/i18n/datepicker-tr.js"></script>

    <script>
        $( function() {
            $( "#beginTime" ).datepicker({
//                dateFormat: 'dd/mm/yy',
                showOn:'both',
                changeMonth:true,
                changeYear:true,
            });
            $( "#endTime" ).datepicker({
                showOn:'both',
//                dateFormat: 'dd/mm/yy',
                changeMonth:true,
                changeYear:true,
            });
        } );
    </script>
</head>
<body>

<br/><br/><br/><br/><br/>
<div class="container">
    <div class="col-lg-8 col-lg-offset-2">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Seyahat Detayı</strong>
                </div>
                <div class="panel-body">
                    <form:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/insert" modelAttribute="newTravel">
                        <!-- need to associate this data with customer id -->
                        <%--<form:hidden path="id" />--%>
                        <div class="form-group">
                            <label class="col-sm-4 col-md-3 col-lg-3 control-label">Gidiş Yeri</label>
                            <div class="col-sm-8 col-md-6 col-lg-5">
                                <form:input type="text" class="form-control" id="username" path="destination"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 col-md-3 col-lg-3 control-label">Amaç</label>
                            <div class="col-sm-8 col-md-6 col-lg-5">
                                <form:input type="text" class="form-control" id="password" path="purpose"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 col-md-3 col-lg-3 control-label">Proje Kodu</label>
                            <div class="col-sm-8 col-md-6 col-lg-5">
                                <form:input type="text" class="form-control" id="password" path="projectCode"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-4 col-md-3 col-lg-3 control-label">Seyahat Başlangıcı</label>
                            <div class="col-sm-8 col-md-6 col-lg-5">
                                <form:input type="text" id="beginTime" path="beginTime"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-4 col-md-3 col-lg-3 control-label">Seyahat Sonu</label>
                            <div class="col-sm-8 col-md-6 col-lg-5">
                                <form:input type="text" id="endTime" path="endTime" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-md-offset-3 col-lg-offset-3 col-sm-8 col-md-9 col-lg-9">
                                <button type="submit" class="btn btn-primary">İptal</button>
                                <button type="submit" class="btn btn-primary">Kaydet</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
