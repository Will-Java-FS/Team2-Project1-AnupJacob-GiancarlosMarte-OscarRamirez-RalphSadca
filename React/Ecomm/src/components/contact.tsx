import Card from 'react-bootstrap/Card';
import Carousel from 'react-bootstrap/Carousel';

export function Contact(){

  return(
     <> 
     <Card className="text-center" style={{borderRadius:'0', padding:'5rem'}}>
     <Card.Header><Card.Title style={{fontSize:'2rem'}}>Get in touch, we'd love to hear from you!</Card.Title></Card.Header>
    <Carousel data-bs-theme="dark" style={{height:'15rem', paddingTop:'1rem'}}>
      <Carousel.Item>
         <Card className="text-center" style={{borderRadius:'0', padding:'5rem'}}>
            <Card.Title>Talk to a Human</Card.Title>
            <Card.Text>Our amazing customer support team is the #1 reason our customers choose Ecomm.
               Our customer support team is available to you 24/7. Just call the number below.
            </Card.Text>
            <Card.Text>770-234-7897</Card.Text>
         </Card>
      </Carousel.Item>
      <Carousel.Item>
         <Card className="text-center" style={{borderRadius:'0', padding:'5rem'}}>
         <Card.Title>Or Email Us</Card.Title>
            <Card.Text>You can also send us an email at your convenience, and we will respond within 2 hours.</Card.Text>
            <Card.Text>Ecomcustomersupport@gmail.com</Card.Text>
         </Card>
      </Carousel.Item>
    </Carousel>
    </Card>
     </>
     
  )
 }