<template>
    <div>
        <button v-on:click="create">CREATE</button>
        <product v-if="product" :item="product" v-on:save-item="save"/>
        <product-list
                v-if="!product"
                :items="products"
                v-on:update-item="update"
                v-on:remove-item="remove"/>

    </div>
</template>

<script>
    import Product from "./Product.vue";
    import ProductList from "./ProductList.vue";
    import {productApi} from "../api.js";

    export default {
        components: {
            Product,
            ProductList
        },
        data() {
            return {
                products: [],
                product: null
            }
        },
        methods: {
            create() {
                console.log("create() PP");
                this.product = {};
            },
            update(item) {
                console.log("update() PP: ", item);
                this.product = item;
            },
            fetchProducts() {
                productApi.get().then(response => {
                    console.log(response);
                    this.products = response.body;
                });
            },
            remove(item) {
                console.log("remove item PP: ", item);
                productApi.delete({id: item.id}).then(response => {
                    console.log(response);
                    let index = this.products.findIndex(({id}) => id === item.id);
                    this.products.splice(index, 1);
                });
            },
            save(item) {
                console.log("save item PP: ", item);

                if (item.id) {
                    productApi.update({id: item.id}, item).then(response => {
                        console.log(response);
                        this.product = null;
                        this.fetchProducts();
                    });
                } else {
                    productApi.save({}, item).then(response => {
                        console.log(response);
                        this.product = null;
                        this.fetchProducts();
                    });
                }
            }
        },
        mounted() {
            this.fetchProducts();
        }
    }
</script>

<style scoped>

</style>