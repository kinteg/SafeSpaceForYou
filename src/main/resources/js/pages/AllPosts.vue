<template>
    <div class="block">
        <h2>
            Мой блог
            <span style="float: right">
                <b-button class="button" @click="createPost" variant="primary">Добавить пост</b-button>
            </span>
        </h2>
        <one-post v-for="onePost in allPosts" :post="onePost" />
    </div>
</template>

<script>

    import {AXIOS} from "../AXIOS/http-common";
    import OnePost from "../components/OnePost.vue";
    import router from "../router/router";
    export default {
        name: "AllPosts",
        components: {OnePost},
        data(){
            return{
                allPosts: [],
            }
        },

        methods:{
            createPost(){
                router.push({name: "createPost"});
            }
        },

        mounted() {
            AXIOS.get("/post/").then(response=>{
                this.allPosts = response.data.content;
            });
        }
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

    .button{
        background-color: #f3a8bf;
        border-color: #f3a8bf;
    }

    .button:active{
        background-color: #ffc0d3;
        border-color: #ffc0d3;
    }

    .button:hover{
        background-color: #ffc0d3;
        border-color: #ffc0d3;
    }

    .button:focus{
        background-color: #ffc0d3;
        border-color: #ffc0d3;
    }
</style>