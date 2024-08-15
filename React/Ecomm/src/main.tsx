import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
//import App from './App.tsx'
import './index.css'
import Layout from './Pages/layout.tsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Pages/home.tsx'
import MainPage from './Pages/mainpage.tsx'
import CartPage from './Pages/cartpage.tsx'
import RegisterPage from './Pages/RegisterPage.tsx'
import LoginPage from './Pages/login.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
     <Routes>  
      <Route index element={<Home/>}/>
      <Route path="/login" element={<LoginPage/>}/> 
      <Route path="/register" element={<RegisterPage/>}/> 
        <Route path="/" element={<Layout/>}>
          <Route path="/main" element={<MainPage/>}/>
          <Route path="/cart" element={<CartPage/>}/> 

           {/*<Route index element={<Home/>}/>*/}
       
        </Route>
     </Routes>

   </BrowserRouter>
  </StrictMode>,
)
