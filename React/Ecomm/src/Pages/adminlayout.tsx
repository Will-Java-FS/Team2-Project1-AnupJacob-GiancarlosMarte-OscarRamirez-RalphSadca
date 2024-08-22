import {Outlet, Link} from "react-router-dom"

const Layoutadmin = () =>{
    return(
        <>
        <nav>
            <ul>
                <li>
                    <Link to="/admin/main">Home</Link>
                </li>
                <li>
                    <Link to="/admin/cart">Cart</Link>
                </li>
                <li>
                    <Link to="/admin/item">Items</Link>
                </li>
                <li>
                    <Link to="/admin/profile">Profile</Link>
                </li>
                <li>
                    <Link to="/admin/contact">Contact Us</Link>
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
export default Layoutadmin
