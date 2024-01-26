# Read Me First

Para ejecutar el proyecto:

Prerrequisitos: 
Se necesite tener instalado java 17 o superior


Pasos
* Clone o descargue el repositorio
* Abra un terminal y ubiquese en la raiz del proyecto (/payments-api)
* ejecute la siguiente tarea de Gradle
* ```gradlew bootjar```
* Una vez finalizada, corra el siguiente comando:
* ```java -jar build/libs/payments-api-0.0.1-SNAPSHOT.jar``` (Si el nombre es diferente para el jar, se puede revisar en la carpeta lib)
* Carge la colección de postman y utilice los diferentes endpoint


# ¿Cómo decidió las opciones técnicas y arquitectónicas utilizadas como parte de su
solución?
El esquema arquitectonico escogido fue por tener conocimiento previo , pues lo he usado anteriormente en el trabajo para tareas similares.
Use una base de datos h2 al ser una base de rápida configuración que se levanta y se baja con la aplicación.

# ¿Qué haría de manera diferente si se le asignara más tiempo?

* Agregar pruebas unitarias y de rendimiento automatizadas en un pipeline
* Agregar validaciones de todos los campos
* Hacer que el usuario pueda elegir de que mes quiere los reportes
* Implementar una base de datos mas robusta como Postgres o MySql
* Crear un UI


ERRORES MAS IMPORTANTES ENCONTRADOS: 
Se observa que hay campos sin una descripción util, se deberia definir con el cliente si estos campos realmente son requeridos
La fecha se encuentra como opcional , si el cliente no llena este campo crearia muchos conflictos en los metodos que los llaman ya que se basan principalmente en la fecha, deberian ser obligatorios o especificar que hacer cuando no se llena, tome today por ejemplo?
Hay varios requerimientos ambiguos, se podria mal interpretar como listar mensualmente, semanalmente (se trabajo por default el ultimo mes, ultima semana etc) sin embargo pueda ser que el cliente desee el seleccionar que mes o fechas para que muestre su información




