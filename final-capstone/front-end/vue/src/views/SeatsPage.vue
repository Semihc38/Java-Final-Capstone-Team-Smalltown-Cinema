<template>
  <div>
    <h1 class="heading">Seats</h1>
    <div class="seats-tickets">
      <div class="seats">
        <seats />
      </div>
      <div class="tickets">
        <tickets />
      </div>
    </div>
  </div>
</template>

<script>
import Seats from '../components/Seats.vue';
import Tickets from '../components/Tickets.vue';
export default {
  name: 'showtimes-page',
  components:{
    Seats,
    Tickets
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
.seats-tickets{
    display: grid;
    grid-template-columns: 2fr, 1fr;
    grid-template-areas: 'heading heading'
    'seats-container tickets';
    
}

</style>