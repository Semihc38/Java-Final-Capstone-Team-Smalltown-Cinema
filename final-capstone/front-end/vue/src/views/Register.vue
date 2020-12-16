<template>
  <div id="register-page" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <div id="confirm-password">
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      </div>
      <div id="create-account">
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>

      <div id="have-account">
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      </div>

      
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>

h1{
  background-color: #231F20;
  max-width: 60%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  color: #8E793E;
  margin-bottom: 20px;
}


#register-page{
  background-color: #8E793E;
  background-image: url('../assets/fancy-image.jpg');
  padding-bottom: 20px;
  color: #EAEAEA;
  max-width: 50%;
  margin: auto;
  background-size: 100%;
  margin-top: 10%;
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

#confirm-password{
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#create-account{
  margin-top: 5px;
  margin-bottom: 5px;
}

#have-account{
 background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px; 
}

a{
  color: #EAEAEA;
}
</style>
