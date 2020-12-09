<template>

    <div class = "showtimes-container">
        <h1 class="showtime-movie-title">{{this.movie.title}}</h1>
        <div class= "times-containter">
            <div class="times">
                <showtime-card class ="start-time" v-for="showtime in showtimes" v-bind:key="showtime.showtimeId" v-bind:showtime="showtime" />
            </div>
        </div>
        <div class="poster-overview">
        <img class ="showtime-movie-poster" v-bind:src="movie.poster" />
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
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
.poster-overview{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    border: 5px double #AD974F;
    margin-top: 10%;

}
.movie-overview{
    font-size: 25px;
    color: #231F20;
    padding: 5%;
    max-width: 30%;
    padding-left: 5%;
    text-align: left;
    line-height: 40px;
    font-family: 'Open Sans', 'Regular';
    
}

.showtimes-container{
    background-color: #EAEAEA;
    padding: 3%;
}

.times{
    width: 80%;
    background-color: #AD974F;
    flex-direction: row;
    justify-content: center;
    font-family: 'Open Sans', 'Regular';
    border: 5px double #231f20;
    color: #231f20;

    
}

img.showtime-movie-poster{
    max-width: 25%;
    max-height: auto;
    padding-left: 10%;
    padding-bottom: 5%;
    padding-top: 5%;
    display:flex;
    flex-wrap: wrap;

}
h1.showtime-movie-title{
font-size: 40px;
padding-top: 20px;
font-family: 'Limelight', cursive;
border: 5px double #AD974F;
max-width: 50%;
margin: auto;
margin-bottom: 5%;
padding-bottom: 1%;
}
.times-containter{
    max-width: 100%;
    display: flex;
    justify-content: center;
}

</style>