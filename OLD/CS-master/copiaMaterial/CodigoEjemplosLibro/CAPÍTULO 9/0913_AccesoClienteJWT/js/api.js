/******************************************************************
 * 
 * Funciones api rest 
 * 
 * ****************************************************************/
const BASE_URL = 'http://localhost:9000';

/******************************************************************
 * LOGIN
 *****************************************************************/
async function api_signin(loginURL, username, pass) {
  const credenciales = {
    nombre: username,
    password: pass
  };
  try {
    const response = await fetch(BASE_URL + loginURL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(credenciales),
    });
    if (!response.ok) {
      const textErr = await response.text();
      throw new Error(textErr);
    }
    const { accessToken } = await response.json();
    return accessToken;
  } catch (error) {
    console.error('Error al obtener datos:', error);
    return false;
  }
}
/******************************************************************
 * REGISTRO
 *****************************************************************/
async function api_signup(getURL, userData) {
  try {
    const response = await fetch(BASE_URL + getURL);
    if (!response.ok) {
      const textErr = await response.text();
      throw new Error(textErr);
    }
    return await response.json();
  } catch (error) {
    console.error('Error al obtener datos:', error);
    return false;
  }
}

/******************************************************************
 * GET
 *****************************************************************/
async function api_get(getURL, token) {
  try {
    const response = await fetch(BASE_URL + getURL, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
    });
    if (!response.ok) {
      const textErr = await response.text();
      throw new Error(textErr);
    }
    return await response.json();
  } catch (error) {
    console.error('Error al obtener datos:', error);
    return false;
  }
}

/******************************************************************
 * PUT
 *****************************************************************/
async function api_put(putURL, id, data, token) {
  try {
    const response = await fetch(BASE_URL + putURL + id, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify(data)
    });
    if (!response.ok) {
      const textErr = await response.text();
      throw new Error(textErr);
    }
    return true;
  } catch (error) {
    console.error('Error al modificar datos:', error);
    return false;
  }
}

/******************************************************************
 * POST
 *****************************************************************/
async function api_post(postURL, data, token) {
  try {
    const response = await fetch(BASE_URL + postURL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify(data)
    });
    if (!response.ok) {
      const textErr = await response.text();
      throw new Error(textErr);
    }
    return true;
  } catch (error) {
    console.error('Error al insertar datos:', error);
    return false;
  }
}

/******************************************************************
 * DELETE
 *****************************************************************/
async function api_delete(deleteURL, id, token) {
  try {
    const response = await fetch(BASE_URL + deleteURL + id, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
    });
    if (!response.ok) {
      const textErr = await response.text();
      throw new Error(textErr);
    }
    return true;
  } catch (error) {
    console.error('Error al eliminar datos:', error);
    return false;
  }
}
