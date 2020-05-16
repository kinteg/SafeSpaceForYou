import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPage from "../pages/MainPage.vue";
Vue.use(VueRouter);

const routes = [
    {
        path:'/',
        component: MainPage,
        name: 'main',
        meta: {
            title: 'Главная'
        }
    },
]
export default new VueRouter({
    mode: 'history',
    routes
})