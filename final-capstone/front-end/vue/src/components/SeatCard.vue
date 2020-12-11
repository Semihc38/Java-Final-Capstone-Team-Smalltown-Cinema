<template>
    <div class="seat-card">
        
        <h1 class ="seat-name" >{{this.seat.name}}</h1>
 
        
    </div>
</template>

<script>
export default {
    name: 'seat-card',
    props: ['seat']
}
</script>

<style>
.seat-name{
    font-size: 1.5vw;
    height: 10%;
}


.seat-card{
    max-width: 22%;
    max-height: auto;
    margin: 20px;
}
</style>