<template>

    <div class = "showtimes-container">
        <h1 class="movie-title">{{this.movie.title}}</h1>
        <div class="times">
            <showtime-card class ="start-time" v-for="showtime in showtimes" v-bind:key="showtime.showtimeId" v-bind:showtime="showtime" />
        </div>
        <div class="poster-overview">
        <img class ="movie-poster" v-bind:src="movie.poster" />
        <p class="movie-overview">{{this.movie.overview}}</p>
        </div>

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
img{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    background: #EAEAEA;
    justify-content: left;
}
.movie-poster{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    background: #EAEAEA;
    justify-content: right;
}
.poster-overview{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
}
.movie-overview{
    color: #231F20;
    padding: 5%;
    max-width: 30%;
    padding-left: 10%;
    text-align: left;
    line-height: 30px;
}
.showtimes-container{
    background-color: #EAEAEA;
}
.movie-title{
    font-size: 50px;
    color: #AD974F;
}
.times{
    background-color: #AD974F;
}
.movie-poster{
    padding-bottom: 5%;
    padding-left: 5%;
}
</style>