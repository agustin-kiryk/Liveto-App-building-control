
import {
  RiBuilding4Line,
  RiDashboardLine,
  RiMessage3Line,
  RiWallet2Line,
  RiCommunityFill,
  RiAlertFill,
  RiLogoutBoxLine,
} from 'react-icons/ri';



import './App.css';

function App() {
  return (

    <div className="min-h-screen grid grid-cols-6">
      <div className=" col-span-1 p-8 ">
        {/* Logotipo */}
        <div className="flex flex-row text-center p-8">
          <h1 className="flex flex-row gap-4 text-center uppercase font-bold tracking-[4px]">
            {' '}
            <RiBuilding4Line />
            liveto
          </h1>
        </div>
        <div className=" flex flex-col justify-between h-[530px]">
          {/* Menu */}
          <nav>
            <ul>
              <li>
                <a
                  href="#"
                  className="flex items-center gap-4 font-semibold hover:bg-blue-300 p-2 hover:font-bold rounded-lg transition-colors"
                >
                  <RiDashboardLine />
                  Escritorio
                </a>
              </li>

              <li>
                <a
                  href="#"
                  className="flex items-center gap-4 font-semibold hover:bg-blue-300 p-2 hover:font-bold rounded-lg transition-colors"
                >
                  <RiWallet2Line />
                  Gastos y expensas
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="flex items-center gap-4 font-semibold hover:bg-blue-300 p-2 hover:font-bold rounded-lg transition-colors"
                >
                  <RiCommunityFill />
                  Espacios comunes
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="flex items-center gap-4 font-semibold hover:bg-blue-300 p-2 hover:font-bold rounded-lg transition-colors"
                >
                  <RiMessage3Line />
                  Mensajes
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="flex items-center gap-4 font-semibold hover:bg-blue-300 p-2 hover:font-bold rounded-lg transition-colors"
                >
                  <RiAlertFill />
                  Reportes
                </a>
              </li>
            </ul>
          </nav>
          {/* Boton de cerrar sesion */}
          <div>
            <a
              href="#"
              className="flex items-center gap-4 font-semibold hover:bg-blue-300 p-2 hover:font-bold rounded-lg transition-colors"
            >
              <RiLogoutBoxLine />
              Salir de cuenta
            </a>
          </div>
        </div>
      </div>
      <div className=" col-span-5">Hola2</div>

    <div className="App">
      <div>
        <h1 className="text-3xl bg-red-600">Inicio de Proyecto</h1>
      </div>

    </div>
    </div>
  );
}

export default App;
