<template>
    <div class="card">
        <h1 class ="movie-title">{{this.movie.title}}</h1>
        <img class ="movie-poster" v-if="movie.poster" v-bind:src="movie.poster" />
      
        
    </div>
</template>
<script>
export default {
    name: 'movie-card',
    props: ['movie']
}
</script>