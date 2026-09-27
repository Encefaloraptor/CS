function init(){
   actualizarTabla();
}
/*********************************************************
 * Actualización de la vista de empleados
 *********************************************************/
async function actualizarTabla() {
  const empleados = await api_get('/empleado');
  construirTabla(empleados);
}

/*********************************************************
 * Gestión del CRUD
 *********************************************************/

var modalForm = document.getElementById('modalForm');
var nuevoEmpleadoBtn = document.getElementById('nuevoEmpleadoBtn');
var okBtn = document.getElementById('okBtn');
var cancelBtn = document.getElementById('cancelBtn');
var nombre = document.getElementById('nombre');
var email = document.getElementById('email');
var salario = document.getElementById('salario');
var idEmpleado=0;
var enActivo;

nuevoEmpleadoBtn.addEventListener('click', () => { idEmpleado = 0; openModal() });

okBtn.addEventListener('click', async () => {
  const empleadoData = {
    id: idEmpleado,
    nombre: nombre.value,
    email: email.value,
    salario: salario.value,
  };
  if (idEmpleado === 0)  {
      if (await api_post('/empleado', empleadoData)==true)
             actualizarTabla();
  }
  else{
    if ( await api_put('/empleado/',  idEmpleado, empleadoData)==true)
      actualizarTabla();
  }
  closeModal();
});

cancelBtn.addEventListener('click', closeModal);

function openModal() {
  modalForm.style.display = 'flex';
  nombre.value = '';
  email.value = '';
  salario.value = '';
}

function closeModal() {
  modalForm.style.display = 'none'; 
}

function modificarEmpleado (id) {
  idEmpleado=id; openModal();
}

async function eliminarEmpleado (id) {
  if (await api_delete('/empleado/',id)==true)
            actualizarTabla();
}

/******************************************************************
 * Crear tabla empleados, dinamica desde datos del servidor
 * ****************************************************************/

function construirTabla(empleados) {
  document.getElementById('tablaEmpleadosBody').innerHTML = '';
  empleados.forEach(empleado => {
    agregarFilaATabla(empleado);
  });
}

function agregarFilaATabla(empleado) {
  const tablaBody = document.getElementById('tablaEmpleadosBody');
  const fila = document.createElement('tr');
  fila.innerHTML = `
        <td>${empleado.id}</td>
        <td>${empleado.nombre}</td>
        <td>${empleado.email}</td>
        <td>${empleado.salario}</td>
        <td>
          <button onclick="modificarEmpleado(${empleado.id})">Modificar</button>
          <button onclick="eliminarEmpleado(${empleado.id})">Borrar</button>
        </td>
      `;
  tablaBody.appendChild(fila);
}

