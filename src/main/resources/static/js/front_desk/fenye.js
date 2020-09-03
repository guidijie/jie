let paginations = `
    <div class="pagination">
        <span class="total">共 {{total}} 条 / {{pages}} 页</span>
        <span class="prev" :class="{'disabled':value==1}" @click="prePageHandle">&lt;</span>
        <span class="page" v-for="page in showPage"
        :class="{'active':(changeStart + page-1)==value}"
        @click="changeShow(changeStart + page-1)"
        >{{changeStart + page-1}}</span>
        <span class="next" :class="{'disabled':value==pages}" @click="nextPageHandle">&gt;</span>
        <span class="jump">
                前往
                <input type="text" v-model="val" @keydown.enter="jump"/>
                页
             </span>
    </div>
       `
Vue.component('pagination', {
	template:paginations,
	props: {
		total: {
			type: Number
		},
		prepage: {
			type: Number,
			default: 2
		},
		showPage: { //页面中要显示几个页码
			type: Number,
			default: 3
		},
		value: {
			type: Number
		},
		currentPage: 1, //记录当前页

	},
	data() {
		return {
			pages: Math.ceil(this.total / this.prepage), //计算需要展示的总页数
			val: '', //记录输入框中的值
			posPage: Math.floor(this.showPage / 2) + 1, //超过这个页码时，固定显示的位置
			start: 1, //第一个页码的开始数字
		}

	},
	computed: {
		changeStart() { //分页逻辑
			if (this.pages <= this.showPage) {
				return this.start = 1
			} else {
				if (this.currentPage <= this.posPage) {
					return this.start = 1
				} else if (this.pages - this.currentPage <= this.posPage) {
					return this.start = this.pages - this.showPage + 1
				} else {
					return this.start = this.currentPage - this.posPage + 1
				}
			}
		}
	},
	methods: {
		changeShow(page) {
			this.currentPage = page
			this.$emit('input', page)
			this.fenye(this.currentPage)
		},
		jump() {
			if (this.val < 1) {
				this.val = 1
			}
			if (this.val > this.pages) {
				this.val = this.pages
			}
			this.val = Math.floor(this.val)
			this.$emit('input', this.val)
			this.currentPage = this.val
			this.val = ''
			this.fenye(this.currentPage)

		},
		prePageHandle() {
			let search = location.search;	//获取location的search属性，保存在search中
			let params = {};		//创建空对象params
			if (search != "") {		//如果search不是空字符串
				search.slice(1).split("&").forEach(	//?username=zhangdong&pwd=123456;//search去开头?，按&切割为数组，forEach
					function (val) {
						var arr = val.split("=");		//将当前元素值按=切割，保存在arr中
						params[arr[0]] = arr[1];		//向params中添加一个元素,属性名为arr[0],值为arr[1]
					}
				)
			}
			this.currentPage = --params.pageNum
			console.log(this.currentPage)
			if (this.currentPage < 1) {
				this.currentPage = 1
			}
			this.$emit('input', this.currentPage)
			this.fenye(this.currentPage)
		},
		nextPageHandle() {
			let search = location.search;	//获取location的search属性，保存在search中
			let params = {};		//创建空对象params
			if (search != "") {		//如果search不是空字符串
				search.slice(1).split("&").forEach(	//?username=zhangdong&pwd=123456;//search去开头?，按&切割为数组，forEach
					function (val) {
						var arr = val.split("=");		//将当前元素值按=切割，保存在arr中
						params[arr[0]] = arr[1];		//向params中添加一个元素,属性名为arr[0],值为arr[1]
					}
				)
			}
			this.currentPage = ++params.pageNum
			console.log(this.currentPage)
			if (this.currentPage > this.pages) {
				this.currentPage = this.pages
			}
			this.$emit('input', this.currentPage)
			this.fenye(this.currentPage)
		},
		fenye(pageNum) {
			let search = location.search;	//获取location的search属性，保存在search中
			let params = {};		//创建空对象params
			if (search != "") {		//如果search不是空字符串
				search.slice(1).split("&").forEach(	//?username=zhangdong&pwd=123456;//search去开头?，按&切割为数组，forEach
					function (val) {
						var arr = val.split("=");		//将当前元素值按=切割，保存在arr中
						params[arr[0]] = arr[1];		//向params中添加一个元素,属性名为arr[0],值为arr[1]
					}
				)
				window.location.href = '/toCourseClassification?goodsType=' + params.goodsType + '&level=' + params.level + '&pageNum=' + pageNum;
			}
		}
	}
})

