<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Drawings</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header class="clean">
        <h3>Your Drawings</h3>
        <nav>
            <a href="/myStudies">Your Studies</a>
            <a href="/studies">All Studies</a>
            <a href="/addStudy">Add a Study</a>
        </nav>
    </header>
    <main class="drawingContainer">
        <ul>
            <c:forEach var="drawing" items="${myDrawings}">
                <li class="drawingCard">
                    <img src="${drawing.getImageLink()}"/>
                    <form action="deleteDrawing" method="post">
                        <input type="hidden" name="drawingId" value="${drawing.getDrawingId()}"/>
                        <input class="submit" type="submit" value="Delete"/>
                    </form>
                </li>
            </c:forEach>
        </ul>
    </main>
</body>
</html>