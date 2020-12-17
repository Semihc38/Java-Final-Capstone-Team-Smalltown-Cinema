<template>
<div class="background">
  <h1 class="heading">Welcome to Small Town Cinema</h1>
    <p><strong>COVID-19 is threatening the cinema industry. Movie theatres have been especially hard hit as Hollywood Studios are reluctant to release movies and blockbuster films that are essential for our survival.
We remain open, however there are few new films available to play - so we are bringing some old favorites back to the big screen! Now is your chance to rent out an entire theater to enjoy Home Alone with the kids, or socially distance with some old friends as you watch Christmas Vacation together in one of our four opulent theaters.
Small Town Cinema not only offers a super comfortable and intimate cinema with superior sound quality, but is also a local business that you can be proud of.  As a small business, we support the community by offering beverages from local wineries and brewers and artisinal food made with fresh and organic products from our farm-to-table suppliers (try the truffle pepper popcorn with a spiked seltzer!).
We thank you, our amazing patrons, for your continued support - now relax and enjoy the film!</strong></p>
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
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.heading{
  color: #AD974F;
  font-family: 'Limelight', cursive;
  font-size: 40px;

}
.home{
  background-color:#231F20;
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
p{
  background-color: #231F20;
  max-width: 80%;
  border: 2px solid #FF0000;
  margin: auto;
  border-radius: 5px;
  color: #EAEAEA;
  margin-bottom: 20px;
}
</style>