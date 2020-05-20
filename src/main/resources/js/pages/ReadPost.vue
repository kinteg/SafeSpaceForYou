<template>
    <div class="block">
        <post/>
    </div>
</template>

<script>
    import Post from "../components/post.vue";
    export default {
        name: "ReadPost",
        components: {Post}
    }
</script>

<style scoped>
    .block{
        margin-top: 15px;
        padding: 20px;
        background-color: rgba(255, 255, 255,1);
        border-radius: 15px;
        font: normal normal 110% Serif;
        color: #422d61;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    }
</style>