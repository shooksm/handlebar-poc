/**
 * Created by Rob Whitaker on 1/13/2015.
 */

// todo: refactor to cache template instead of call for it on each click event
var productPartial, productListTemplate;

$(document).ready(function () {
    $("#nextPage").click(function () {
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
    });
    $("#previousPage").click(function () {
        // todo: need to clean this up in to a deffered promise
        $.ajax({
            url: '/handlebar-poc/static/hbs/product.hbs',
            cache: true,
            success: function (data) {
                productPartial = Handlebars.compile(data);
                Handlebars.registerPartial('product', productPartial);
                getPreviousProductListTemplate();
            }
        });
    });
});

function getNextProductListTemplate() {
    $.ajax({
        url: '/handlebar-poc/static/hbs/productList.hbs',
        cache: true,
        success: function (data) {
            $("html, body").animate({ scrollTop: 0 }, 200);
            productListTemplate = Handlebars.compile(data);
            getNextProductsByPage();
        }
    });
}

function getNextProductsByPage() {
    var productsURL = "/handlebar-poc/api/products/next";
    $.ajax({
        url: productsURL,
        success: function (data) {
            $('#productTemplate').html(productListTemplate(data));
        }
    });
}

function getPreviousProductListTemplate() {
    $.ajax({
        url: '/handlebar-poc/static/hbs/productList.hbs',
        cache: true,
        success: function (data) {
            $("html, body").animate({ scrollTop: 0 }, 200);
            productListTemplate = Handlebars.compile(data);
            getPreviousProductsByPage();
        }
    });
}

function getPreviousProductsByPage() {
    var productsURL = "/handlebar-poc/api/products/previous";
    $.ajax({
        url: productsURL,
        success: function (data) {
            $('#productTemplate').html(productListTemplate(data));
        }
    });
}