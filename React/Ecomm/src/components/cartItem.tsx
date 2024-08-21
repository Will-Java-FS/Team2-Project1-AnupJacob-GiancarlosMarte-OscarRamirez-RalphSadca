import ListGroup from 'react-bootstrap/ListGroup';
import CloseButton from 'react-bootstrap/CloseButton';
import Card from 'react-bootstrap/Card';
import Image from 'react-bootstrap/Image';
import axios from 'axios';

export default function CartItem(props: {cart_item_id:number, title:string, price:number, quantity:number, image_url:string} ) {

    function handleRemoveCartItem() {
        axios.delete(`https://jsonplaceholder.typicode.com/posts/${props.cart_item_id}`)
            .then(response => {
            console.log(`Deleted post with ID ${props.cart_item_id}`);
        })
        .catch(error => {
        console.error(error);
        });
    }

    return (
        <>
            <Card style={{ width: '15rem', margin:'.15rem', height:'25rem'}}>
                <Card.Body>
                    <Image src="https://media.contentapi.ea.com/content/dam/news/www-ea/images/2022/09/ea-motive-new-title-teaser-16x9-featured.jpg.adapt.crop191x100.628p.jpg" fluid rounded/>
                </Card.Body>
                <Card.Body>
                    <Card.Title>{props.title}</Card.Title>
                    <Card.Text>description</Card.Text>
                </Card.Body>
                <ListGroup className="list-group-flush">
                    <ListGroup.Item>Price:{props.price}</ListGroup.Item>
                    <ListGroup.Item>Quantity:{props.quantity}</ListGroup.Item>
                </ListGroup>
                <Card.Body>
                    <Card.Text><CloseButton onClick={handleRemoveCartItem} style={{backgroundColor: 'rgba(255, 100, 100, 0.85)'}}/> Remove from Cart</Card.Text>
                </Card.Body>
            </Card> 
        </>
    )
}