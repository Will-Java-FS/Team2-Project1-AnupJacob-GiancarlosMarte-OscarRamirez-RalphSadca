
import { useRef } from "react";
import { Link, useNavigate } from "react-router-dom";

export  default function Register(){
    const userinput=useRef<HTMLInputElement>(null)
    const passinput=useRef<HTMLInputElement>(null)
    const navigate = useNavigate();
function test(){
   // let a:string=document.getElementById("user");
   // let pas:string=document.getElementById("pass");
    const user=userinput.current!.value;
    const pas=passinput.current!.value;
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
    <button onClick={test}>Register</button>
    
    <Link to="/main">LoginLink</Link>
    </>
)
}