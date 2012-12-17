<%-- List screen for BookOrder entity      --%>
<%-- Created on 17 déc. 2012 ( Time 14:48:55 )  --%>



<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>BookOrderStore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="BookOrder">
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
          <a class="brand" href="#">BookOrders List</a>
          <input type="button" class="btn btn-info" value="All" 	 onclick="directGet('search')" />
          <input type="button" class="btn btn-info" value="Back to Welcome Page" 	 onclick="goHome()" />
        </div>
      </div>
    </div>

    <div class="container">
		      
		<table  class="table table-bordered">
		<thead>
			<tr>
				<th><s:property value="getText('current.id')" /></th> 
				<th><s:property value="getText('current.shopCode')" /></th> 
				<th><s:property value="getText('current.customerCode')" /></th> 
				<th><s:property value="getText('current.employeeCode')" /></th> 
				<th><s:property value="getText('current.date')" /></th> 
				<th><s:property value="getText('current.state')" /></th> 
				<th><a class="btn btn-info" href="<s:url value="/bookorder/clear/" />">new</a></th> 
			</tr>
		</thead>
		<tbody>
			<s:iterator value="searchResult" >
				<tr>

					<td><s:property value="id" /></td>

					<td><s:property value="shopCode" /></td>

					<td><s:property value="customerCode" /></td>

					<td><s:property value="employeeCode" /></td>

					<td><s:property value="date" /></td>

					<td><s:property value="state" /></td>

				<td><a class="btn btn-info" href="<s:url value="/bookorder/load/%{id}" />" >edit</a> </td>
					
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
		var urlBase = '<s:url action="bookorder" includeParams="none" />';
		
		function changeActionAndsubmit(url) {
			document.bookorderForm.action = urlBase + '/' + url;
		    document.bookorderForm.submit();
		}
		
		function directDelete(idbookorder) {
			document.location = urlBase + '/delete/' + idbookorder;
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

