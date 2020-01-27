<template>
    <div>
        <div>User Vue</div>&nbsp;

        <div v-for="user in users">{{user}}</div>
        <input type="text" v-model="name"/>
        <input type="number" v-model="age"/>

        <button v-on:click="save">SAVE</button>
        <button v-on:click="findAll">FIND_ALL</button>
    </div>
</template>

<script>

    import {userApi} from "../api";

    console.log(userApi);

    export default {
        data() {
            return {
                name: "username",
                age: 22,
                users: null
            }
        },
        methods: {
            findAll() {
                console.log("Method findAll() in Vue");
                userApi.get().then(response => {
                    console.log(response);
                    this.users = response.body;
                });
            },
            save() {
                console.log("Method save() in Vue");
                userApi.save({},
                    {
                        id: Math.floor(Math.random() * 100),
                        name: this.name,
                        age: this.age
                    })
                    .then(response => {
                        console.log(response);
                        this.findAll();
                    });
            }
        }
    }
</script>

<style scoped>

</style>