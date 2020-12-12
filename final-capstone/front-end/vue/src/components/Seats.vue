<template>
<div class="seat-tickets">
    <div class="seats-container">
        <seat-card v-for="seat in this.seats" v-bind:key="seat.name" v-bind:seat="seat" />
    </div>
    <div class="tickets">
        <tickets />
    </div>
</div>

    
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import SeatCard from './SeatCard.vue'
import Tickets from './Tickets.vue'

export default {
    components: {
        SeatCard,
        Tickets
        
        
    },
    name:'seats',
    data(){
        return {
            movie: [],
            showtimes: [],
            seats: []
            
        }
    },
    methods:{
    
        
    },
    created(){
      applicationServices.getSeatsByShowtimeId(this.$route.params.id).then(response => {
          this.seats = response.data;
      })

    }
}
</script>

<style>

.seats-container {
    width: 50%;
    margin: auto;
    row-gap: 10%;
    display: grid;
    grid-template-columns:  1fr 1fr 1fr 1fr;
    
    justify-content: center;
    flex-wrap: wrap;
}
.seats-tickets{
    display: grid;
    grid-template-columns: 2fr, 1fr;
    grid-template-areas: 'seats-container tickets';
    
}
</style>