import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
/*
1，index.js 里设置需要的状态变量和方法。为了实现登录拦截器，这里需要一个记录用户信息的变量。我们使用一个用户对象而不是仅仅使用一个布尔变量。同时，设置一个方法，触发这个方法时可以为我们的用户对象赋值。
2，我们这里用到了这个函数 localStorage，即本地存储，在项目打开的时候会判断本地存储中是否有 userinfo 这个对象存在，如果存在就取出来并获得 username 的值，否则则把 username 设置为空。
3，缓存这些数据，只要不清除缓存，登录的状态就会一直保存。
 */
export default new Vuex.Store({
  state: {
    user: {
      username: window.localStorage.getItem('userinfo' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('userinfo' || '[]')).username
    }
  },
  mutations: {
    login (state, user) {
      state.user = user
      window.localStorage.setItem('userinfo', JSON.stringify(user))
    }
  }
})
