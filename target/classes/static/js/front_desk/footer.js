var footerTemplate = `
<footer class="footer">
    <div class="footer-info">
        <div class="footer-info-t1">郑重声明：内容均系原创，已申请版权保护，请勿盗版。</div>
        <div class="footer-info-t2">
            <ul>
                <li><a href="#">隐私保护</a></li>
                <li><a href="#">版权声明</a></li>
                <li><a href="#">退换货政策</a></li>
                <li><a href="#">关于我们</a></li>
            </ul>
        </div>
        <div class="footer-info-t3">Copyright © 2019-2020 stupiddog有限公司. All Rights Reserved.</div>
    </div>
</footer>
    `
Vue.component('my-footer', {
    template: footerTemplate,
    data() {
        return {

        }
    },

})