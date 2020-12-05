<template>
  <div class="home">
    <h1>Home</h1>
    <p>You are on the homepage</p>
    <featured-movies />
  </div>
</template>

<script>
import FeaturedMovies from '@/components/FeaturedMovies.vue'
export default {
  name: 'home',
  components:{
    FeaturedMovies
  },
};
</script>
