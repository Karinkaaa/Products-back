<template>
    <div>
        <v-container class="pa-12">
            <v-btn class="ma-12" depressed large color="primary" v-on:click="create">CREATE USER</v-btn>
            <user v-if="user" :item="user" v-on:save-item="save"/>
            <user-list
                    v-if="!user"
                    :items="users"
                    v-on:update-item="update"
                    v-on:remove-item="remove"
            />
        </v-container>
    </div>
</template>

<script>
    import User from "./User.vue";
    import UserList from "./UserList.vue";
    import {userApi} from "../api.js";

    export default {
        components: {
            User,
            UserList
        },
        data() {
            return {
                users: [],
                user: null
            }
        },
        methods: {
            fetchUsers() {
                userApi.get().then(response => {
                    console.log(response);
                    this.users = response.body;
                });
            },
            create() {
                console.log("create() UP");
                this.user = {};
            },
            save(item) {
                console.log("save() item UP: ", item);

                if (item.id) {
                    userApi.update({id: item.id}, item).then(response => {
                        console.log(response);
                        this.user = null;
                        this.fetchUsers();
                    });
                } else {
                    userApi.save({id: item.id}, item).then(response => {
                        console.log(response);
                        this.user = null;
                        this.fetchUsers();
                    });
                }
            },
            update(item) {
                console.log("update() item UP: ", item);
                this.user = item;
            },
            remove(item) {
                console.log("remove() item UP: ", item);

                userApi.delete({id: item.id}).then(response => {
                    console.log(response);
                    let index = this.users.findIndex(({id}) => id === item.id);
                    this.users.splice(index, 1);
                });
            }
        },
        mounted() {
            this.fetchUsers();
        }
    }
</script>

<style scoped>

</style>