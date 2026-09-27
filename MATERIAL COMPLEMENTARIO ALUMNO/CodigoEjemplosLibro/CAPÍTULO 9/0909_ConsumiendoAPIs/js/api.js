/******************************************************************
 * 
 * Funciones api rest 
 * 
 * ****************************************************************/
const BASE_URL = 'http://localhost:9000';
/******************************************************************
 * GET
 *****************************************************************/
async function api_get(getURL) {
  try {
    const response = await fetch(BASE_URL + getURL);   
    if (!response.ok)  {
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
async function api_put(putURL, id, data) {
  try {
      const response = await fetch(BASE_URL + putURL + id, {
      method: 'PUT',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(data )
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
async function api_post(postURL, data) {
  try {
    const response = await fetch(BASE_URL + postURL , {
      method: 'POST',
      headers: {'Content-Type': 'application/json' },
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
 * delete
 *****************************************************************/
async function api_delete(deleteURL, id) {
  try {
    const response = await fetch(BASE_URL + deleteURL + id, {
      method: 'DELETE'
    });
    if (!response.ok) {
      const textErr = await response.text();
	    throw new Error(textErr);
    } 
    return true;
  } catch (error) {
      console.error ('Error al eliminar datos:', error);
      return false;
  }
}
