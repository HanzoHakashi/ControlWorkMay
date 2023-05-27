<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Task</title>
</head>
<body>
<h1>Create Task</h1>
<form action="/tasks/new" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="hidden" name="status" value="CREATED">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div>
        <label for="developerId">Developer:</label>
        <select id="developerId" name="developerId" required>
            <#list developers as developer>
            <option value="${developer.id}">${developer.name}</option>
        </#list>
        </select>
    </div>

        <button type="submit">Create Task</button>
    </div>
</form>
</body>
</html>