<template>
<div class="background">
  <div class="home">
    <h1 class="heading">Welcome to Small Town Cinema</h1>
    <h1 class="featured-movies">Featured Movies</h1>
    <featured-movies />
  </div>
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
<style>
.heading{
  color: #EAEAEA;
}
.home{
  background-color: #EAEAEA;
}
.featured-movies{
 color:black;
}
</style>