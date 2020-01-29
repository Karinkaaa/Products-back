import Vue from 'vue';

import '@babel/polyfill'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
Vue.use(Vuetify);
import App from "./pages/App.vue";

import router from 'router/router'

const app = new Vue({
    el: '#app',
    render: a => a(App),
    vuetify: new Vuetify({}),
    router
});