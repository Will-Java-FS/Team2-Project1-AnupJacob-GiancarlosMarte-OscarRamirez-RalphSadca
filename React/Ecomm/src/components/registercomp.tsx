import axios from "axios";
import { useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Register() {
    const userinput = useRef<HTMLInputElement>(null);
    const passinput = useRef<HTMLInputElement>(null);
    const emailinput = useRef<HTMLInputElement>(null);
    const fnameinput = useRef<HTMLInputElement>(null);
    const lnameinput = useRef<HTMLInputElement>(null);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    const registerUser = async () => {
        if (!userinput.current || !passinput.current || !emailinput.current || !fnameinput.current || !lnameinput.current) {
            setError("All fields are required.");
            return;
        }

        const username = userinput.current.value;
        const password = passinput.current.value;
        const email = emailinput.current.value;
        const fname = fnameinput.current.value;
        const lname = lnameinput.current.value;
        const role = 'USER';
        

        // Validate input fields
        if (!username || !password || !email || !fname || !lname) {
            setError("Please fill in all fields.");
            return;
        }

        // Here you should validate password strength, email format, etc.

        // Check if the username already exists
        // const checkUserUrl = `http://localhost:8080/users/username/${username}`;
        // try {
        //     const response = await axios.get(checkUserUrl);
        //     if (response.data) {
        //         setError("Username already exists. Please choose a different one.");
        //         return;
        //     }
        // } catch (error) {
        //     console.error("Error checking username:", error);
        //     setError("An error occurred while checking the username.");
        //     return;
        // }

        // Register the user
        const registerUrl = "http://localhost:8080/auth/register";
        try {
            await axios.post(registerUrl, {
                username,
                password,
                email,
                firstName: fname,
                lastName: lname,
                role
                
            });
            navigate("/main");
         } catch (error) {
             navigate("/login");
             console.error(error.response.data);
             //setError("An error occurred during registration.");
         }
    }

    return (
        <>
            <h2>Register</h2>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <form
                onSubmit={(e) => {
                    e.preventDefault();
                    registerUser();
                }}
            >
                <div>
                    <label>Username:</label>
                    <input ref={userinput} type="text" />
                </div>
                <div>
                    <label>Password:</label>
                    <input ref={passinput} type="password" />
                </div>
                <div>
                    <label>Email:</label>
                    <input ref={emailinput} type="email" />
                </div>
                <div>
                    <label>First Name:</label>
                    <input ref={fnameinput} type="text" />
                </div>
                <div>
                    <label>Last Name:</label>
                    <input ref={lnameinput} type="text" />
                </div>
                <button type="submit">Register</button>
            </form>
            <p>
                Already have an account? <Link to="/login">Login here</Link>
            </p>
        </>
    );
}
