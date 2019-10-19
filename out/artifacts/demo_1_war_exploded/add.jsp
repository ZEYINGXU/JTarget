<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>Register or Admin add</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="username">username:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Please enter username">
        </div>

        <div class="form-group">
            <label for="password">password:</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="Please enter password">
        </div>

        <div class="form-group">
            <label for="name">name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Please enter name">
        </div>




        <div class="form-group">
            <label>gender:</label>
            <input type="radio" name="gender" value="male" checked="checked"/>male
            <input type="radio" name="gender" value="female"/>female
        </div>

        <div class="form-group">
            <label for="age">age:</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="Please enter age">
        </div>

        <div class="form-group">
            <label for="address">location：</label>
            <select name="address" class="form-control" id="address">
                <option value="melbourne">melbourne</option>
                <option value="sydney">sydney</option>
                <option value="geelong">geelong</option>
            </select>
        </div>

        <div class="form-group">
            <label for="phone">phone：</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="Please enter phone num"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Please enter email"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="submit" />
            <input class="btn btn-default" type="reset" value="reset" />
            <input class="btn btn-default" type="button" value="back" />
        </div>
    </form>
</div>
</body>
</html>