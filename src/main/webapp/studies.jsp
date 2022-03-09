<%@ page import="com.ethanedmond.spring.stubs.StudyStub" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Art Studies</title>
</head>
<body>
    <h3>All Studies</h3>
    <a href="/myStudies">Your Studies</a>
    <a href="/addStudy">Create a new Study</a>
    <a href="/myDrawings">Your Drawings</a>
    <ul>
        <c:forEach var="study" items="${allStudies}">
            <li>
              <a href="/study?studyId=${study.getStudyId()}">
                <strong>${study.getTitle()}:</strong>
                ${study.difficultyString()} difficulty
              </a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>