<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/21
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
 <form action="product_save.action" method="post">
     <fieldset>
         <legend>Add a product</legend>
         <p>
             <label for="name">Product Name: </label>
             <input type="text" id = "name" name = "name" tabindex="1">
         </p>
         <p>
             <label for="description">Description: </label>
             <input type="text" id = "description" name = "description" tabindex="2">
         </p>
         <p>
             <label for="price">price: </label>
             <input type="text" id = "price" name = "price" tabindex="3">
         </p>
         <p id="buttons">
             <input type="reset" name="reset" id="reset" tabindex="4">
             <input type="submit" id="submit" tabindex="5" value="Add Product">
         </p>
     </fieldset>
 </form>
</body>
</html>
