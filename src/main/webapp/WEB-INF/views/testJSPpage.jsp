<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>sex</th>
			<th>course_id</th>
			<th>operates</th>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.sex }</td>
				<td>${user.course_id }</td>
				<td><a href="/delUser?id=${user.id}">del</a></td>
			</tr>
		</c:forEach>
	</table>


	<div id="dom1">

	</div>

<script type="text/javascript">
	function test(){
	    $('#dom1').html("<a herf='#'>123456</a>")
	}
	test();

</script>
</body>
</html>