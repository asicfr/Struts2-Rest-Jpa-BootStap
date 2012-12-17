<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.telosys.starterkits.strutsjpa.EntityManagerHelper"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Liste des entit&#233;s g&#233;r&#233;es</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="BookStore">
<meta name="author" content="asic">
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>">

<!-- Le styles -->
<link href="<s:url value='/static/css/bootstrap.min.css' includeParams='none'/>" rel="stylesheet" />
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="<s:url value='/static/css/bootstrap-responsive.min.css' includeParams='none'/>" rel="stylesheet" />
<link href="<s:url value='/static/css/styles.css' includeParams='none'/>" rel="stylesheet" />
</head>

<body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Liste des entit&#233;s g&#233;r&#233;es</a>
        </div>
      </div>
    </div>

    <div class="container">
      
		<ul>
		    <%
			    for (String entite : EntityManagerHelper.getEntityList()) {
			        out.println("<li><a href=\"" + entite + "/search\">" + entite + "</a></li>");
				}
		    %>
	    </ul>

    </div> <!-- /container -->

    <script src="<s:url value='/static/javascript/jquery.js' includeParams='none'/>"></script>
    <script src="<s:url value='/static/javascript/bootstrap.min.js' includeParams='none'/>"></script>
	<script src="<s:url value='/static/javascript/validation.js' includeParams='none'/>"></script>
	
</body>
</html>