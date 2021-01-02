<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h2>데이터베이스 연동(고급)</h2>
	<ul>
		<li>
			<a href="${pageContext.request.contextPath }/professor/list.do">
				교수관리 웹페이지</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/professor_ajax/list.do">
				교수관리 웹페이지(Ajax)</a>
		</li>
	</ul>
</body>
</html>
