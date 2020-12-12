<template>
<div class="background">
  <h1 class="heading">Welcome to Small Town Cinema</h1>
  <div class="home">
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
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.heading{
  color: #AD974F;
  font-family: 'Limelight', cursive;
  font-size: 40px;

}
.home{
  background-color: #EAEAEA;
  font-family: 'Limelight', cursive;
  margin: auto;
  padding-top: 1%;
  color: #231F20;
}
.featured-movies{
    width: 50%;
    background-color: #AD974F;
    margin: auto;
    padding: 1%;
    border: 5px double #231F20;

}

</style>