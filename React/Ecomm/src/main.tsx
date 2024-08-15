import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import Layout from './Pages/layout.tsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Pages/home.tsx'
import Login from './components/logincomp.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
     <Routes>  
      <Route index element={<Home/>}/>
      <Route path="/login" element={<Login/>}/>
        <Route path="/" element={<Layout/>}>
           {/*<Route index element={<Home/>}/>*/}
       
        </Route>
     </Routes>

   </BrowserRouter>
  </StrictMode>,
)
