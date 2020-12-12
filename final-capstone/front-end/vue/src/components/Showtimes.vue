<template>

    <div class = "showtimes-container">
        <h1 class="showtime-movie-title">{{this.movie.title}}</h1>
        <div class='buttons-container time-by-day'>            
            <button class='buttons' v-on:click="getSelectedShowtimes('Monday')">Monday</button>
            <button class='buttons' v-on:click="getSelectedShowtimes('Tuesday')">Tuesday</button>
            <button class='buttons' v-on:click="getSelectedShowtimes('Wednesday')">Wednesday</button>
            <button class='buttons' v-on:click="getSelectedShowtimes('Thursday')">Thursday</button>
            <button class='buttons' v-on:click="getSelectedShowtimes('Friday')">Friday</button>
            <button class='buttons' v-on:click="getSelectedShowtimes('Saturday')">Saturday</button>
            <button class='buttons' v-on:click="getSelectedShowtimes('Sunday')">Sunday</button>
        </div>
        <div class= "times-container time-by-day">

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
        getSelectedShowtimes(day){
            return applicationServices.getShowtimesByMovieIdAndDayOfWeek(this.$route.params.id, day).then(response =>{
            this.showtimes = response.data;
        });
        }
    },
    created(){
        //applicationServices.getShowtimesByMovieId(this.$route.params.id).then(response =>{
        //    this.showtimes = response.data;
        //});

        applicationServices.getChosenMovie(this.$route.params.id).then(response => {
            this.movie = response.data;
        });

        //applicationServices.getShowtimesByMovieIdAndDayOfWeek(this.$route.params.id, "Monday").then(response =>{
        //    this.showtimes = response.data;

        //});
        this.getSelectedShowtimes();

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
    border: 5px double #231F20;
    color: #231F20;
    font-size: 10px;
    
}

img.showtime-movie-poster{
    max-width: 25%;
    height: auto;
    padding-left: 10%;
    padding-bottom: 5%;
    padding-top: 5%;
   

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

.times-container{
    margin: auto;
    display: flex;
    justify-content: center;
}
.buttons:hover{
    background-color: #AD974F;
    border: 5px double #231F20;
}
.buttons{
    border: 5px double #AD974F;
    background-color: #231F20;
    color: #EAEAEA;
    font-family: 'Limelight', cursive;

}
.times-by-day{
    max-width: 50%;
    margin: auto;
}
</style>