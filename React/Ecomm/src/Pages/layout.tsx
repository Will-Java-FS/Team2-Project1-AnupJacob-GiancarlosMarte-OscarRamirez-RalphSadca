import {Outlet, Link} from "react-router-dom"

const Layout = () =>{
    return(
        <>
        <nav>
            <ul>
                <li>
                    <Link to="/main">Home</Link>
                </li>
                <li>
                    <Link to="/cart">Cart</Link>
                </li>
                <li>
                    <Link to="/item">Items</Link>
                </li>
                <li>
                    <Link to="/profile">Profile</Link>
                </li>
                <li>
                    <Link to="/contact">Contact Us</Link>
                </li>
                <li>
                    <Link to="/">Log Out</Link>
                </li>
            </ul>
        </nav>
        <Outlet/>
        </>
    )
}
export default Layout
