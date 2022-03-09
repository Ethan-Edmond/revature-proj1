<%@ page import="com.ethanedmond.spring.stubs.StudyStub" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Study Details</title>
</head>
<body>
    <h3>${study.getTitle()}</h3>
    <p>difficulty: ${study.difficultyString()}</p>
    <form action="rateDifficulty" method="post">
        <input type="range" name="difficulty" min="0" max="5" step="1"/>
        <input type="submit" value="Rate difficulty"/>
    </form>
    <ul><li>Implement Tags!</li></ul>
    <form action="addTag" method="post">
        <input type="text" name="tag"/>
        <input type="submit" value="Add tag"/>
    </form>
    <ul><li>Implement Reference images</li></ul>
    <form action="addReference" method="post">
        <input type="file" name="image"/>
        <input type="submit" value="Submit reference image"/>
    </form>
    <ul><li>Implement Resultant Drawing images</li></ul>
    <a href="/draw">Start drawing!</a>
</body>
</html>