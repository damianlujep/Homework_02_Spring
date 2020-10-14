<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My Cart</title>
    <style>
        a.button {
            -webkit-appearance: button;
            -moz-appearance: button;
            -appearance: button;

            text-decoration: none;
            color: initial;
        }

        table, th, td {
            border-collapse: collapse;
            border: 1px solid black;
            width: 30%;
            height: 35px;
            table-layout: fixed;
        }
    </style>
</head>
<body>

<h2>Your Cart:</h2>

<table>
    <tr>
        <th>Lp.</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>

    <c:if test="${cartItems.size() != 0}">

        <c:forEach items="${cartItems}" var="list" varStatus="status">
            <tr>
                <td style="text-align: center">${status.count}</td>
                <td style="text-align: center"> ${list.product.name}</td>
                <td style="text-align: center"> ${list.product.price} PLN</td>
                <td style="text-align: center">
                    <a href="" class="button">-</a>
                        ${list.quantity}
                    <a href="/increasebyone/${list.product.name}" class="button">+</a>

                </td>

            </tr>

        </c:forEach>

    </c:if>


</table>

</body>
</html>
