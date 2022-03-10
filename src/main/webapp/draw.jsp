<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Draw Reference Image ${referenceIndex + 1}</title>
</head>
<body>
    <a href="/study?studyId=${studyId}">Back To Study</a>
    <img src="${referenceImageLink}"/>
    <c:if test="${referenceIndex != 0}">
        <a href="/draw?studyId=${studyId}&referenceIndex=${referenceIndex - 1}">Prev</a>
    </c:if>
    <c:choose>
        <c:when test="${referenceIndex < (referenceCount - 1)}">
            <a href="/draw?studyId=${studyId}&referenceIndex=${referenceIndex + 1}">Next</a>
        </c:when>
        <c:otherwise>
            <a href="/study?studyId=${studyId}">Finish</a>
        </c:otherwise>
    </c:choose>
        <form action="addDrawing?studyId=${studyId}&referenceIndex=${referenceIndex + 1}" method="post" enctype="multipart/form-data">
            <input type="file" name="image" accept="image/jpeg, image/png" size="10485760"/>
            <input type="submit" value="Submit reference image"/>
        </form>
</body>
</html>