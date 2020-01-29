import Vue from "vue";
import VueResource from "vue-resource";

Vue.use(VueResource);

export const productApi = Vue.resource('/api/products{/id}');
export const userApi = Vue.resource('/api/users{/id}');      // as repository for front
