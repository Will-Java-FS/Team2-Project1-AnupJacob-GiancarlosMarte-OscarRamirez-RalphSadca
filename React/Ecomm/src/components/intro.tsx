import { Link } from "react-router-dom";
import "../styles/intro.css"

export function Intro() {
   // const name = "Anup"
   //short for react.fragment <> </>
   return (
      <>
         <div className="container-fluid" id="imgchan">
            <div className="container-fluid" id="barchan"><span id="Brandname">Ecomm</span></div>
            <div id="intro">
               <h1>Welcome to our Ecomm App!</h1>
               <h4>We're thrilled to have you here.</h4>
               <p>At Ecomm, shopping is a breeze with our curated selection of products.<br />
                  Whether you're on the hunt for the latest trends, unique finds, or everyday essentials, we've got you covered.</p>
               <h3>Why Shop With Us?</h3>
               <p>
                  <p>
                     <span>Exclusive Deals:</span> Enjoy special discounts and promotions just for you.<br />
                     <span>Quality Selection:</span> Shop with confidence knowing we offer only the best.<br />
                     <span>Easy Navigation</span> Our user-friendly design makes finding what you need quick and simple.<br />
                     <span>Exceptional Service:</span> Our team is here to ensure a seamless shopping experience.
                  </p>

               </p>
               <br />
               <h2>Happy shopping!</h2>
               <p>Please login or register to go further.</p>
               <Link to="/login" className="btn btn-dark btn-md">Login</Link>
               <Link to="/register" className="btn btn-secondary btn-md">Register</Link>
            </div>
         </div >
      </>

   )
}