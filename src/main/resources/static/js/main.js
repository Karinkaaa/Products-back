import Vue from 'vue';
import UserPage from "./pages/UserPage.vue";

const app = new Vue({
    el: '#app',
    render: a => a(UserPage)
});