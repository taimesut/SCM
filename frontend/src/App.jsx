import React, { useReducer } from 'react'
import Navbar from './components/Navbar'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Register from './components/Register'
import Login from './components/Login'
import Home from './components/Home'
import Footer from './components/Footer'
import Product from './components/Product'
import Cart from './components/Cart'
import Dashboard from './components/Dashboard'
import { MyDispatchContext } from './context/MyDispatchContext'
import { MyUserContext } from './context/MyUserContext'
import MyUserReducer from './reducer/MyUserReducer'
import MyCartReducer from './reducer/MyCartReducer'
import { MyCartContext } from './context/MyCartContext'
import Success from './components/Success'
import Cancel from './components/Cancel'

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, null);
  const [cart, cartDispatch] = useReducer(MyCartReducer, 0);
  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
        <MyCartContext.Provider value={[cart, cartDispatch]}>
        <Router>
          <Navbar />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            <Route path="/products" element={<Product />} />
            <Route path="/cart" element={<Cart />} />
            <Route path="/dashboard/purchase/:key" element={<Dashboard />} />
            <Route path="/success" element={<Success />} />
            <Route path="/cancel" element={<Cancel />} />
          </Routes>
          <Footer />
        </Router>
        </MyCartContext.Provider>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>


  )
}

export default App