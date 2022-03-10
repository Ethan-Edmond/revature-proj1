<%@ page import="com.ethanedmond.spring.stubs.StudyStub" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Study Details</title>
</head>
<body>
    <h3>${study.getTitle()}</h3>
    <a href="/myStudies">Back to My Studies</a>
    <p>difficulty: ${study.difficultyString()}</p>
    <form action="rateDifficulty?studyId=${study.getStudyId()}" method="post">
        <input type="range" name="difficulty" min="0" max="5" step="1"/>
        <input type="submit" value="Rate difficulty"/>
    </form>
    <ul>
        <c:forEach var="tag" items="${tags}">
            <li>${tag.getName()}</li>
        </c:forEach>
    </ul>
    <form action="addTag?studyId=${study.getStudyId()}" method="post">
        <input type="text" name="name"/>
        <input type="submit" value="Add tag"/>
    </form>

    <ul>
        <c:forEach var="reference" items="${referenceImages}">
            <li>
                <img src="${reference.getImageLink()}"/>
            </li>
        </c:forEach>
    </ul>
    <form action="addReference?studyId=${study.getStudyId()}" method="post" enctype="multipart/form-data">
        <input type="file" name="image" accept="image/jpeg, image/png" size="10485760"/>
        <input type="submit" value="Submit reference image"/>
    </form>
    <ul>
        <c:forEach var="drawing" items="${drawings}">
            <li>
                <img src="${drawing.getImageLink()}"/>
            </li>
        </c:forEach>
    </ul>
    <a href="/draw?studyId=${study.getStudyId()}&referenceIndex=0">Start drawing!</a>
</body>
</html>