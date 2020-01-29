import Vue from 'vue'
import VueRouter from "vue-router"
import UserPage from 'pages/UserPage.vue'
import ProductPage from 'pages/ProductPage.vue'
import MainPage from 'pages/MainPage.vue'

Vue.use(VueRouter);

const routes = [
    {path: '/', component: MainPage},
    {path: '/users', component: UserPage},
    {path: '/products', component: ProductPage},
    // { path: '/user/:id?', component: Profile },     // ? - данный параметр не обязателен
    {path: '*', component: MainPage}
];

export default new VueRouter({
    mode: 'history',
    routes
})