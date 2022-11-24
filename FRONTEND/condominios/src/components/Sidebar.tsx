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
    <div className='bg-red-400 shadow-[0_0_0_100vmax_rgb(248_113_113_1)] clip-path'>
      <div className='bg-green-600 w-full flex justify-between'>
        <h2 className="flex flex-row gap-4 text-center uppercase font-bold tracking-[4px] items-center">
          <RiBuilding4Line className='w-8 h-8' />
          liveto
        </h2>
        <button onClick={openMenu} className='bg-blue-400'><RiHome3Line className='w-8 h-8' /></button>
      </div>
      <nav className='w-full flex justify-end sticky top-0'>
        <ul className={`w-full flex fixed top-[0] h-screen items-center z-10 flex-col gap-8 list-none ${menuIsOpen ? 'left-full' : 'left-0'}`}>
          <button onClick={openMenu}><RiHome3Fill /></button>

          <li>
            <Link
              to='/'
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors"
            >
              <RiDashboardLine />
              Escritorio
            </Link>
          </li>
          <li>
            <Link
              to="/expenses"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors"
            >
              <RiWallet2Line />
              Gastos y expensas
            </Link>
          </li>
          <li>
            <Link
              to="/amenities"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors"
            >
              <RiCommunityFill />
              Espacios comunes
            </Link>
          </li>
          <li>
            <Link
              to="/message"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors"
            >
              <RiMessage3Line />
              Mensajes
            </Link>
          </li>
          <li>
            <Link
              to="/request"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors"
            >
              <RiAlertFill />
              Reportes
            </Link>
          </li>
          <div>
            <Link
              to="/login"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors bg-yellow-600"
            >
              <RiLogoutBoxLine />
              Salir de cuenta
            </Link>
          </div>
        </ul>
      </nav>
    </div >

  )
}
