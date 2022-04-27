<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>List Customers</title>

<!-- reference our css (cascade style sheet) -->

	<link type="text/css" rel="stylesheet" 
	      href="${pageContext.request.contextPath}/resources/css/style.css">
																<!--Our Style Sheet "style.css"  -->
</head>

<body>

 <div id="wrapper">
 	<div id="header">
 		<h2>CRM - Customer Relationship Manager</h2>
 	</div>
 </div>
 
 <div id="container">
 
 <div id="content">
 
 		<!-- put new button: Add Customer -->
 		
 		<input type="button" value="Add Customer"
 			   onclick="window.location.href='showFormForAdd'; return false;"
 			   class="add-button" /> <!-- add-button is css style -->
 			   
 		<!-- add our html table here -->
 		
 		<table>
 		<!-- table row -->
 		<tr>
 			<!-- table heading -->
 			<th>First Name</th>  
 			<th>Last Name</th> 
 			<th>Email</th> 
 			<th>Action</th>
 		</tr>
 		
 		<!-- loop over and print our customers -->
 		<c:forEach 	var="tempCustomer" items="${customers}"> <!-- customers is attribute name in CustomerController -->
 		
 		<!-- construct an "update" link with customer id -->
 		<c:url var="updateLink" value="/customer/showFormForUpdate">
 		<c:param name="customerId" value="${tempCustomer.id}" />
 		</c:url>
 		
 		<tr>
 			<td> ${tempCustomer.firstName}</td>  <!-- Will call tempCustomer.getFirstName() method -->
 			<td> ${tempCustomer.lastName}</td>
 			<td> ${tempCustomer.email}</td>
 			
 			<td>
 			<!-- display the update link -->
 			<a href="${updateLink}">Update</a>
 			
 			</td>
 			
 			
 		</tr>
 		
 		
 		
 		</c:forEach>
 		
 		
 		
 		
 		</table>
 		
 
 </div>
 	
 </div>

</body>


</html>