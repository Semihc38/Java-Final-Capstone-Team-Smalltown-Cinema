<template>
    <div class="seat-ticket-container">
        <div class="seats-container">
            <seat-card v-on:click.native="selectSeats(seat.name)" v-for="seat in this.seats" v-bind:key="seat.name" v-bind:seat="seat" />
        </div>
        <div class="tickets-container">
            <h1>Select Tickets</h1>
            <div class="Adult">
                <h2>Adult</h2>
                <div class="counter-buttons">
                    <button v-on:click="incrementAdultCount(), totalTicketCount(), calculateTotalCost()">+</button>
                        <h3>{{adultCount}}</h3>
                    <button v-on:click="decrementAdultCount(), totalTicketCount(), calculateTotalCost()">-</button>
                </div>
            </div>
            <div class="Child">
                <h2>Child</h2>
                <div class="counter-buttons">
                    <button v-on:click="incrementChildCount(), totalTicketCount(), calculateTotalCost()">+</button>
                        <h3>{{childCount}}</h3>
                    <button v-on:click="decrementChildCount(), totalTicketCount(), calculateTotalCost()">-</button>
                </div>
            </div>
            <div class="Senior">
                <h2>Senior</h2>
                <div class="counter-buttons">
                    <button v-on:click="incrementSeniorCount(), totalTicketCount(), calculateTotalCost() ">+</button>
                        <h3>{{seniorCount}}</h3>
                    <button v-on:click="decrementSeniorCount(), totalTicketCount(), calculateTotalCost()">-</button>
                </div>
            </div>
                <div class="total-tickets">
                    <h2>Total Tickets</h2>
                    <h3>{{totalTickets}}</h3>
                </div>
                   <div class="total-cost">
                    <h2>Total Cost</h2>
                    <h3>${{totalCost}}.00</h3>
                </div>
        </div>
        <div class="form-container">
            <h1>Checkout</h1>
            <form class="checkout-form">
                <label for="fname">Full Name:</label><br>
                <input type="text" id="fname" name="fname"><br>
                <label for="email">Email:</label><br>
                <input type="text" id="email" name="email">
                <label for="billing">Billing Address:</label><br>
                <input type="text" id="billing" name="billing"><br>
                <label for="checkout">Checkout</label><br>
                <input type="submit" id="checkout" name="checkout"><br>
            </form>
        </div>
    </div>
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import SeatCard from './SeatCard.vue'

export default {
    components: {
        SeatCard
    },
    prop: ['seat'],
    name:'seats',
    data(){
        return {
            selectedCount: 0,
            movie: [],
            showtimes: [],
            seats: [],
            selectedSeats: [],
            adultCount: 0,
            childCount: 0,
            seniorCount: 0,
            totalTickets: 0,
            totalCost: 0
        }
    },
    methods:{
      incrementAdultCount(){
            if(this.totalTickets < this.seats.length){
            this.adultCount += 1;
            }  
        },
         incrementChildCount(){
            if(this.totalTickets < this.seats.length) {
            this.childCount += 1;
            }           
        },
          incrementSeniorCount(){
            if(this.totalTickets < this.seats.length) {
            this.seniorCount += 1;
            }
        },
         decrementAdultCount(){
             if(this.adultCount > 0) {
             this.adultCount -= 1;
             }
        },
         decrementChildCount(){
             if(this.childCount > 0) {
             this.childCount -= 1;
             }
        },
          decrementSeniorCount(){
            if(this.seniorCount > 0) {
            this.seniorCount -= 1;
            } 
        },
        totalTicketCount() {
            this.totalTickets = this.seniorCount + this.childCount +  this.adultCount;
        },
        selectSeats(seatName){
            if((this.selectedCount < this.totalTickets) && !this.selectedSeats.includes(seatName)){
               this.selectedSeats.push(seatName);
               this.selectedCount += 1;
            }
            
        },
        bookSeats(){
            let i;
            for(i = 0; i < this.selectedSeats.length; i++) {
                applicationServices.bookSeatByShowtimeIdAndSeatName(this.$route.params.id, this.selectedSeats[i]);
            }
            
        },
        calculateTotalCost(){
            if(this.showtimes.matinee === true){
                this.totalCost = (this.childCount * 8) + (this.adultCount * 13) + (this.seniorCount * 10);
            } else {
                this.totalCost = (this.childCount * 10) + (this.adultCount * 15) + (this.seniorCount * 12);
            }
        }
    },
    created(){
      applicationServices.getSeatsByShowtimeId(this.$route.params.id).then(response => {
          this.seats = response.data;
      })

      applicationServices.getMovieByShowtimeId(this.$route.params.id).then(response => {
          this.movie = response.data;
      })

      applicationServices.getShowtimeByShowtimeId(this.$route.params.id).then(response => {
          this.showtimes = response.data;
      })

    }
}
</script>

<style>

.seats-container {
    width: 50%;
    margin: auto;
    row-gap: 10%;
    display: grid;
    grid-template-columns:  1fr 1fr 1fr 1fr;
    justify-content: center;
    flex-wrap: wrap;
    padding-bottom: 20%;
}

.tickets-container{
    background-color: #EAEAEA;
    color: #231F20;
    border: 5px double #AD974F;
}

.seat-ticket-container{
    display: grid;
    grid-template-columns: 2fr, 1fr;
    grid-template-rows: 2fr, 1fr;
    grid-template-areas: 'heading heading'
                        'tickets-container seats-container'
                        'form-container .';
}

input[type=submit] {
  background-color:#AD974F;
  color: #EAEAEA;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=text], select, textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}
.form-container{
    padding-top: 10%;
}
</style>