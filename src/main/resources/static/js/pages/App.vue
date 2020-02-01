<template>
    <!--    <v-app>-->

    <!--        <v-btn :disabled="$route.path === '/'" @click="setPath('/')">main</v-btn>-->
    <!--        <v-btn :disabled="$route.path === '/products'" @click="setPath('/products')">products</v-btn>-->
    <!--        <v-btn :disabled="$route.path === '/users'" @click="setPath('/users')">users</v-btn>-->
    <!--    </v-app>-->
    <v-app id="inspire">
        <v-navigation-drawer
                v-model="drawer"
                app
        >
            <v-list dense>
                <v-list-item link :disabled="$route.path === '/users'" @click="setPath('/users')">
                    <v-list-item-action>
                        <v-icon>mdi-home</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title >Users</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
                <v-list-item link :disabled="$route.path === '/products'" @click="setPath('/products')">
                    <v-list-item-action>
                        <v-icon>mdi-contact-mail</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title >Products</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>

        <v-app-bar
                app
                color="indigo"
                dark
        >
            <v-app-bar-nav-icon @click.stop="drawer = !drawer"/>
            <v-toolbar-title>MAIN PAGE</v-toolbar-title>
        </v-app-bar>

        <v-content>
                <router-view></router-view>
        </v-content>
        <v-footer
                color="indigo"
                app
        >
            <span class="white--text">&copy; 2020</span>
        </v-footer>
    </v-app>
</template>

<script>
    export default {
        props: {
            source: String,
        },
        data: () => ({
            drawer: null,
        }),
        methods: {
            setPath(path) {
                this.$router.push(path);
            }
        }
    }
</script>

<style>

</style>