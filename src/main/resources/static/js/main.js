import Vue from 'vue';
import Vuetify from 'vuetify';

import '@babel/polyfill';
import 'vuetify/dist/vuetify.min.css';

import App from "./pages/App.vue";
import router from 'router/router';

Vue.use(Vuetify);

const app = new Vue({
    el: '#app',
    render: a => a(App),
    vuetify: new Vuetify({}),
    router
});