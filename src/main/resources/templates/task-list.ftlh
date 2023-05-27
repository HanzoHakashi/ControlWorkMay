<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Task List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid justify-content-start">
            <#if isAuthenticated>
            <a class="btn btn-outline-danger me-2" type="button" href="/logout">Logout</a>
            <#if isManager>
            <a class="btn btn-primary me-2" type="button" href="/create-task">Create Task</a>
        </#if>
        <#else>
        <a class="btn btn-outline-success me-2" type="button" href="/login">Login</a>
    </#if>
    </div>
    </nav>
</header>
<div class="container"><h1>Task List</h1>
    <table  class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Creation Date</th>
            <th>Developer</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <#list tasks.content as task>
        <tr>
            <td>${task.name}</td>
            <td>${task.creationDate}</td>
            <td>${task.developerId.name}</td>
            <td>${task.status}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center" id="pagination">
        </ul>
    </nav></div>

<script type="module" src="script.js"></script>
</body>
</html>