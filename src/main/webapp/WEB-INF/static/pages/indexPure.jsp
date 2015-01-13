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

<header class="row">
    <div class="large-12 columns">
        <h1>This is the Product Page</h1>
        <p>The Product Page is where you can view attributes of a product</p>
    </div>
</header>

<section class="row">
    <div class="large-12 columns">
        <div id="productTemplate">
            <div>
                ${firstProduct} - ${lastProduct} of ${numberOfProducts}, ${numberOfPages} total pages
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
        <button id="previousPage" type="button">Previous Page</button>
        <button id="nextPage" type="button">Next Page</button>
    </div>
</section>

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

<footer class="row">
    <div class="large-12 columns">
        &copy; Copyright 2014
    </div>
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
