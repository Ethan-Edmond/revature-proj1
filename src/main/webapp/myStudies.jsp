<%@ page import="com.ethanedmond.spring.stubs.StudyStub"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Art Studies</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header class="clean">
        <h3>Your Studies</h3>
        <nav>
            <a href="/studies">All Studies</a>
            <a href="/addStudy">Add a Study</a>
            <a href="/myDrawings">Your Drawings</a>
        </nav>
    </header>
    <main class="centered withHeader">
        <div class="clean inCenter">
            <ul>
                <c:forEach var="study" items="${myStudies}">
                    <li>
                        <a href="/study?studyId=${study.getStudyId()}">${study.getTitle()}</a>
                        ${study.difficultyString()} difficulty
                    </li>
                </c:forEach>
            </ul>
        </div>
    </main>
</body>
</html>