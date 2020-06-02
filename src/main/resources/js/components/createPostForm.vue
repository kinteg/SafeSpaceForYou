<template>
    <div class="block">
        <b-form>
            <b-form-group
                    label="Заголовок"
                    label-for="header"
            >
                <b-form-input
                        id="header"
                        v-model="post.header"
                        type="text"
                        required
                        placeholder="Введите заголовек поста"
                ></b-form-input>
            </b-form-group>

            <b-form-group>
                <b-form-textarea
                        v-model="post.textInArea"
                        @update = "enter"
                        id="text"
                        placeholder="Введите текст поста"
                        rows="3"
                        max-rows="8">
                </b-form-textarea>
            </b-form-group>

            <b-button class="button" @click="createPost">Добавить пост</b-button>

        </b-form>
    </div>
</template>
Логин
<script>
    import {AXIOS} from "../AXIOS/http-common";

    export default {
        name: "createPostForm",
        data(){
            return{
                post:{
                    position: 0,
                    header:"",
                    textInArea:"",
                    text:"",
                    author:"",
                }
            }
        },

        methods:{
            enter(){
                let p = function(s) { return '<p>' + s + '</p>'; };

                this.post.text = this.post.textInArea
                    .split('\n\n')
                    .map(function(item) { return p(item); })
                    .join('')
                    .replace(/\n/g, '</p><p>');
                console.log(this.post.text);
            },

            createPost(){
                let formData = new FormData();
                formData.append("author", this.post.author);
                formData.append("title", this.post.header);
                formData.append("mainText", this.post.text);

                AXIOS.post("/post/create", formData).then(response=>{})
            }
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

    .button:hover{
        background-color: #ffc0d3;
        border-color: #ffc0d3;
    }
</style>