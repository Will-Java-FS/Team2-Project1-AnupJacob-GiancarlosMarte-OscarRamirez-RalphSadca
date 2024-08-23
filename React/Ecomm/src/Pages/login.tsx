import Login from "../components/logincomp"
import "../styles/login.css"

const LoginPage = () => {
    return (
        <>
            <div className="container-fluid" id="imgchan">
                <div className="container-fluid" id="barchan"><span id="Brandname">Ecomm</span></div>
                <h3 className="login-h3">Please login:</h3>
                <Login />
            </div>
        </>
    )
}
export default LoginPage