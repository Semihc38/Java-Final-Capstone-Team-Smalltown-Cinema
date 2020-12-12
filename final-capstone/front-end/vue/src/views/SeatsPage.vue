<template>
  <div class="seats">

    <h1 class="heading">Seats</h1>
    <seats />
   
  </div>
</template>

<script>
import Seats from '../components/Seats.vue';
export default {
  name: 'showtimes-page',
  components:{
    Seats
  },
};

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
.heading{
  color: #EAEAEA;
  font-family: 'Limelight', cursive;
  font-size: 50px;
  border: 5px double #AD974F;
}
#nav{
  background-color: #AD974F;
}

</style>