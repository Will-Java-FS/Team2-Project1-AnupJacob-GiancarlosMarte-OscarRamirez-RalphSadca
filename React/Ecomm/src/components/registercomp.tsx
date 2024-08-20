
import { useRef } from "react";
import { Link, useNavigate } from "react-router-dom";

export  default function Register(){
    const userinput=useRef<HTMLInputElement>(null)
    const passinput=useRef<HTMLInputElement>(null)
    const emailinput=useRef<HTMLInputElement>(null)
    const fnameinput=useRef<HTMLInputElement>(null)
    const lnameinput=useRef<HTMLInputElement>(null)
    const navigate = useNavigate();
function test(){
   // let a:string=document.getElementById("user");
   // let pas:string=document.getElementById("pass");
    const user=userinput.current!.value;
    const pas=passinput.current!.value;
    const email=emailinput.current!.value;
    const fname=fnameinput.current!.value;
    const lname=lnameinput.current!.value;
    if(user=="user"){
       
        alert("Please try again")
    }
    else{
        //console.log(a)
        //alert("Please try again")
        navigate("/main");
    }

}
 
return(
    <>
  
    Username: <input ref={userinput} type="text"/><br></br>
    Password: <input ref={passinput} type="text"/><br></br>
    Email: <input ref={emailinput} type="text"/><br></br>
    Firstname: <input ref={fnameinput} type="text"/><br></br>
    Lastname: <input ref={lnameinput} type="text"/><br></br>
    <button onClick={test}>Register</button>
    
    <Link to="/main">LoginLink</Link>
    </>
)
}