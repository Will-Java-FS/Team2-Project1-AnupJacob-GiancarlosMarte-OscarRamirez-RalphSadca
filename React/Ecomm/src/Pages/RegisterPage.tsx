//import Login from "../components/logincomp"
import Register from "../components/registercomp"
import "../styles/register.css";

const RegisterPage = () => {
    return (
        <>
            <div className="container-fluid" id="imgchan">
                <div className="container-fluid" id="barchan"><span id="Brandname">Ecomm</span></div>
                <h3 className="register-h3">Sign up!</h3>
                <Register />
            </div>
        </>
    )
}
export default RegisterPage