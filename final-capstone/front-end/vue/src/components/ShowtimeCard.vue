<template>
    <div class="showtime-card">
        <h1 class ="start-time">{{this.showtime.startTime}}</h1>
        
      
        
    </div>
</template>
<script>
export default {
    name: 'showtime-card',
    props: ['showtime']
}
</script>
<style>
.movie-title{
    font-size: 1.5vw;
    height: 10%;
}
.movie-poster{
    max-width: 75%;
    max-height: auto;
    margin-top: 10px;

}
.movie-card{

    max-width: 22%;
    max-height: auto;
    margin: 20px;
}
</style>