<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>
<body>
    <h2>${message}</h2>
    <h1>
        <c:forEach var="item" items="${list}" >
            ${item}
        </c:forEach>
    </h1>
</body>
</html>