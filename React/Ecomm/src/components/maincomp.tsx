import axios from 'axios';
import { useState } from 'react';
import { Button, Card } from 'react-bootstrap';

interface Product {
  category: string;
  id: string;
  title: string;
  description: string
  price: number
  // Add other product fields as needed
}

export function Main() {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const getData = async (category: string) => {
    console.log(`Selected category: ${category}`);
    const url = `http://localhost:8080/products/${category}`;
    setLoading(true);
    setError(null);

    try {
      const response = await axios.get(url);
      const productData: Product[] = response.data; 
      setProducts(productData); // Update state with fetched products
      console.log('Fetched products:', productData);
    } catch (error) {
      console.error('Error fetching data:', error);
      setError('An error occurred. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <p>Categories</p>
      <ul>
        <li>
          <button onClick={() => getData('5')}>
            <img
              src="src/assets/GundamR.png"
              alt="Freedom Gundam"
              width="150"
              height="150"
            />
          </button>
          Toys
        </li>
        <li>
          <button onClick={() => getData('6')}>
            <img
              src="src/assets/ff7gamecase.png"
              alt="FF7 Videogame"
              width="150"
              height="150"
            />
          </button>
          Videogame
        </li>
        <li>
          <button onClick={() => getData('3')}>
            <img
              src="src/assets/laptop.png"
              alt="Acer Laptop"
              width="150"
              height="150"
            />
          </button>
          Electronic
        </li>
        <li>
          <button onClick={() => getData('2')}>
            <img
              src="src/assets/shirt.png"
              alt="T-Shirt"
              width="150"
              height="150"
            />
          </button>
          Clothes
        </li>
        <li>
          <button onClick={() => getData('4')}>
            <img
              src="src/assets/Tool.png"
              alt="Tool Kit"
              width="150"
              height="150"
            />
          </button>
          Tools
        </li>
      </ul>

      {loading && <p>Loading...</p>}
      {error && <p style={{ color: 'red' }}>{error}</p>}
      
     { /* <div>
        {products.length > 0 && (
          <ul>
            {products.map(product => (
              <li key={product.id}>{product.title} {product.price}</li>
            ))}
          </ul>
        )}
      </div> */}
      {products.map(product => (
      <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="path/to/image.jpg" />
      <Card.Body>
        <Card.Title>{product.title}</Card.Title>
        <Card.Text>Description: {product.description}</Card.Text>
        <Card.Text>Price: {product.price}</Card.Text>
         <Card.Text>Catergory: {product.category.name}</Card.Text> 
        <Button variant="primary">Add to cart</Button>
      </Card.Body>
    </Card>
      ))}
    </>
  );
}