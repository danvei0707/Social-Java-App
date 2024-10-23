# Enunciado
Se quiere desarrollar una red social que contenga usuarios, y los usuarios puedan publicar posts y hacer comentarios en pos posts de otros usuarios. También podrá haber interacción entre usuarios siguiendo a otros usuarios. Para ello es necesario desarrollar las siguientes clases:

* **Usuario**. Contendrá nombre, una lista de los usuarios a los que sigue, lista de posts.
* **Post**. Contendrá fecha y lista de comentarios. Además, podrá ser un texto (que deberá tener un String con el contenido), una imagen (deberá tener un título y dimensiones) o un vídeo (que tendrá título, calidad y duración en segundos).
* **Comentarios**. Los comentarios tendrán un texto, una fecha y un propietario que ha de ser un usuario.


**También se tendrán que desarrollar métodos para las siguientes funcionalidades:**


- Añadir usuarios, posts y comentarios.
- Dejar de seguir un usuario
- Comenzar a seguir un usuario
- Eliminar un usuario, un post o un comentario
- Listar todos los posts de un usuario
- Listar los comentarios de un usuario
- Mostrar el número de comentarios que tiene un post


## BONUS:


- Crear el **muro de un usuario**, es decir, mostrar solo los primeros 10 posts de usuarios a los que sigue, ordenados en orden cronológico (primero las más recientes).
- Implementar un **algoritmo de sugerencias** de amistad por amigos comunes.
  Crear una clase main con un menú para poder seleccionar la funcionalidad que se quiera realizar.