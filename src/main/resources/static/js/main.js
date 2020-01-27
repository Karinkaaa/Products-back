import Vue from 'vue';
import ProductPage from "./pages/ProductPage.vue";

const app = new Vue({
    el: '#app',
    render: a => a(ProductPage)
});