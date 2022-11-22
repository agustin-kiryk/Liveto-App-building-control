import {
  RiBuilding4Line,
  RiDashboardLine,
  RiMessage3Line,
  RiWallet2Line,
  RiCommunityFill,
  RiAlertFill,
  RiLogoutBoxLine,
} from 'react-icons/ri';
import { Link, useNavigate } from 'react-router-dom';
export default function Sidebar() {


  return (
    <nav className=" flex flex-col justify-evenly bg-purple-800 w-min px-8 h-screen">
      <h1 className="flex flex-row gap-4 text-center uppercase font-bold tracking-[4px]">
        <RiBuilding4Line />
        liveto
      </h1>
      <ul className=" bg-lime-700 h-3/4 flex flex-col gap-8 list-none">
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
      </ul>
      <div>
        <Link
          to="/login"
          className="flex items-center gap-4 font-semibold hover:bg-blue-300 hover:font-bold rounded-lg transition-colors bg-yellow-600"
        >
          <RiLogoutBoxLine />
          Salir de cuenta
        </Link>
      </div>
    </nav>
  )
}
