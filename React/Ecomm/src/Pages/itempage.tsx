import Item from "../components/item.tsx";
import {useState, useEffect} from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';

const Itempage=()=>{

    const [item, setItem] = useState(''); 

    const cart_id = Number(localStorage.getItem("user_id"));

    const getItems = async () => {
        const response = await axios.get("http://localhost:8080/products");
        setItem(response.data);
    }

    useEffect(() => {
        getItems();
      }, []);

    return(
        <>
        <Container>
            <Row>
               {
               item && item.map && item.map((item) => (
                     <Item key={item.product_id} product_id={item.product_id} title={item.title} description={item.description} price={item.price} category={item.category.name} cart_id={cart_id}/>
                    ))
               }
            </Row>
         </Container>
        </>
    )
}
export default Itempage