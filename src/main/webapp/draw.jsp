<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Draw Reference Image ${referenceIndex + 1}</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header class="clean">
        <nav>
            <a href="/study?studyId=${studyId}">Back To Study</a>
            <a href="/myStudies">Your Studies</a>
            <a href="/studies">All Studies</a>
            <a href="/myDrawings">Your Drawings</a>
        </nav>
    </header>
    <main class="drawingCard">
        <img src="${referenceImageLink}"/>
        <div class="drawNav">
            <c:if test="${referenceIndex != 0}">
                <a href="/draw?studyId=${studyId}&referenceIndex=${referenceIndex - 1}">Prev Drawing</a>
            </c:if>
            <c:choose>
                <c:when test="${referenceIndex < (referenceCount - 1)}">
                    <a href="/draw?studyId=${studyId}&referenceIndex=${referenceIndex + 1}">Next Drawing</a>
                </c:when>
                <c:otherwise>
                    <a href="/study?studyId=${studyId}">Finish Drawing</a>
                </c:otherwise>
            </c:choose>
        </div>
        <form action="addDrawing?studyId=${studyId}&referenceIndex=${referenceIndex + 1}" method="post" enctype="multipart/form-data">
            <input class="fileUpload" type="file" name="image" accept="image/jpeg, image/png" size="10485760"/>
            <input class="submit" type="submit" value="Submit"/>
        </form>
    </main>
</body>
</html>