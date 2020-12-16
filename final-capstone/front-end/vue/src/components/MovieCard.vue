<template>
    <div class="movie-card">
        <router-link v-bind:to="{ path: '/showtimes/' + this.movie.movieId }">
        <h1 id="movie-title" class ="movie-title" >{{this.movie.title}}</h1>
        </router-link>
        
        <router-link class="movie-title" v-bind:to="{ path: '/showtimes/' + this.movie.movieId }">
        <img id="movie-poster" class ="movie-poster"  v-if="movie.poster" v-bind:src="movie.poster" />
        </router-link>
        
    </div>
</template>
<script>
export default {
    name: 'movie-card',
    props: ['movie']
}
</script>
<style>
#movie-title{
    font-size: 1.5vw;
    height: 20%;
  max-width: 60%;
  margin: auto;
  color: #8E793E;
  margin-bottom: 20px;
}
#movie-poster{
    max-width: 75%;
    max-height: auto;
    margin-top: 10px;
    border: 5px double #231F20;

}
.movie-card{
    max-width: 22%;
    max-height: auto;
    margin: 20px;
}
</style>