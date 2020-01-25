import Vue from "vue";
import VueResource from "vue-resource";
Vue.use(VueResource);

export const productApi = Vue.resource('/products{/id}');
export const userApi = Vue.resource('/users{/id}');      // as repository for front
