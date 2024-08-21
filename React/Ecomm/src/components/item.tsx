import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.css';

export default function Item(props: {index:number, product_id:number, title:string, description:string, price:number}) {

   return(
     <> 
      <Card style={{ width: '18rem', margin: '.3rem' }}> 
            {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
            <Card.Body>
               <Card.Title>{props.title}</Card.Title>
               <Card.Text>Description: {props.description}</Card.Text>
               <Card.Text>Price: {props.price}</Card.Text>
               {/* <Card.Text>Catergory: {props.category}</Card.Text> */}
               <Button variant="primary">Add to Cart</Button>
            </Card.Body>
      </Card>
     </>
  )
 }