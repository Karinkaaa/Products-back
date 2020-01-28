<template>
    <div>
        <p> ID: {{ item.id }} </p>
        <input type="text" v-model="item.name"/>
        <button v-on:click="save">SAVE</button>
    </div>
</template>

<script>

    export default {
        props: ["item"],
        methods: {
            save() {
                console.log("save() in User");
                this.$emit("save-item", this.item);
            }
        }
    }
</script>

<style scoped>

</style>