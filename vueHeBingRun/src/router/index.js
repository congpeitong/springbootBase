import Vue from 'vue'
import Router from 'vue-router'
// 导入组件
import HomePage from '@/components/home/HomePage'
import Login from '@/components/Login'
Vue.use(Router)
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'HomePage',
      component: HomePage,
      // 添加是否拦截状态
      meta: {
        requireAuth: true
      }
    }
  ]
})
