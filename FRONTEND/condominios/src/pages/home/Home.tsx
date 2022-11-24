import Message from "../message/Message";

export default function Home() {
    return (
        <div className="flex flex-col gap-y-4">
            <div className="bg-teal-200 py-4 px-6 flex flex-col gap-y-4 rounded-2xl border-solid border-gray-500 border-2">
                <div className="bg-red-500">
                    <h3>Estado de la cuenta
                    </h3>
                    <span>saldo</span>
                    <h2>-$5.840</h2>
                </div>
                <div className="bg-green-500 flex justify-between">
                    <div>
                        <p>Expensas totales</p>
                        <p>$25.360</p>
                    </div>
                    <p>Participacion:14%</p>
                </div>
                <div className="bg-yellow-500 flex justify-between">
                    <p>Vencimiento</p>
                    <p>10/01/2022</p>
                </div>
                <p className="text-center">Ver expensas</p>
            </div>
            <Message />
        </div>

    )
}
