//import { useRef, useState } from "react"

import { Link } from "react-router-dom";

export  default function Login(){


 
    return(
        <>
      
        Username: <input type="text"/><br></br>
        Password: <input type="text"/><br></br>
        
        <Link to="/main">LoginLink</Link>
        </>
    )
}