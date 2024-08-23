import axios from "axios";
import { useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../styles/register-comp.css";

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
            //navigate("/login");
            console.error(error.response.data);
            //setError("An error occurred during registration.");
        }
    }

    return (
        <>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <form
                onSubmit={(e) => {
                    e.preventDefault();
                    registerUser();
                }}
            >
                <table className="register-table">
                    <tr>
                        <td className="register-td"><label>Username:</label></td>
                        <td className="register-td"><input ref={userinput} type="text" /></td>
                    </tr>
                    <tr>
                        <td className="register-td"><label>Password:</label></td>
                        <td className="register-td"><input ref={passinput} type="password" /></td>
                    </tr>
                    <tr>
                        <td className="register-td"><label>Email:</label></td>
                        <td className="register-td"><input ref={emailinput} type="email" /></td>
                    </tr>
                    <tr>
                        <td className="register-td"><label>First Name:</label></td>
                        <td className="register-td"><input ref={fnameinput} type="text" /></td>
                    </tr>
                    <tr>
                        <td className="register-td"><label>Last Name:</label></td>
                        <td className="register-td"><input ref={lnameinput} type="text" /></td>
                    </tr>
                </table>
                <button className="btn btn-dark register-btn" type="submit">Register</button>
            </form>
            <p className="register-cap">
                Already have an account? <Link to="/login">Login here</Link>
            </p>
        </>
    );
}
