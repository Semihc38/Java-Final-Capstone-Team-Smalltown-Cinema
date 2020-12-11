<template>
<div class="seats-container">
    <seat-card v-for="seat in this.seats" v-bind:key="seat.name" v-bind:seat="seat" />

</div>
    
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import SeatCard from './SeatCard.vue'


export default {
    components: {
        SeatCard
        
        
        
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