<template>
    <div>
        <p>Hello, Bus!</p>

        <div v-for="product in products">
            {{ product }}
        </div>&nbsp;

        <div>
            <p> {{ name }} </p>
        </div>

        <div>
            <input v-model="name"/>
            <button v-on:click="save">
                save
            </button>
        </div>&nbsp;

        <div>
            ID:
            <input type="number" v-model="id"/>
        </div>
        <div>
            New name:
            <input type="text" v-model="name"/>

            <button v-on:click="update">
                update
            </button>
        </div>&nbsp;

        <div>
            ID:
            <input type="number" v-model="id"/>

            <button v-on:click="getOne">
                search
            </button>
        </div>

        <test name="test" ></test>&nbsp;
        <user></user>
    </div>
</template>

<script>
    import {productApi} from '../api.js';
    import Test from "./Test.vue";
    import User from "./User.vue";

    console.log(productApi);

    export default {
        components: {
            Test,
            User
        },
        data() {
            return {
                id: 0,
                name: "product name",
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
            getOne() {

                productApi.get({id: this.id}).then(response => {
                        console.log(response);
                        this.products = [response.body];
                    }
                );
            },
            save() {

                productApi.save({}, {id: Math.floor(Math.random() * 100), name: this.name}).then(
                    response => {
                        console.log(response);
                        this.products = [response.body];
                    }
                );
            },
            update() {

                productApi.update({id: this.id}, {id: this.id, name: this.name}).then(
                    response => console.log(response)
                );
            }
        },
        mounted() {
            this.fetchProducts();
        }
    }
</script>

<style>

</style>