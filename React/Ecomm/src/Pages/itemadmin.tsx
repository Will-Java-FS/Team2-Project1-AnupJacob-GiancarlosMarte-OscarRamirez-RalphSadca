import Item from "../components/item.tsx";
import { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import { Button } from 'react-bootstrap';
import "../styles/item-admin-comp.css";

const Itemadminpage = () => {
  const titleinput = useRef<HTMLInputElement>(null);
  const descriptioninput = useRef<HTMLInputElement>(null);
  const priceinput = useRef<HTMLInputElement>(null);
  const category_idinput = useRef<HTMLInputElement>(null);
  const deleteTitleinput = useRef<HTMLInputElement>(null);
  const nameinput = useRef<HTMLInputElement>(null);
  //const imginput = useRef<HTMLInputElement>(null); 
  const cart_id = Number(localStorage.getItem("user_id"));

  const [items, setItems] = useState<any[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  // Fetch data
  const fetchItems = async () => {
    setLoading(true);
    setError(null);

    try {
      const response = await axios.get("http://localhost:8080/products");
      setItems(response.data);
    } catch (err) {
      console.error('Error fetching items:', err);
      setError('An error occurred while fetching items.');
    } finally {
      setLoading(false);
    }
  };

  const clearInputs = () => {
    if (titleinput.current) titleinput.current.value = '';
    if (descriptioninput.current) descriptioninput.current.value = '';
    if (priceinput.current) priceinput.current.value = '';
    if (category_idinput.current) category_idinput.current.value = '';
    if (deleteTitleinput.current) deleteTitleinput.current.value = '';
  };
  // Add a new item
  const addItem = async () => {
    if (!titleinput.current || !descriptioninput.current || !priceinput.current || !category_idinput.current) return;

    const title = titleinput.current.value;
    const description = descriptioninput.current.value;
    const price = parseFloat(priceinput.current.value);
    const category_id = parseInt(category_idinput.current.value);


    const addItemUrl = "http://localhost:8080/add-new-product";

    try {
      await axios.post(addItemUrl, {
        title,
        description,
        price,
        category_id


      });
      alert('Item added successfully!');
      fetchItems();
      clearInputs();
    } catch (err) {
      console.error('Error adding item:', err);
      alert('An error occurred while adding the item.');
    }
  };

  // Delete an item by title
  const deleteItemByTitle = async () => {
    if (!deleteTitleinput.current) return;

    const title = deleteTitleinput.current.value;
    const deleteItemUrl = `http://localhost:8080/product/${title}`;

    try {
      await axios.delete(deleteItemUrl);
      alert('Item deleted successfully!');
      fetchItems(); // Refresh the item list
      clearInputs();
    } catch (err) {
      console.error('Error deleting item:', err);
      alert('An error occurred while deleting the item.');
    }
  };

  // Fetch items when the component mounts
  useEffect(() => {
    fetchItems();
  }, []);

  const addCategory = async () => {
    if (!nameinput.current) return;

    const name = nameinput.current.value;
    const image_url: string = "https://images.theconversation.com/files/45159/original/rptgtpxd-1396254731.jpg?ixlib=rb-4.1.0&q=45&auto=format&w=1356&h=668&fit=crop";

    const addCategoryUrl = "http://localhost:8080/category";

    try {
      await axios.post(addCategoryUrl, { name, image_url });
      alert('Category added successfully!');
      // Refresh the category list
      clearInputs(); // Clear inputs after adding
    } catch (err) {
      console.error('Error adding category:', err);
      alert('An error occurred while adding the category.');
    }
  };
  useEffect(() => {
    fetchItems();
  }, []);



  return (
    <>
      <Container>
        <Row>
          {loading && <p>Loading...</p>}
          {error && <p style={{ color: 'red' }}>{error}</p>}
          {items.length > 0 && items.map(item => (
            <Item
              key={item.product_id}
              product_id={item.product_id}
              title={item.title}
              description={item.description}
              price={item.price}
              category={item.category.name}
              cart_id={cart_id}
              index={0} // Update the index as needed
            />
          ))}
        </Row>
      </Container>
      <div className="container">
        <br />
        <br />
        <table>
          <tr>
            <td><label>Title to Delete:</label></td>
            <td><input ref={deleteTitleinput} type="text" /></td>
          </tr>
          <tr>
            <td></td>
            <td><Button className="delete-btn" variant="danger" onClick={deleteItemByTitle}>Delete Item by Title</Button></td>
            <td></td>
          </tr>
          <br />
          <br />


          <tr>
            <td><label>Title:</label></td>
            <td><input ref={titleinput} type="text" /></td>
          </tr>
          <tr>
            <td><label>Description:</label></td>
            <td><input ref={descriptioninput} type="text" /></td>
          </tr>
          <tr>
            <td><label>Price:</label></td>
            <td><input ref={priceinput} type="number" step="0.01" /></td>
          </tr>
          <tr>
            <td><label>Category ID:</label></td>
            <td><input ref={category_idinput} type="number" /></td>
          </tr>
          <td></td>
          <td><Button className="add-comp-item" variant="primary" onClick={addItem}>Add Item</Button></td>

          <br />
          <br />
          <br />
          <tr>
            <td><label>Name:</label></td>
            <td><input ref={nameinput} type="text" /></td>
          </tr>
          <tr>
            <td></td>
            <td><Button onClick={addCategory}> Add Category </Button></td>
          </tr>
        </table>
      </div>
    </>
  );
};

export default Itemadminpage;
