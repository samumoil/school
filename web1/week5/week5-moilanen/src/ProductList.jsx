import Product from "./Product";

function ProductList({listOfProducts, addToCart}) {

    return(
        listOfProducts.map(product => 
            <Product key={product.id} product={product} addToCart={addToCart}/>
        )
    );
    
}

export default ProductList;