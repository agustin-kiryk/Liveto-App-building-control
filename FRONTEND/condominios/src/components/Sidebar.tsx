import { useState } from 'react';
import {
  RiBuilding4Line,
  RiDashboardLine,
  RiMessage3Line,
  RiWallet2Line,
  RiCommunityFill,
  RiAlertFill,
  RiLogoutBoxLine,
  RiHome3Line,
  RiHome3Fill
} from 'react-icons/ri';

// box-shadow: 0 0 0 100vmax var(--secondary);
//   clip-path: inset(0 -100vmax);
import { Link, useNavigate } from 'react-router-dom';
export default function Sidebar() {
  const [menuIsOpen, setMenuIsOpen] = useState(false)
  const openMenu = () => {
    setMenuIsOpen(!menuIsOpen)

  }
  return (
    <div>
      <div className='bg-red-400 shadow-[0_0_0_100vmax_rgba(248,113,113,1)] clip-path'>
        <div className=' w-full flex justify-between py-2'>
          <h2 className="flex flex-row gap-4 text-center uppercase font-bold tracking-[4px] items-center">
            <RiBuilding4Line className='text-[2.5rem]' />
            liveto
          </h2>
          <button onClick={openMenu} className='bg-blue-400'><RiHome3Line className='text-[2.5rem]' /></button>
        </div>
      </div >
      <nav>
        <ul className={` w-full flex fixed h-screen items-center flex-col gap-y-11 py-12 overflow-auto list-none ${menuIsOpen ? 'left-full  ease-in-out duration-500' : 'left-0  ease-in-out duration-500'} `}>
          <li>
            <Link
              to='/'
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors text-2xl"
            >
              <RiDashboardLine className='text-[2rem]' />
              Escritorio
            </Link>
          </li>
          <li>
            <Link
              to="/expenses"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors text-2xl"
            >
              <RiWallet2Line className='text-[2rem]' />
              Gastos y expensas
            </Link>
          </li>
          <li>
            <Link
              to="/amenities"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors text-2xl"
            >
              <RiCommunityFill className='text-[2rem]' />
              Espacios comunes
            </Link>
          </li>
          <li>
            <Link
              to="/message"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors text-2xl"
            >
              <RiMessage3Line className='text-[2rem]' />
              Mensajes
            </Link>
          </li>
          <li>
            <Link
              to="/request"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors text-2xl"
            >
              <RiAlertFill className='text-[2rem]' />
              Reportes
            </Link>
          </li>
          <div>
            <Link
              to="/login"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors text-2xl bg-yellow-600"
            >
              <RiLogoutBoxLine className='text-[2rem]' />
              Salir de cuenta
            </Link>
          </div>
        </ul>
      </nav>
    </div>


  )
}
