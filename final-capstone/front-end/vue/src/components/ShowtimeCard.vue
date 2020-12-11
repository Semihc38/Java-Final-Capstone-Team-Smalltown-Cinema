<template>
    <div class="showtime-card">
        <h1 class ="start-time">{{this.showtime.startTime}}&nbsp;&nbsp;</h1>
        
    </div>
</template>
<script>
export default {
    name: 'showtime-card',
    props: ['showtime']
}
</script>
<style>
.showtime-card{

max-width:40%;
margin: auto;
}

</style>