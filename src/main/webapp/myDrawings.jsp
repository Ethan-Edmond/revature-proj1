<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Drawings</title>
</head>
<body>
    <h3>Your Drawings</h3>
    <a href="/myStudies">Back to Your Studies</a>
    <ul>
        <c:forEach var="drawing" items="${myDrawings}">
            <li>
                <img src="${drawing.getImageLink()}"/>
                <form action="deleteDrawing" method="post">
                    <input type="hidden" name="drawingId" value="${drawing.getDrawingId()}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>