<template>

    <div class = "showtimes-container">
        <h1 class="movie-title">{{this.movie.title}}</h1>
        <img class ="movie-poster" v-bind:src="movie.poster" />
        <p class="movie-overview">{{this.movie.overview}}</p>
        <showtime-card class ="start-time" v-for="showtime in showtimes" v-bind:key="showtime.showtimeId" v-bind:showtime="showtime" />

    </div>
    
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import ShowtimeCard from './ShowtimeCard.vue';

export default {
    components: {
        ShowtimeCard,
        
    },
    name:'showtimes',
    data(){
        return {
            movie: [],
            showtimes: []
        }
    },
    methods:{
    
    },
    created(){
        applicationServices.getShowtimesByMovieId(this.$route.params.id).then(response =>{
            this.showtimes = response.data;
        });

        applicationServices.getChosenMovie(this.$route.params.id).then(response => {
            this.movie = response.data;
        });
        
    }
}
</script>

<style>

</style>