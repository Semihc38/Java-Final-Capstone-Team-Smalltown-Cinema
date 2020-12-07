<template>

    <div class = "showtimes-container">
        <movie-card v-for="movie in this.movies" v-bind:key="movie.title" v-bind:movie="movie"/>
    </div>
    
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import MovieCard from './MovieCard.vue';
export default {
    components: {
        MovieCard
    },
    name:'showtimes',
    props:{
        movie_id: Number
    },
    data(){
        return {
            movies: []
        }
    },
    methods:{
    
    },
    created(){
        applicationServices.getShowtimeById(this.movie_id).then(response =>{
            this.$store.commit("SET_CHOSEN_MOVIE", response.data)
        });
        
    }
}
</script>

<style>

</style>