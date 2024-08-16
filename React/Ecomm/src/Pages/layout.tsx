import {Outlet, Link} from "react-router-dom"

const Layout = () =>{
    return(
        <>
        <nav>
            <ul>
                <li>
                    <Link to="/main">Home</Link>
                </li>
                {/*<li>
                    <Link to="/login">Login</Link>
                </li>
                <li>
                    <Link to="/register">Register</Link>
                </li>*/}
                <li>
                    <Link to="/cart">Cart</Link>
                </li>
                <li>
                    <Link to="/item">Items</Link>
                </li>
            </ul>
        </nav>
        <Outlet/>
        </>
    )
}
export default Layout
