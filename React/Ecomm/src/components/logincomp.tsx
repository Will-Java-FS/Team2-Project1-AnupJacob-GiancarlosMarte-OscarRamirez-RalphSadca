//import { useRef, useState } from "react"

import { Link } from "react-router-dom";

export  default function Login(){


 
    return(
        <>
        <h3>Login</h3>
        Username: <input type="text"/><br></br>
        Password: <input type="text"/><br></br>
        <button>Login</button>
        <Link to="/main">LoginLink</Link>
        </>
    )
}