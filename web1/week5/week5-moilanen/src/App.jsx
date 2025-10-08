import { useState } from 'react'
import './App.css'
import ProductList from './ProductList'
import Cart from './Cart'



function App() {
  // Luodaan ostoskori
  const [cart, setCart] = useState([])

  // Luodaan tuotteiden lista, array
  const products = [
    { id: 1, name: 'Web programming 1', points: 5 },
    { id: 2, name: 'Ohjelmointi 2', points: 8 },
    { id: 3, name: 'Suomen kieli ja viestintä', points: 2 },
    { id: 4, name: 'Tilastomatematiikka 1-3', points: 15 }
  ] 

  // Tuotteiden lisäys
  function addToCart(product) {
    setCart(prevCart => [...prevCart, product]) 
  }

  // Tuotteiden poisto
  function removeFromCart(product) {
    setCart(prevCart => prevCart.filter(productInCart => productInCart.id !== product.id))
  }

  // Palautetaan sisältö main.jsx:lle
  return (
    <div>
      <h1>Kurssitarjotin</h1>
      <ProductList listOfProducts={products} addToCart={addToCart}/>
      <br/>
      <Cart cart={cart} removeFromCart={removeFromCart}/>
    </div>
  )
}

export default App
