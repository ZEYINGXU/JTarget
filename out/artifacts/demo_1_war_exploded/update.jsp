<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">Modify user</h3>
    <form action="" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly" placeholder="Please enter name" />
        </div>

        <div class="form-group">
            <label>Gender:</label>
                <c:if test="${user.gender == 'male'}">
                    <input type="radio" name="gender" value="male" checked />male
                    <input type="radio" name="gender" value="female"  />female
                </c:if>

                <c:if test="${user.gender == 'female'}">
                    <input type="radio" name="gender" value="male"  />male
                    <input type="radio" name="gender" value="female" checked  />female
                </c:if>
        </div>

        <div class="form-group">
            <label for="age">Age:</label>
            <input type="text" class="form-control" id="age"  name="age" value="${user.age}" placeholder="Please enter age" />
        </div>

        <div class="form-group">
            <label for="address">Location</label>
            <select name="address" id="address" class="form-control" >
                <option value="sydney">sydney</option>
                <option value="melbourne">melbourne</option>
                <option value="geelong">geelong</option>
            </select>
        </div>

        <div class="form-group">
            <label for="phone">Phone：</label>
            <input type="text" id="phone" class="form-control" name="phone" value="${user.phone}" placeholder="Please enter phone num"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" value="${user.email}" placeholder="Please enter e-mail"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="submit" />
            <input class="btn btn-default" type="reset" value="reset" />
            <input class="btn btn-default" type="button" value="back"/>
        </div>
    </form>
</div>
</body>
</html>
