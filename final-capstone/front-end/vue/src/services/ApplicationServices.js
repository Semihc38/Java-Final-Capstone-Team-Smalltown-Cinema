/**************************************************************************************
* This file is provided for you to use for any Application services you may create
*
*  If you would prefer a file with a different name for your services, 
*     simply create one 
***************************************************************************************/
import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:8080"
});
export default{
    getFeaturedMovies(){
        return http.get('/featuredMovies');
    },
    getShowtimesByMovieId(id){
        return http.get(`/showtimes/${id}`);
    },
    getChosenMovie(id){
        return http.get(`/featuredMovies/${id}`);
    }

}