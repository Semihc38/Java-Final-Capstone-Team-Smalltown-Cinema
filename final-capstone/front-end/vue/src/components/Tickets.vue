<template>
    <div class="tickets-container">
        <h1>Select Tickets</h1>
        <div class="Adult">
            <h2>Adult</h2>
                <div class="counter-buttons">
                    <button>+</button>
                        <h3>{{adultCount}}</h3>
                    <button>-</button>
                </div>
        </div>
        <div class="Child">
            <h2>Child</h2>
                <div class="counter-buttons">
                    <button>+</button>
                        <h3>{{childCount}}</h3>
                    <button>-</button>
                </div>
        </div>
        <div class="Senior">
            <h2>Senior</h2>
                <div class="counter-buttons">
                    <button>+</button>
                        <h3>{{adultCounter}}</h3>
                    <button>-</button>
                </div>
        </div>
    </div>
</template>

<script>
export default {
    adultCount: 0,
    childCount: 0,
    seniorCount: 0
}

</script>

<style>
.tickets-container{
    background-color: #EAEAEA;
    color: #231F20;
    border: 5px double #AD974F;
}

</style>