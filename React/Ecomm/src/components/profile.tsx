import axios from "axios";
import { useEffect, useState } from "react";

export default function Profile() {
    const [userData, setUserData] = useState<{ email: string; username: string; firstName:string;lastName:string} | null>(null);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    const getData = async () => {
        const id = localStorage.getItem("user_id");
        console.log(id)

        if (!id) {
            setError("User ID not found. Please log in.");
            setLoading(false);
            return;
        }

        const url = `http://localhost:8080/users/${id}`;

        try {
            const response = await axios.get(url);
            const userData = response.data;
            setUserData(userData);
        } catch (error) {
            console.error("Error fetching data:", error);
            setError("An error occurred. Please try again.");
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        getData();
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    if (error) {
        return <p style={{ color: 'red' }}>{error}</p>;
    }

    return (
        <div>
            <h2>User Profile</h2>
            {userData ? (
                <ul>
                    <li><strong>Username:</strong> {userData.username}</li>
                    <li><strong>Email:</strong> {userData.email}</li>
                    <li><strong>First Name:</strong> {userData.firstName}</li>
                    <li><strong>Last Name:</strong> {userData.lastName}</li>
                </ul>
            ) : (
                <p>No user data available.</p>
            )}
        </div>
    );
}