<template>
  <div class="showtimes">

    <h1 class="heading">Showtimes</h1>
    <showtimes />
    <drop-down/>
  </div>
</template>

<script>
import Showtimes from '../components/Showtimes.vue';
import DropDown from '../components/DropDown.vue';
export default {
  name: 'showtimes-page',
  components:{
    Showtimes,
    DropDown
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
  background-color: #ad974f;
}

</style>