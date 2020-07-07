<!-- 使用weiper插件实现轮播效果 -->
var swiper = new Swiper('.swiper-container', {
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
        delay: 2500,
        disableOnInteraction: false,
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});



var v = new Vue({
    el: ".users",
    data:{
        a : 'none'
        // a : 'block'
    }
})

var v1 = new Vue({
    el: ".user",
    data:{
       /* a : 'none'*/
        a : 'block'
    }
})

//获取全部商品
var a = new Vue({
    data:{
        list:[]
    }
})
axios.get('/findAll'
).then(function (response) {
    a.list = response
}).catch(function (error) {
    console.log(error);
});

console.log(a)

/*遍历一级标题*/
var li = new Vue({
    el: "#ul-title",
    data:{
        list:[
            {name:"首页", src:"/index"},
            {name:"课程分类", src:"/index"},
            {name:"字段填充", src:"/index"},
            {name:"字段填充", src:"/index"},
        ]
    }
})


/* 个人信息 */
$("#Obj,#Obj1").mousemove(function () {
    $("#Obj1").css("display", "block");
    $("#Obj").css("border-bottom", "4px solid #5FB878");
})

$("#Obj,#Obj1").mouseleave(function () {
    $("#Obj1").css("display", "none");
    $("#Obj").css("border-bottom", "none");
})

//提取页面
$(function () {
    $('#header').load('/header');
    $('#footer').load('/footer');
})




