import { Main } from "../components/maincomp"
import CartItem from "../components/cartItem.tsx";
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import axios from "axios";
import { useState, useEffect } from 'react';


const CartPage = () => {
    
    const [cartItems, setCartItems] = useState('');
    const [totalPrice, setTotalPrice] = useState(0);
    const user_id = Number(localStorage.getItem("user_id"));
    const getCartItems = async () => {
        const response = await axios.get(`http://localhost:8080/get-cart-items/${user_id}`);
        setCartItems(response.data);
    } 

    // doubling priceReduction because useEffect is running twice - might be misusing the hook
    function updateCheckoutPriceOnDelete(priceReduction:number){
        setTotalPrice((prevTotalPrice => prevTotalPrice - (priceReduction *2)));
    }

    function deleteCartItem(cart_item_id:number, priceReduction:number) {
        axios.delete(`http://localhost:8080/delete-cart-item/${cart_item_id}`) 
            .then(getCartItems)
            .then(updateCheckoutPriceOnDelete(priceReduction))
        .catch(error => {
        console.error(error);
        });
    }

    function returnPrice(price:number){
        setTotalPrice((prevTotalPrice => (prevTotalPrice + price)));
    }

    useEffect(() => {
        getCartItems();
    },[]);

    return(
        <>
        <Container fluid style={{paddingLeft:'15rem', paddingRight:'10rem'}}>
            <Col>
                <Row>
                    {
                    cartItems && cartItems.map && cartItems.map((cartItems) => (
                    <CartItem key={cartItems.cart_item_id} cart_item_id={cartItems.cart_item_id} title={cartItems.product.title} price={cartItems.product.price} quantity={cartItems.quantity} image_url={cartItems.image_url} deleteCartItem={deleteCartItem} returnPrice={returnPrice}/>
                ))
                    }
                </Row>
            </Col>
            <Row>
                <InputGroup className="mb-3" style={{width:'92rem', paddingTop:'1rem'}}>
                <Form.Control placeholder="Enter Discount Code Here" aria-label="Enter Discount Code Here"aria-describedby="basic-addon2"/>
                <Button variant="outline-secondary" id="button-addon2">Apply</Button>
                </InputGroup>
                <button style={{width:'92rem'}}>Total Price: {(((totalPrice)/2).toFixed(2))}, Proceed?</button> 
            </Row>
        </Container>
        </>
    )
} 
export default CartPage