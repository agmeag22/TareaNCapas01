<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Library</title>
<style>
	.container{
	flex: display;
	align-items:center;
	align-content: center;
	margin-top: 30px;
	}
    .table-bordered{
    border-radius: 4px;
    }
    
    
    /*.hiyo{
    width:50%;
    height: 10%;}*/
    
  
	    
</style>
</head>
<body>
	
	<div class="container">
	<p style="text-align:center;">${message}</p>
	<table class="table table-bordered table-sm">
		<thead class="thead-dark">
		<tr>
		<th scope="col">Titulo</th>
      	<th scope="col">Autor</th>
      	<th scope="col">ISBN</th>
      	<th scope="col">Cantidad en Existencias</th>
		</tr>
		</thead>
			<c:forEach items="${books}" var="books">
				<tr>
					<td>${books.titlen}</td>
					<td>${books.authorn}</td>
					<td>${books.isbnn}</td>
					<td>${books.stockn}</td>
				</tr>	
			</c:forEach>
	</table>
	</div>
	</body>
</html>