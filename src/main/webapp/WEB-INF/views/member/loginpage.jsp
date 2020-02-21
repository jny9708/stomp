<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<c:url value='/login'/>" method="post">
           <input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
                    <input class="form-control" type="text" placeholder="사용자아이디" name="userid">
                  
               
                    <input class="form-control" type="password" placeholder="비밀번호" name="password">
            
              <button class="btn btn-primary btn-block">로그인</button>
            
          </form>

</body>
</html>