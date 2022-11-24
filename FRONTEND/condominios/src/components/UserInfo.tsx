import { RiNotification3Fill } from 'react-icons/ri'

export default function UserInfo() {
    return (
        <div className="bg-red-300 w-full flex justify-between items-center py-4 px-6">
            <h1><span>Buen dia,</span> Emiliano</h1>
            <div className=" flex w-1/3 justify-end border-2 rounded-md border-solid border-gray-400">
                <div className="w-full flex justify-evenly items-center">
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
