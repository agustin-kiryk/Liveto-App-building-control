import './App.css';
import { Request, Home, Expenses, Amenities, Message, Login } from './pages/index';
import { Sidebar, UserInfo } from './components/index'
import { HashRouter, Route, Routes } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from './reduxHooks/reduxHooks';
import { increment } from './store/slices/counter.slice';



function App() {

  return (
    <HashRouter>
      <div className="px-6 bg-[#5F81FF]">
        <Sidebar />
        <div className='flex flex-col gap-y-3'>
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
