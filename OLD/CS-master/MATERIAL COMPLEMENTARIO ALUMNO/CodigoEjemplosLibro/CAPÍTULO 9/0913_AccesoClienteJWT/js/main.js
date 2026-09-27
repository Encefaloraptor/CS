/*********************************************************
 * Inicialización
 *********************************************************/
var token;
async function init() {
    //token = await autentificarUsuario();
}

/*********************************************************
 * Autentificación
 *********************************************************/
async function autentificarUsuario() {
  //const usuario = "admin"; 
  //const contraseña = "1234"; 
  const usuario = document.getElementById('usuario').value;
  const contraseña = document.getElementById('contraseña').value;
  const urlSignIn = '/api/auth/signin';
  try {
    let token =  await api_signin(urlSignIn, usuario, contraseña);
    console.log("token que se acaba recibir en crud despues de autentificar " , token);
    return token;
  } catch (error) { token = false; }
}

/*********************************************************
 * Variables del documento
 *********************************************************/
var okBtn = document.getElementById('okBtn');
var admBtn = document.getElementById('getAdminDataBtn');
var mngrBtn = document.getElementById('getManagerDataBtn');
var usrBtn = document.getElementById('getUserDataBtn');
var pubBtn = document.getElementById('getPublicDataBtn');

/*********************************************************
 * Eventos de acceso a datos
 *********************************************************/
okBtn.addEventListener('click', async () => { token = await autentificarUsuario();});
admBtn.addEventListener('click', async () => { const data = await api_get('/api/test/admin',token); actualizarDoc(data);});
mngrBtn.addEventListener('click', async () => { const data = await api_get('/api/test/manager',token); actualizarDoc(data);});
usrBtn.addEventListener('click', async () => { const data = await api_get('/api/test/user',token); actualizarDoc(data);});
pubBtn.addEventListener('click', async () => { const data = await api_get('/api/test/all',token); actualizarDoc(data);});
/******************************************************************
 * Actualizar docum con datos del servidor
 * ****************************************************************/
function actualizarDoc(data) {
  document.getElementById('serverData').innerHTML = `${data.contenido}`;
}


