import Vue from 'vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'
import router from "./router/router.js";
import App from "./pages/App.vue";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueResource);

new Vue({
    el: '#app',
    render: a => a(App),
    router
});