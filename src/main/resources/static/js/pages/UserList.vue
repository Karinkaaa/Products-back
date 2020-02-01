<template>
    <div>
        <v-simple-table>
            <template v-slot:default>
                <thead class="blue-grey">
                <tr class="py-xl-10">
                    <th class="text-left">ID</th>
                    <th class="text-left">Name</th>
                    <th class="text-left">AGE</th>
                    <th class="text-left">UPDATE</th>
                    <th class="text-left">REMOVE</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in items">
                    <td>{{ item.id }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.age }}</td>
                    <td>
                        <v-btn v-on:click="update(item)">update</v-btn>
                    </td>
                    <td>
                        <v-btn v-on:click="remove(item)">remove</v-btn>
                    </td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
    </div>
</template>

<script>
    export default {
        props: ["items"],
        methods: {
            update(item) {
                console.log("update User item: ", item);
                this.$emit("update-item", item);
            },
            remove(item) {
                console.log("remove User item: ", item);
                this.$emit("remove-item", item);
            }
        }
    }
</script>

<style scoped>

</style>