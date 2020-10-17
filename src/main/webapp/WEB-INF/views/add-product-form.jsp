<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product to Cart</title>
</head>
<body>
<form method="post" action="/addtocart">
    <h3>Select an element to add to Cart</h3>
    <div>
        <h4>Select a product</h4>
        <c:forEach items="${productsList}" var="product">
            <input type="radio" name="productSelected" value="${product.name}"> &emsp; <b>${product.id}</b> &emsp; ${product.name} &emsp;&emsp; <i>${product.price} PLN</i> <br/>
        </c:forEach>
    </div>

    <div>
        <label for="quantityLabel">Select the quantity</label>
        <input type="number" id="quantityLabel" name="quantity" min="1" max="10" value="1"/>
    </div>

    <input type="submit">

</form>
</body>
</html>
