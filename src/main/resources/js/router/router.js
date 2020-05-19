import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPage from "../pages/MainPage.vue";
import AllPosts from "../pages/AllPosts.vue";
import ReadPost from "../pages/ReadPost.vue";
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
    {
        path:'/blog',
        component: AllPosts,
        name: 'blog',
        meta: {
            title: 'Все посты'
        }
    },
    {
        path:'/post/:id',
        component: ReadPost,
        name: 'post',
        meta: {
            title: 'Один пост'
        }
    },
];
export default new VueRouter({
    mode: 'history',
    routes
})