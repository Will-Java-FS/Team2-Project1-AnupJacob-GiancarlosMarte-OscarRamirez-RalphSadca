import axios from "axios";
import { useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Login() {
    const userinput = useRef<HTMLInputElement>(null);
    const passinput = useRef<HTMLInputElement>(null);
    const navigate = useNavigate();
    const [user, setUser] = useState<any>(null); 

    const getData = async () => {
        if (!userinput.current || !passinput.current) return;
        
        const username = userinput.current.value;
        const password = passinput.current.value;

        
        const url = `http://localhost:8080/users/username/${username}`;

        try {
            const response = await axios.get(url);
            const userData = response.data; 
            const { user_id } = response.data;

            // Save user ID in local storage
           

          
            if (password === userData.password && userData.role === "USER") {
                localStorage.setItem("user_id", user_id);
                navigate("/main");
            } else if (password === userData.password && userData.role === "ADMIN") {
                localStorage.setItem("user_id", user_id);
                navigate("/admin/main");
            } else {
                alert("Please try again");
            }
        } catch (error) {
            console.error("Error fetching data:", error);
            alert("An error occurred. Please try again.");
        }
    };

    return (
        <>
            Username: <input ref={userinput} type="text" /><br />
            Password: <input ref={passinput} type="password" /><br />
            <button onClick={getData}>Login</button>
            <Link to="/main">LoginLink</Link>
        </>
    );
}