<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>handlebar.java POC</title>
    <link rel="stylesheet" href="static/css/foundation.css"/>
    <script src="static/js/vendor/modernizr.js"></script>
    <script type="text/javascript"
            src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>

<header class="row pagination-centered">
    <c:if test="${productPage.hasHeader}">
        <div class="large-12 columns">
            <h1>${productPage.title}</h1>
            <p>${productPage.description}</p>
        </div>
    </c:if>
</header>

<section class="row">
    <div class="large-12 columns">
        <div id="productPagination">
            <div class="pagination-centered">
                <ul class="pagination">
                    <c:forEach var="page" items="${pages}" varStatus="pageCount">
                        <c:choose>
                            <c:when test="${pageCount.index eq '0'}">
                                <li class="current"><a data-action="1">1</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a data-action="${pageCount.index + 1}">${pageCount.index + 1}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</section>

<section class="row">
    <div class="large-12 columns">
        <div id="productTemplate">
            <div>
                ${firstProduct} - ${lastProduct} of ${numberOfProducts}
            </div>
            <hr>
            <c:forEach var="product" items="${productList}" varStatus="productCount">
                <div class="row">
                    <div class="columns large-6">
                        <div>ProductId: ${product.productId}</div>
                        <div>Name: ${product.name}</div>
                        <div>Price: ${product.price}</div>
                        <div>Compare Price: ${product.price}</div>
                    </div>
                    <div class="columns large-6">
                        <img src="${product.productImage}"/>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </div>
    </div>
</section>

<c:if test="${productPage.hasNavigation}">
    <nav class="row">
        <div class="large-12 columns">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Shop</a></li>
                <li><a href="#">Brands</a></li>
                <li><a href="#">Checkout</a></li>
            </ul>
        </div>
    </nav>
</c:if>

<footer class="row">
    <c:if test="${productPage.hasFooter}">
        <div class="large-12 columns">
            &copy; Copyright 2014
        </div>
    </c:if>
</footer>

<script src="static/js/vendor/jquery.js"></script>
<script src="static/js/foundation.min.js"></script>
<script src="static/js/vendor/handlebars.js"></script>
<script src="static/js/app.js"></script>
<script>
    $(document).foundation();
</script>
</body>
</html>
