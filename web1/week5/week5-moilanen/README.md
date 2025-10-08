# Week 5 tasks

We want to create a Shopping App where users can see a list of products, add them to a shopping cart, and view the cart's contents. Use vite to create the structure of the project

## Steps:

### App Component (Main Component):

Create the main App component that holds the state for the list of products and the shopping cart.

### ProductList Component (Props):

Create a ProductList component that receives the list of products as a prop and renders a list of Product components.

### Product Component (Props):

Create a Product component that receives the product details (name, price, etc.) as props.

This component should have a button labeled “Add to Cart” which triggers a function passed from ProductList (also passed to it as a prop from App) to add that product to the cart.

### Cart Component (State):

Create a Cart component that displays the items added to the cart.

The Cart component should use state to manage the list of products added.

Display the product name and price in the cart and calculate the total price dynamically.

### Add and Remove from Cart Functionality:

Create functions in the App component to handle adding products to the cart and removing them.

Pass the addToCart and removeFromCart functions as props to the appropriate components.

### Bonus (Optional):

Add a button in the cart to increase or decrease the quantity of each product.

Add a message if the cart is empty.

