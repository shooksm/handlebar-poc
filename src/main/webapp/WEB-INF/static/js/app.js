/**
 * Created by Rob Whitaker on 1/13/2015.
 */

// todo: refactor to cache template instead of call for it on each click event
var productPartial, productListTemplate, requestedPage;

$(document).ready(function () {
    $(".pagination a").click(function () {
        requestedPage = $(this).attr('data-action');
        // todo: need to clean this up in to a deffered promise
        $.ajax({
            url: '/handlebar-poc/static/hbs/product.hbs',
            cache: true,
            success: function (data) {
                productPartial = Handlebars.compile(data);
                Handlebars.registerPartial('product', productPartial);
                getNextProductListTemplate();
            }
        });
        $("li").removeClass('current');
        $(this).parent('li').addClass('current');
    });
});

function getNextProductListTemplate() {
    $.ajax({
        url: '/handlebar-poc/static/hbs/productList.hbs',
        cache: true,
        success: function (data) {
            productListTemplate = Handlebars.compile(data);
            getNextProductsByPage();
        }
    });
}

function getNextProductsByPage() {
    var productsURL = "/handlebar-poc/api/products/" + requestedPage ;
    $.ajax({
        url: productsURL,
        success: function (data) {
            $('#productTemplate').html(productListTemplate(data));
        }
    });
}