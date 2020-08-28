var headerTemplate = `
<div>
<div class="top-bar">
    <div class="top-bar-cen">
        <div class="top-bar-rigth">
            <div class="user" v-if='!userShow'>
                <div class="containerde">
                    <a href="/login.html">请登录</a>
                </div>
            </div>
            <div class="users" v-if='userShow'>
                <div class="containerde" id="Obj" @mouseenter="mouseenter()" @mouseleave="mouseleave()" >
                    <a href="/me.html">
                        <div class="touxiang" >
                            <img :src="touxiang"/>
                        </div>
                    </a>
                    <div class="fruits" id="Obj1" v-if="show">
                        <div>
                            <div>
                                <div class="yin">
                                    <div class="line"><a href="/me.html">个人信息</a></div>
                                    <div class="line"><a href="/myorder.html">我的订单</a></div>
                                    <div class="line"><a href="/Change-p.html">修改密码</a></div>
                                    <div class="line"><a href="javascript:;;" @click="logout">退出</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div style="float: left; line-height: 40px;padding: 5px 0 5px 0;">
                <a href="javascript:;;" @click="cart">购物车</a>
            </div>
        </div>

    </div>
</div>

<!-- header -->
<header class="header">
    <!-- logo和搜索 -->
    <div class="wf-wrap">
        <div class="wf-table">
            <div class="logo-bar">
                <div>
                    <img src="../images/front_desk/yemian/logo2.png" style="width: 105px; height: 105px;"/>
                </div>
            </div>
            <div class="assistive-info">
                <div>
                    <input type="text" class="input-text" v-model="inputSearch"/>
                    <button class="input-btn" @click="search"></button>
                </div>
            </div>
        </div>
    </div>


    <!-- 导航 -->
    <div class="navigation-holder">
        <div class="nav">
            <ul id="ul-title">
                <li class="nav-li" v-for="(i,index) in list">
                    <a :href="i.src">
                        <span>{{i.name}}</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>

</header>
</div>
    `
Vue.component('my-header', {
    template: headerTemplate,
    data() {
        return {
            username: "",
            userShow: false,
            show:false,
            list:[
                {name:"首页", src:"/"},
                {name:"课程分类", src:"/toCourseClassification?goodsType=all&level=all&pageNum=1"},
            ],
            touxiang:'',
            inputSearch: ""
        }

    },
    methods: {
        mouseenter($event) {
            this.show = true
        },
        mouseleave(){
            this.show = false
        },
        getData() {
            let then = this
            this.username = sessionStorage.getItem('uname')
            if(this.username != "null" && !(!this.username)){
                this.userShow = true
                axios.get('/user/findByUserInfo/' + sessionStorage.getItem('uname')
                ).then(function (response) {
                    if (response.data.code == 200) {
                        then.touxiang = response.data.data.userInfo.imagePath
                    } else {
                        alert("出现故障了，请重新登录")
                    }

                }).catch(function (error) {
                    console.log('请求出错啦')
                })
            }else {
                this.userShow = false
            }

        },
        cart(){
            if(!this.username || this.username == 'null'){
                if(confirm("你还没有登录，请先登录")) {
                    location.href = '/login.html'
                }
            }else {
                location.href = '/cart.html'
            }
        },
        logout(){
            if(confirm("确定要注销吗?")) {
                sessionStorage.setItem('uname',null)
                this.username = ''
                location.href='/logout'
            }
        },
        search(){
            console.log("dianji")
            location.href='/toSearch?search='+this.inputSearch
        }
    },
    created() {
        this.getData();
    }
})
