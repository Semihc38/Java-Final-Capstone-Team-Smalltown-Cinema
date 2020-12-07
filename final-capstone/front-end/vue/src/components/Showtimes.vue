<template>

    <div class = "showtimes-container">
        <showtime-card class ="start-time" v-for="showtime in showtimes" v-bind:key="showtime.showtimeId" v-bind:showtime="showtime" />

        <!--<movie-card v-for="movie in this.movies" v-bind:key="movie.title" v-bind:movie="movie"/> -->
    </div>
    
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import ShowtimeCard from './ShowtimeCard.vue';
//import MovieCard from './MovieCard.vue'
export default {
    components: {
        ShowtimeCard
        //MovieCard
    },
    name:'showtimes',
    data(){
        return {
            movies: [],
            showtimes: []
        }
    },
    methods:{
    
    },
    created(){
        applicationServices.getShowtimesByMovieId(this.$route.params.id).then(response =>{
            this.showtimes = response.data;
        });
        
    }
}
</script>

<style>

</style>