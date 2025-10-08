import Button from 'react-bootstrap/Button';

function Cart({cart, removeFromCart}) {
    const totalPoints = cart.reduce((sum, product) =>
        sum + product.points, 0
    )

    return (
        <div>
            {totalPoints === 0 ? (
                <p>Ostoskori on tyhjä!</p>
            ) : (
                <>
                {cart.map(product =>
                    <div key={product.id}>
                        {product.name}, pisteet {product.points}<Button onClick={() => removeFromCart(product)} variant="primary">Remove</Button>
                    <br/>
                    </div>
                )}
                <hr />
                Yhteensä {totalPoints} pistettä
                </>
            )}
        </div>
    )
}

export default Cart;