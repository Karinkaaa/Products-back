<template>
    <v-container class="pa-12">
        <p v-if="item.id"> ID: {{ item.id }} </p>
        <v-text-field type="text" v-model="item.name"/>
        <v-btn @click="save">SAVE</v-btn>
    </v-container>
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

    #asd {
        background-color: cornflowerblue;
    }
</style>