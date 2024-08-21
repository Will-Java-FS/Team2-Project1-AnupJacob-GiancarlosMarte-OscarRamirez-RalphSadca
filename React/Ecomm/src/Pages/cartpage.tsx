import { Main } from "../components/maincomp"
import CartItem from "../components/cartItem.tsx";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import axios from "axios";
import { useState, useEffect } from 'react';

const CartPage = () => {

    const [cartItems, setCartItems] = useState('');

    const user_id = Number(localStorage.getItem("user_id"));

    const getCartItems = async () => {
        const response = await axios.get(`http://localhost:8080/get-cart-items/${user_id}`);
        setCartItems(response.data);
    }

    console.log(cartItems);

    useEffect(() => {
        getCartItems();
      }, []);

    return(
        <>
        <h1>In your Cart</h1>
        <Main/>
        <button>Buy</button>

        <Container>
            <Col>
                <Row>
                    {
                    cartItems && cartItems.map && cartItems.map((cartItems) => (
                    <CartItem key={cartItems.cart_item_id} cart_item_id={cartItems.cart_item_id} title={cartItems.product.title} price={cartItems.product.price} quantity={cartItems.quantity} image_url={cartItems.image_url}/>
                    ))
                    }
                </Row>
            </Col>
        </Container>
        </>
    )
} 
export default CartPage