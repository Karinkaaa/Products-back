<template>
    <v-app>

        <v-btn :disabled="$route.path === '/'" @click="setPath('/')">main</v-btn>
        <v-btn :disabled="$route.path === '/products'" @click="setPath('/products')">products</v-btn>
        <v-btn :disabled="$route.path === '/users'" @click="setPath('/users')">users</v-btn>

        <v-content>
            <router-view></router-view>
        </v-content>
    </v-app>
</template>

<script>
    export default {
        methods: {
            setPath(path) {
                this.$router.push(path);
            }
        }
    }
</script>

<style>

</style>