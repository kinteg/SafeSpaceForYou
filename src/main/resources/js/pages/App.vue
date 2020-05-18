<template>
    <div>
        <nav-bar/>
        <b-container fluid="lg">
            <router-view/>
        </b-container>
    </div>
</template>

<script>
    import NavBar from "../components/navBar.vue";
    export default {
        name: "App",
        components: {NavBar},
        mounted() {
            document.body.style.backgroundRepeat = 'no-repeat';
            document.body.style.minHeight = '620px';
            document.body.style.backgroundAttachment = 'fixed';
            document.body.style.backgroundSize = 'cover';
            document.body.style.backgroundImage = 'url(https://safespaceforyou.files.wordpress.com/2020/05/d0a1d0bdd0b8d0bcd0bed0ba-d18dd0bad180d0b0d0bdd0b0-2020-05-04-d0b2-18.33.33-1.png)';
        }
    }
</script>

<style scoped>

</style>