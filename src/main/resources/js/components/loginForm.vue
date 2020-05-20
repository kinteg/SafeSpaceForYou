<template>
    <div class="loginForm">
        <b-form>
            <b-form-group
                    label="Логин"
                    label-for="login"
            >
                <b-form-input
                        id="login"
                        v-model="form.login"
                        type="email"
                        required
                        placeholder="Введите логин"
                ></b-form-input>
            </b-form-group>

            <b-form-group
                    label="Пароль"
                    label-for="password"
            >
                <b-form-input
                        id="password"
                        v-model="form.password"
                        required
                        placeholder="Введите пароль"
                ></b-form-input>
            </b-form-group>

            <b-button class="button" type="submit" variant="primary">Войти</b-button>

        </b-form>
    </div>
</template>

<script>
    export default {
        name: "loginForm",
        data(){
            return{
                form:{
                    login:"",
                    password:"",
                }
            }
        }
    }
</script>

<style scoped>
    .loginForm{
        width: 40%;
        padding: 20px;
        background-color: white;
        border-radius: 15px;
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