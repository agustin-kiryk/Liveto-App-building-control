import React from 'react';
import { useForm, SubmitHandler } from 'react-hook-form';



type FormValues = {
  createRequest: string;
  areaRequest: string;
  descriptionRequest: string;
};

function Request() {
  const { register, handleSubmit, formState: { errors } } = useForm<FormValues>();
  const onSubmit: SubmitHandler<FormValues> = (data) => console.log(data);
  // console.log(errors);
  return (
    <div>
      <div>
        <h2>Reportes</h2>
        <table className="table-auto">
          <thead>
            <tr>
              <th>Ticket No.</th>
              <th>Fecha</th>
              <th>Asunto</th>
              <th>Estado</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>#143567</td>
              <td>22/09/22</td>
              <td>lorem ipsum</td>
              <td>En revision</td>
            </tr>
            <tr>
              <td>#113841</td>
              <td>14/06/21</td>
              <td>lorem ipsum</td>
              <td>Resuelto</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div>
        <form onSubmit={handleSubmit(onSubmit)}>
          <p>Que deseas hacer?</p>
          <select {...register("createRequest")}>
            <option value="Solicitar reparacion">Solicitar reparacion</option>
            <option value="Crear reporte">Crear reporte</option>
            <option value="Objeto encontrado/perdido">Objeto encontrado/perdido</option>
          </select>
          <p>Sobre que unidad/espacio?</p>
          <select {...register("areaRequest")}>
            <option value="Quincho">Quincho</option>
            <option value="Alberca">Alberca</option>
            <option value="Asador">Asador</option>
            <option value="Gimnasio">Gimnasio</option>
            <option value="otro">otro</option>
          </select>
          <textarea {...register("descriptionRequest", {})} />
          <input type="submit" />
        </form>

      </div>
    </div >
  );
};

export default Request;