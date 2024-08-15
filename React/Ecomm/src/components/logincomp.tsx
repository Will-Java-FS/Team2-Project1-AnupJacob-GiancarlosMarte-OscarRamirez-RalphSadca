import { useRef, useState } from "react"

export  default function Login(){


 
    return(
        <>
        <h3>Login</h3>
        Username: <input type="text"/><br></br>
        Password: <input type="text"/><br></br>
        <button>Login</button>
        </>
    )
}