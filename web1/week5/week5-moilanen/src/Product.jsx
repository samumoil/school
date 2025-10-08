import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function Product({ product, addToCart }) {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Body>
        <Card.Title>{product.name}</Card.Title><br/>
        <Card.Text>Pisteet: {product.points}</Card.Text>
        <Button onClick={() => addToCart(product)} variant="primary">Add to cart</Button>
      </Card.Body>
    </Card>
  );
}

export default Product;