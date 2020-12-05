<template>
    <div class ="Featured-Movies">
        <h1 v-for="movie in this.$store.state.movies" v-bind:key="movie.title"></h1>
        <movie-card />

    </div>
</template>
<script>
import applicationServices from '@/services/ApplicationServices.js'
import MovieCard from './MovieCard.vue';
export default {
  components: { 
      MovieCard 
  },
    name:'featured-movies',
    methods:{
        getFeaturedMovies(){
            applicationServices.getFeaturedMovies().then(response => {
                this.$store.commit("SET_FEATURED_MOVIES", response.data)
            });
        }
    },
    created(){
        this.getFeaturedMovies();
    }
}
</script>
<style scoped>

</style>