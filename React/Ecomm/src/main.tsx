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
import MainPagee from './Pages/mainadminpage.tsx'
import Itempage from './Pages/itempage.tsx'
import Itemadminpage from './Pages/itemadmin.tsx'
import Contactpage from './Pages/contactpage.tsx'
import Layoutadmin from './Pages/adminlayout.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
     <Routes>  
      <Route index element={<Home/>}/>
      <Route path="/login" element={<LoginPage/>}/> 
      <Route path="/register" element={<RegisterPage/>}/> 
        <Route path="/" element={<Layout/>}>
          <Route path="main" element={<MainPage/>}/>
          <Route path="cart" element={<CartPage/>}/>
          < Route path="item" element={<Itempage/>}/>
          < Route path ="contact" element={<Contactpage/>}/>
        </Route>
        </Routes>
        <Routes>
         <Route path="/admin" element={<Layoutadmin/>}>
           <Route path="/admin/main" element={<MainPagee/>}/> 
           <Route path="/admin/cart" element={<CartPage/>}/> 
           <Route path="/admin/item" element={<Itemadminpage/>}/>
           <Route path ="/admin/contact" element={<Contactpage/>}/>
         </Route>   
     </Routes>

   </BrowserRouter>
  </StrictMode>,
)
