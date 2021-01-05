// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
// 引入Element,做界面美化
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入cookies
import VueCookies from 'vue-cookies'
// 设置反向代理 前端请求默认发送到http://localhost:8082
var axios = require('axios')
axios.default.baseURL = 'http://localhost:8082/req'
// 全局注册，之后可以在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueCookies)
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
