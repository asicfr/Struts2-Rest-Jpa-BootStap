<%-- Detail screen for Customer entity      --%>
<%-- Created on 29 nov. 2012 ( Time 10:46:26 )  --%>



<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>CustomerStore</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Customer">
<meta name="author" content="asic">

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
          <a class="brand" href="#">Customer</a>
          <input type="button" class="btn btn-info" value="All" 	 onclick="directGet('search')" />
          <input type="button" class="btn btn-info" value="Back to Welcome Page" 	 onclick="goHome()" />
        </div>
      </div>
    </div>

    <div class="container">
      
		<s:form name="customerForm" action="customer" cssClass="well">  
		
			<s:textfield name="current.code"      		label="code" />
			<s:textfield name="current.countryCode"      		label="countryCode" />
			<s:textfield name="current.firstName"      		label="firstName" />
			<s:textfield name="current.lastName"      		label="lastName" />
			<s:textfield name="current.login"      		label="login" />
			<s:textfield name="current.password"      		label="password" />
			<s:textfield name="current.age"      		label="age" />
			<s:textfield name="current.city"      		label="city" />
			<s:textfield name="current.zipCode"      		label="zipCode" />
			<s:textfield name="current.phone"      		label="phone" />
			<s:textfield name="current.reviewer"      		label="reviewer" />
			
			<tr>
			<td colspan="2">
				<s:actionmessage/>
				<s:actionerror/>
				<s:fielderror/>
			</td>
			</tr>
			
			<tr>
			<td colspan="2">
			 	<input type="button" class="btn btn-info" value="Save"   onclick="changeActionAndsubmit('save')"   />
			 	<input type="button" class="btn btn-info" value="Delete" onclick="directDelete('<s:property value="#attr.current.code" />')" />

			 	<input type="button" class="btn btn-info" value="Clear"  onclick="directGet('clear')"  />
			 	<input type="button" class="btn btn-info" value="Search" onclick="changeActionAndsubmit('search')" />
			 	<input type="button" class="btn btn-info" value="All" 	 onclick="directGet('search')" />
			</td>
			</tr>
			 
		</s:form>	
		      

    </div> <!-- /container -->


    <script src="<s:url value='/static/javascript/jquery.js' includeParams='none'/>"></script>
    <script src="<s:url value='/static/javascript/bootstrap.min.js' includeParams='none'/>"></script>
	<script src="<s:url value='/static/javascript/validation.js' includeParams='none'/>"></script>
	
	<script type="text/javascript">
		
		var urlBaseWelcome = '<s:url value="/" />';
		var urlBase = '<s:url action="customer" includeParams="none" />';
		
		function changeActionAndsubmit(url) {
			document.customerForm.action = urlBase + '/' + url;
		    document.customerForm.submit();
		}
		
		function directDelete(idcustomer) {
			document.location = urlBase + '/delete/' + idcustomer;
		}
		
		function directGet(url) {
			document.location = urlBase + '/' + url;
		}
		
		function goHome() {
			document.location = urlBaseWelcome;
		}
		
	</script>

  </body>
</html>
