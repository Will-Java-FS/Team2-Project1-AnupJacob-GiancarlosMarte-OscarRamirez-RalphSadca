import { Outlet, Link } from "react-router-dom"
import "../styles/layout.css"

const Layout = () => {
    return (
        <>
            <div id="nav" >

                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                    <a className="navbar-brand" >Ecomm</a>

                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">

                            <li className="nav-item active">
                                <Link className="nav-link" to="/main">Home</Link>
                            </li>

                            <li className="nav-item">
                                <Link className="nav-link" to="/cart">Cart</Link>
                            </li>

                            <li className="nav-item">
                                <Link className="nav-link" to="/item">Items</Link>
                            </li>

                            <li className="nav-item">
                                <Link className="nav-link" to="/contact">Contact Us</Link>
                            </li>

                            <li className="nav-item">
                            </li>

                        </ul>
                    </div>
                    <span className="navbar-text"> <Link className="nav-link" to="/profile">Profile</Link> </span>
                    <span className="navbar-text"> <Link className="nav-link" to="/">Log out</Link> </span>

                </nav>
            </div>
            <Outlet />
        </>
    )
}
export default Layout
