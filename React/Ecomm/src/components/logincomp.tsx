import axios from "axios";
import { useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../styles/logincomp.css";

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
            <div className="col-4">
                <div className="container">
                    <table>
                        <tr>
                            <td className="login-td">Username:</td>
                            <td className="login-td"><input ref={userinput} type="text" /></td>
                        </tr>
                        <tr>
                            <td className="login-td">Password:</td>
                            <td className="login-td"><input ref={passinput} type="password" /></td>
                        </tr>
                    </table>
                    <button className="btn btn-dark login" onClick={getData}>Login</button>
                </div>
            </div>
            <div className="col"></div>
        </>
    );
}