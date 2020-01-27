<template>
    <div>
        <div v-for="item in items">
            {{ item.id }} {{ item.name }}
            <button v-on:click="update(item)">UPDATE</button>
            <button v-on:click="remove(item)">DELETE</button>
        </div>
    </div>
</template>

<script>

    export default {
        props: ["items"],
        methods: {
            update(item) {
                console.log(item, this.items);
                this.$emit("update-item", item);
            },
            remove(item) {
                console.log("remove item: ", item);
                this.$emit("remove-item", item);
            }
        }
    }
</script>

<style scoped>

</style>