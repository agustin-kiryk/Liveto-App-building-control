import './App.css';
import { Request, Home, Expenses, Amenities, Message, Login } from './pages/index';
import { Sidebar, UserInfo } from './components/index'
import { HashRouter, Route, Routes } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from './reduxHooks/reduxHooks';
import { increment } from './store/slices/counter.slice';



function App() {

  return (
    <HashRouter>
      <div className="flex">
        <Sidebar />
        <div className="w-full">
          <UserInfo />
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/request' element={<Request />} />
            <Route path='/expenses' element={<Expenses />} />
            <Route path='/amenities' element={<Amenities />} />
            <Route path='/message' element={<Message />} />
            <Route path='/login' element={<Login />} />
          </Routes>
        </div>
      </div>
    </HashRouter>
  );
}

export default App;
