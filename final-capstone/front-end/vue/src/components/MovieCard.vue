<template>
    <div class="card">
        <h1 class ="movie-title">{{this.movie.title}}</h1>
        
    </div>
</template>
<script>
export default {
    name: 'movie-card',
    props: ['movie']
}
</script>