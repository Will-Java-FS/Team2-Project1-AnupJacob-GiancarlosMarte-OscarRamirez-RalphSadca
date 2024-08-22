import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.css';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import { useState } from 'react';
import axios from 'axios';

export default function Item(props: {product_id:number, title:string, description:string, price:number, category:string, cart_id:number}) {

   const [count, setCount] = useState(1);

   function handleDecrease(){
      if(count > 1){
         setCount(prevCount => prevCount - 1);
      } 
   }

   function handleIncrease(){
      setCount(prevCount => prevCount + 1);
   }

   function handleClickAddToCart(){
      axios.post("http://localhost:8080/add-cart-item", {
        product: {
            product_id: props.product_id,
        },
        cart: {
            cart_id: props.cart_id,
        },
        quantity: count
       })
       .then((response) => console.log(response.data))
       .then((error) => console.log(error));
   }

   return(
     <> 
      <Card style={{ width: '18rem', margin: '.3rem' }}> 
            <Card.Body>
               <Card.Title>{props.title}</Card.Title>
               <Card.Text>Description: {props.description}</Card.Text>
               <Card.Text>Price: {props.price} usd</Card.Text>
               <Card.Text>Category: {props.category}</Card.Text>
               <ButtonGroup className="me-2" aria-label="First group">
                  <Button variant="secondary" onClick={handleDecrease}>-</Button>{' '}
                  <Button variant="secondary">{count}</Button>{' '}
                  <Button variant="secondary" onClick={handleIncrease}>+</Button>
               </ButtonGroup>
               <Button variant="primary" onClick={handleClickAddToCart}>Add to Cart</Button>
            </Card.Body>
      </Card>
     </>
  )
 }