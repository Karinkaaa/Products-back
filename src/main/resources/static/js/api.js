import Vue from "vue";
import VueResource from "vue-resource";
Vue.use(VueResource);

export const productApi = Vue.resource('/products{/id}');
