import { RiNotification3Fill } from 'react-icons/ri'

export default function UserInfo() {
    return (
        <div className="bg-red-300 w-full flex justify-evenly items-center h-min col-start-2">
            <h1><span>Buen dia,</span> Emiliano</h1>
            <div className="bg-blue-200 flex w-1/3 justify-end">
                <div className="w-full flex justify-evenly">
                    <RiNotification3Fill />
                    <select name="house">
                        <option value="house1">House 1</option>
                        <option value="house2">House 2</option>
                    </select>
                </div>
            </div>
        </div>
    )
}
