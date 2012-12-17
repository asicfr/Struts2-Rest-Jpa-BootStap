<%-- List screen for Customer entity      --%>
<%-- Created on 17 déc. 2012 ( Time 15:40:00 )  --%>



<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
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
          <a class="brand" href="#">Customers List</a>
          <input type="button" class="btn btn-info" value="All" 	 onclick="directGet('search')" />
          <input type="button" class="btn btn-info" value="Back to Welcome Page" 	 onclick="goHome()" />
        </div>
      </div>
    </div>

    <div class="container">
		      
		<table  class="table table-bordered">
		<thead>
			<tr>
				<th><s:property value="getText('current.code')" /></th> 
				<th><s:property value="getText('current.countryCode')" /></th> 
				<th><s:property value="getText('current.firstName')" /></th> 
				<th><s:property value="getText('current.lastName')" /></th> 
				<th><s:property value="getText('current.login')" /></th> 
				<th><s:property value="getText('current.password')" /></th> 
				<th><s:property value="getText('current.age')" /></th> 
				<th><s:property value="getText('current.city')" /></th> 
				<th><s:property value="getText('current.zipCode')" /></th> 
				<th><s:property value="getText('current.phone')" /></th> 
				<th><s:property value="getText('current.reviewer')" /></th> 
				<th><a class="btn btn-info" href="<s:url value="/customer/clear/" />">new</a></th> 
			</tr>
		</thead>
		<tbody>
			<s:iterator value="searchResult" >
				<tr>

					<td><s:property value="code" /></td>

					<td><s:property value="countryCode" /></td>

					<td><s:property value="firstName" /></td>

					<td><s:property value="lastName" /></td>

					<td><s:property value="login" /></td>

					<td><s:property value="password" /></td>

					<td><s:property value="age" /></td>

					<td><s:property value="city" /></td>

					<td><s:property value="zipCode" /></td>

					<td><s:property value="phone" /></td>

					<td><s:property value="reviewer" /></td>

				<td><a class="btn btn-info" href="<s:url value="/customer/load/%{code}" />" >edit</a> </td>
					
				</tr> 
			</s:iterator>
				<tr>
					<td colspan="11">
						<s:actionerror/>
						<s:actionmessage/>
						<s:fielderror/>
					</td>
				</tr>
		</tbody>
		</table>
		      

    </div> <!-- /container -->


    <script src="<s:url value='/static/javascript/jquery.js' includeParams='none'/>" ></script>
    <script src="<s:url value='/static/javascript/bootstrap.min.js' includeParams='none'/>" ></script>
	<script src="<s:url value='/static/javascript/validation.js' includeParams='none'/>" ></script>
	
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

