<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 id="login-title" class="h3 mb-3 font-weight-normal">Welcome to Small Town Cinemas</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>

      <div id="username-div">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <div id="password-div">
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      </div>
       <div id="sign-in">
      <button type="submit">Sign in</button>
      </div>
      <div id="register">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </div>

      
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.alert-danger{
color: #EAEAEA;
}

.alert-success{
  color: #EAEAEA;
}

#login{
  background-color: #8E793E;
  padding-bottom: 20px;
  color: #EAEAEA;
  max-width: 50%;
  margin: auto;
  background-image: url('../assets/fancy-image.jpg');
  background-size: 100%;
  margin-top: 10%;
}

#login-title{
  background-color: #231F20;
  max-width: 60%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  color: #8E793E;
  margin-bottom: 20px;
}

#username-div{
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  
}
#password-div{
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#username{
margin-left: 1%;
border-radius: 5px;
}

#password{
margin-left: 1%;
border-radius: 5px;
}

#register{
 background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px; 
}
#sign-in{
  margin-top: 5px;
  margin-bottom: 5px;
}

#register a{
  color: #EAEAEA;
}

.form-control{
  background-color: #EAEAEA;
}

</style>