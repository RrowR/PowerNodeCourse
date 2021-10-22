import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/css/common.less';
import './assets/css/font.css'
import './assets/css/iconfont.css'
import VueAwesomeSwiper from 'vue-awesome-swiper'
import axios from "axios";
import qs from 'querystring'
import api from './api/index.js'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import vueCookie from 'vue-cookie'

// require styles
import 'swiper/dist/css/swiper.css'

// 请求拦截
axios.interceptors.request.use(
    function (config) {
        // 拿到token 放在header里面去
        let token = Vue.cookie.get("token");
        // 请求头带上token
        config.headers['Authorization'] = token;
        if (config.method === 'post') {
            // 对post请求做了一个参数的处理  json
            config.data = qs.stringify(config.data)
        }
        return config;
    },
    function (error) {
        // Do something with request error
        return Promise.reject(error);
    }
);

Vue.prototype.axios = axios;
Vue.prototype.$api = api;

Vue.use(vueCookie)
Vue.use(VueAwesomeSwiper)
Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
