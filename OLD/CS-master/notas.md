# Notas de forms

1º Crear la clase del formulario con getters y setters
2º Controlador con get --> en el formulario con el model cuya ruta coincide con la del post
3º Crear página web que musestra formularios(vacio) "th:object" en la etiqueta de form, como es un objeto se usa $
4º PostMapping en los parámetros de entrada recibe formulario + model.
al enviar a la vista que va a procesar el formulario implica enviar el formulario a (model **\_\_\_**)

5º Vista formulario procesado mostrará mensaje todo OK - las propiedades son nombreform.propiedad

Id para CSS y JavaScript pero el Name se usa para la parte de sevidor
Importante el asterisco "\*" en el th:field dentro de el form

<form
      action="#"
      method="post"
      th:action="@{/myForm/submit}"  <-----------
      th:object="${formInfo}"  <------------
    >
      <label
        >Nombre: <input type="text" id="nombre" th:field="*{nombre}" /></label  <------------
      ><br />
       <label
        >Edad: <input type="text" id="edad" th:field="*{edad}" /></label  <------------
      ><br />
      <input type="submit" value="Enviar" />
    </form>

# Fields

$T(package name.enumName)
th.each = "variable : ArrayList"
$(nombre) -> variable
@ -> url

Una lista de set no puede tener elementos repetidos (Importante para el ejercicio de crear numeros aleatorios, para que no se puedan repetir)
Return "redirect/ 'ruta de la vista' " para devolver una vista al fonal de una función y que no se muestre en el navegador que se ha hecho un cambio

 <body>
        <h1>Listado de numeros aleatorios</h1>
        <table th:if="${ocultar}" border="1px">
          <thead><tr><th>Numero</th><th>Operación</th></tr></thead>
          <tbody>
        	 <tr th:each="numero : ${listaNumeros}">
        	    <td  th:text="${numero}" th:class="${numero < 50} ? 'menor' : 'mayor'" >33</td>
              <td><a th:href="@{/delete/{id}(id=${numero})}">delete</a></td>        		
             </tr>
          </tbody>
        </table>
        Total números: <span th:text="${cantidadTotal}">0</span><br/>
        <a th:href="@{/new}">Nuevo número</a><br/>
  </body>

@Controller
@RequestMapping("/rutaQueUsas")
public class NombreDeLaClase {
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
@Override
public void addViewControllers(ViewControllerRegistry registry) {
registry.addViewController("/informacion/referencias").setViewName("enlaces-externos");
}
}

}

private Map<String, Integer> films = new LinkedHashMap<>();
//Tenemos que hacer un bloque de inicialización o bien un constructor para inicializarlo
{
films.put("avatar", 0);
films.put("cadenaPerpetua", 0);
films.put("pulpFiction", 0);
}

CRUD
-Create
-Read
-Update
-Delete

