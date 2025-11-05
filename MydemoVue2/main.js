import App from './App'

// #ifndef VUE3
import Vue from 'vue'
import './uni.promisify.adaptor'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import { Dialog } from 'vant';
// // 导入 Vant 的样式文件
// import 'vant/lib/index.css';

// // 全局注册 Dialog 组件
// Vue.use(Dialog);

Vue.config.productionTip = false
Vue.use(ElementUI)

App.mpType = 'app'

const app = new Vue({
  ...App
})

app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

export function createApp() {
  const app = createSSRApp(App)
  app.use(ElementPlus) // 使用 Element Plus (Vue 3版本的UI库)

  return {
    app
  }
}
// #endif
