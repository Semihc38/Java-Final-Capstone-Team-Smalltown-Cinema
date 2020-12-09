<template>
  <div class="showtimes">
    <h1 class="heading">Showtimes</h1>
    <showtimes />
  </div>
</template>

<script>
import Showtimes from '../components/Showtimes.vue';
export default {
  name: 'showtimes-page',
  components:{
    Showtimes
  },
};

</script>
<style>
.heading{
  color: #EAEAEA;
}
#nav{
  background-color: #ad974f;
}
</style>