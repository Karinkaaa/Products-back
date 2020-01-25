<template>
    <div>
        Hello, Bus!

        <div>
            {{ products }}
        </div>
        <button v-on:click="click">
            butt
        </button>
        <div>
            {{ text }}
        </div>
        <input v-model="text"/>
        <test name="Jajaja"></test>
    </div>
</template>

<script>
    import {productApi} from '../api.js';
    import Test from "./Test.vue";

    console.log(productApi);

    export default {
        components: {
            Test
        },
        data: function () {
            return {
                text: "kiss",
                products: null
            };
        },
        methods: {
            fetchProducts() {

                productApi.get().then(response => {
                    console.log(response);
                    this.products = response.body;
                });
            },
            click() {
                console.log("click click click");

                productApi.save({}, {id: Math.floor(Math.random() * 100), name: this.text}).then(
                    response => console.log(response)
                );


                // this.$http.post(`/products/create?id=${Math.floor(Math.random() * 100)}&name=${this.text}`)
                //     .then(response => {
                //         console.log(response);
                //         this.fetchProducts();
                //     });
            }
        },
        mounted() {
            this.fetchProducts();
        }
    }
</script>

<style>

</style>