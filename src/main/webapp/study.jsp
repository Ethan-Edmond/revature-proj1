<%@ page import="com.ethanedmond.spring.stubs.StudyStub" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Study Details</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header class="clean">
        <h3>${study.getTitle()}</h3>
        <nav>
            <a href="/myStudies">Your Studies</a>
            <a href="/studies">All Studies</a>
            <a href="/myDrawings">Your Drawings</a>
        </nav>
    </header>
    <main class="study">
        <div class="difficulty">
            <p>Difficulty: ${study.difficultyString()}</p>
            <form action="rateDifficulty?studyId=${study.getStudyId()}" method="post">
                <input type="range" name="difficulty" min="0" max="5" step="1"/>
                <input class="submit" type="submit" value="Rate difficulty"/>
            </form>
        </div>
        <div class="tags">
            <p>Tags:</p>
            <ul>
                <c:forEach var="tag" items="${tags}">
                    <li>${tag.getName()}</li>
                </c:forEach>
            </ul>
            <form action="addTag?studyId=${study.getStudyId()}" method="post">
                <input class="field" type="text" name="name" placeholder="Enter a tag!"/>
                <input class="submit" type="submit" value="Add tag"/>
            </form>
        </div>
        <div class="references">
            <p>References:</p>
            <ul>
                <c:forEach var="reference" items="${referenceImages}">
                    <li>
                        <img src="${reference.getImageLink()}"/>
                    </li>
                </c:forEach>
            </ul>
            <form action="addReference?studyId=${study.getStudyId()}" method="post" enctype="multipart/form-data">
                <input class="fileUpload" type="file" name="image" accept="image/jpeg, image/png" size="10485760"/>
                <input class="submit" type="submit" value="Submit reference image"/>
            </form>
        </div>
        <div class="drawings">
            <p>Drawings:</p>
            <ul>
                <c:forEach var="drawing" items="${drawings}">
                    <li>
                        <img src="${drawing.getImageLink()}"/>
                    </li>
                </c:forEach>
            </ul>
            <a href="/draw?studyId=${study.getStudyId()}&referenceIndex=0">Start drawing!</a>
        </div>
    </main>
</body>
</html>