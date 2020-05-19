<template>
    <div style="margin:30px;">
        <h4 style="padding-bottom: 15px">{{post.title}}</h4>
        <p v-html="post.mainText" style="text-align: justify;  line-height: 30px"></p>
    </div>
</template>

<script>
    import {AXIOS} from "../AXIOS/http-common";

    export default {
        name: "Post",
        data(){
            return{
                post: [],
            }
        },
        mounted() {
            let postId = this.$route.params.id;
            AXIOS.get("/post/" + postId).then(response=>{
                this.post = response.data;
               console.log(response);
            });
        }
    }
</script>

<style scoped>

</style>