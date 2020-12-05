<template>
    <div class="card">
        <h1 class ="movie-title">{{movie.title}}</h1>
        
    </div>
</template>
<script>
export default {
    name: 'movie-card',
    props: ['movies']
}
</script>