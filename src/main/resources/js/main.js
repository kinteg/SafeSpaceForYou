import Vue from 'vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'
import router from "./router/router.js";
import App from "./pages/App.vue";

Vue.use(VueRouter);

Vue.use(VueResource);

new Vue({
    el: '#app',
    render: a => a(App),
    router
});