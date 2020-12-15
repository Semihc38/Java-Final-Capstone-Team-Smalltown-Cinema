<template>
    <div class="order-card-container">
        <router-link v-bind:to="{ path: '/order/' + this.order.orderId }">
        <h1 class ="order-number" >Order #{{this.order.orderId}} | Seats: {{this.order.seats}} </h1>
        </router-link>
        
        
    </div>
</template>
<script>
export default {
    name: 'order-card',
    props: ['order']
}
</script>
<style>

.order-number{
    font-size: 1.5vw;
    height: 10%;
}


.order-card-container{
    max-width: 22%;
    max-height: auto;
    margin: 20px;
}
</style>