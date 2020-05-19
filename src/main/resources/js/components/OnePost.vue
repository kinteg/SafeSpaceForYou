<template>
    <div>
        <h4><a class="head"  :href="'/post/'+ post.id">{{post.title}}</a></h4>
        <p v-html="post.mainText.substr(0, 300)"></p>
        <a class="read" :href="'/post/'+ post.id">Читать далее</a>
        <p style="padding-top: 10px; font-size: 90%">{{post.author}} {{post.dateCreation}}</p>
        <hr>
    </div>
</template>

<script>
    export default {
        name: "OnePost",
        props: {
            post: {
                type: Object,
                required: true,
            }
        },
        mounted() {
            console.log(this.post);
        }
    }
</script>

<style scoped>
    .read{
        font: normal normal 110% Serif;
        text-decoration:underline;
        color: #422d61;
    }

    .read:hover{
        text-decoration: none;
    }

    .head{
        color: #422d61;
        text-decoration: none
    }

    .head:hover{
        color: #9038b4;
    }
</style>