<template>
    <div>
        <b-navbar class="navBar" oggleable="lg" type="dark" >
            <b-navbar-brand href="/">SafeSpaceForYou</b-navbar-brand>
            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item style="color: white;!important;" href="/">Главная</b-nav-item>
                    <b-nav-item style="color: white;!important;" href="/">Блог</b-nav-item>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    export default {
        name: "navBar"
    }
</script>

<style scoped>
.navBar{
    background-color:#f3a8bf;
}
</style>