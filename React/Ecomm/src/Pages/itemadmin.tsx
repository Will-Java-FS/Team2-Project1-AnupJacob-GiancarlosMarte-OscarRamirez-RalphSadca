 import Item from "../components/item.tsx";
 import {useState, useEffect} from 'react';
 import axios from 'axios';
 import 'bootstrap/dist/css/bootstrap.css';
 import Container from 'react-bootstrap/Container';
 import Row from 'react-bootstrap/Row';

 const Itemadminpage=()=>{

     const [item, setItem] = useState('');

    const getData = async () => {
         const response = await axios.get("http://localhost:8080/products");
        setItem(response.data);
     }

     useEffect(() => {
         getData();
       }, []);

     return(
       <>
         <Container>
            <Row>
               {  
                 item && item.map && item.map((item) => (
                      <Item key={item.product_id} product_id={item.product_id} title={item.title} description={item.description} price={item.price} category={item.category.name} index={0}/>
               ))
               }
            </Row>
         </Container>
         </>
     )
 }

 export default Itemadminpage