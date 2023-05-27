<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
</head>
<body>
<div class="container">
    <h1>Edit Task</h1>
    <form action="/tasks/update" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="hidden" name="id" value="${task.id}">
        <div class="mb-3">
            <label for="status">Status</label>
            <select class="form-control" id="status" name="status">
                <#list taskStatusList as status>
                <option value="${status}" <#if status == task.status>selected</#if>>${status}</option>
        </#list>
        </select>
</div>
<div class="mb-3">
    <label for="logs">Logs</label>
    <table class="table" id="logsTable">
        <thead>
        <tr>
            <th>Time</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <#list workLogs as workLog>
        <tr>
            <td>${workLog.time}</td>
            <td>${workLog.description}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<div class="mb-3">
    <label for="newLogDescription">New Log Description</label>
    <input type="text" class="form-control" id="newLogDescription" name="newLogDescription">
</div>
<#if task.attachment?has_content>
<div class="mb-3">
    <label for="attachment">Attachment</label>
    <a href="${task.attachment}" download>Download Attachment</a>
</div>
</#if>

<button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>


</body>
</html>