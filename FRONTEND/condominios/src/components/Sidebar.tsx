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
      <nav className="bg-red-600 w-full flex justify-end shadow-[0_0_0_100vmax_rgba(220,38,38,1)] clip-path py-5">
        <button onClick={openMenu} className='bg-blue-400'><RiHome3Line /></button>
        <ul className={`w-full flex fixed top-[0] bg-lime-700 h-screen  flex-col gap-8 list-none ${menuIsOpen ? 'left-full' : 'left-0'}`}>
          <button onClick={openMenu}><RiHome3Fill /></button>
          <h1 className="flex flex-row gap-4 text-center uppercase font-bold tracking-[4px]">
            <RiBuilding4Line />
            liveto
          </h1>
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
      <ul className={`w-full flex fixed top-[0] bg-lime-700 h-screen  flex-col gap-8 list-none ${menuIsOpen ? 'left-full' : 'left-0'}`}>
        <button onClick={openMenu}><RiHome3Fill /></button>
        <h1 className="flex flex-row gap-4 text-center uppercase font-bold tracking-[4px]">
          <RiBuilding4Line />
          liveto
        </h1>
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
    </div>

  )
}
