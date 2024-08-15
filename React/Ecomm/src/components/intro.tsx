import { Link } from "react-router-dom";

export function Intro(){
   // const name = "Anup"
    //short for react.fragment <> </>
 return(
    <> 
    <h1>Hello, Welcome to our Ecomm App</h1>
    <p>Please login or register to go futher</p>
    <Link to="/login">Login</Link>
    <p>           </p>
    <Link to="/register">Register</Link>
    </>
    
 )
}