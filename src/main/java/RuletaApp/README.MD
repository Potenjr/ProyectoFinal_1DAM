# Ruleta Americana
He creado una aplicacion compleja usando java y swing que simula el juego de la ruleta americana, tipica de los casinos.

## Estructura
La carpeta principal del proyecto se llama RuletaApp y la estructura del proyecto es un MVC (Modelo-Vista-Controlador)
para separar el codigo y que sea más fácil de modificar y hacer tests.
Podemos indagar un poco más explicando la función de cada carpeta.

### Modelo
El modelo se encarga de gestionar los datos y la lógica de negocio de la aplicación.

**Apuesta**: Representa una apuesta realizada por un jugador en la ruleta. Contiene información sobre el tipo de apuesta, los números apostados, el jugador que realizó la apuesta y el valor de las fichas utilizadas.

**ApuestaClikable**: Define las áreas de la ruleta donde los jugadores pueden realizar sus apuestas. Cada área tiene un límite (rectángulo) y un tipo de apuesta asociado, junto con los números o grupos de números que cubre.

**Jugador**: Representa un jugador en la mesa de ruleta. Contiene información sobre el nombre del jugador, su saldo actual, las fichas que posee y el color de las fichas.

**FichaRuleta**: Representa una ficha utilizada por un jugador para realizar apuestas en la ruleta. Contiene información sobre el color de la ficha y una imagen que la representa gráficamente.

**FichasRuleta**: Gestiona la colección de fichas disponibles en la mesa de ruleta. Permite agregar y eliminar fichas según sea necesario.

**JugadorApuestaError**: Utilizada para manejar errores relacionados con las apuestas de los jugadores. Contiene un código de error y una referencia al jugador afectado.

**Ronda**: Representa una ronda de juego en la ruleta, incluyendo las apuestas realizadas por los jugadores y los resultados de la ronda.

**Ruleta**: Modelo de la ruleta en sí misma, que gestiona los números, colores y otros atributos relacionados con la ruleta.

**RuletaModelo**: Contiene la lógica principal relacionada con la ruleta, como la generación de números aleatorios y el cálculo de pagos de apuestas.

**SegmentoRuleta**: Representa un segmento de la ruleta, que puede contener uno o varios números y tiene propiedades como el color y la paridad.

**TablaConConstantes**: Contiene constantes utilizadas en la interfaz de usuario y el modelo de la ruleta, como márgenes, tamaños de segmentos y márgenes de imagen.

**TipoApuesta**: Enumeración que define los diferentes tipos de apuestas que los jugadores pueden realizar en la ruleta.

**ValorFicha**: Representa el valor de una ficha utilizada en la mesa de ruleta.

**ValorFichas**: Enumeración que define los diferentes valores posibles para las fichas utilizadas en la ruleta.


### Vista
**ImagenFicha**: Representa la imagen de una ficha utilizada en la mesa de ruleta.

**ImagenTablaRuleta**: La imagen que muestra la mesa de ruleta, incluyendo la rueda y la tabla de apuestas.

**JugadorPanel**: Un panel que muestra la información del jugador, incluyendo su nombre, saldo y fichas.

**MenuPanel**: Un panel que contiene los botones del menú para interactuar con el juego de ruleta.

**PanelDeControl**: Proporciona controles para iniciar el juego, añadir jugadores, realizar apuestas y girar la ruleta.

**PanelDeLlamadas**: Un panel que permite realizar llamadas específicas durante el juego de ruleta.

**PanelRuleta**: El panel principal que contiene la mesa de ruleta y la rueda.

**PanelTablaRuleta**: Muestra la tabla de apuestas de la ruleta.

**RuletaFrame**: El marco principal de la aplicación de ruleta, que contiene todos los componentes visuales.

**RuletaImagen**: Representa una imagen de la ruleta.

**RuletaPanel**: Un panel que muestra la ruleta y la mesa de apuestas.


### Texto-Vista
**AñadirDialogo**: Representa un diálogo para añadir nuevos jugadores a la mesa de ruleta. Permite al usuario ingresar el nombre y seleccionar el color del jugador.

**AñadirPanelJugador**: Es un panel que forma parte del diálogo de añadir jugador. Contiene campos para que el usuario ingrese el nombre del jugador y seleccione su color de fichas.

**DialogoApuesta**: Un diálogo que muestra las apuestas realizadas por los jugadores en la mesa de ruleta.

**DialogoGanancia**: Muestra las ganancias obtenidas por los jugadores después de un giro de la ruleta.

**DialogoPanel**: Un panel utilizado como base para crear diálogos personalizados en la aplicación.

**Instrucciones**: Un diálogo que muestra las instrucciones del juego de ruleta.

**PanelApuesta**: Un panel que muestra las opciones de apuesta disponibles para los jugadores en la mesa de ruleta.

**PanelEliminarJugador**: Un panel que permite al usuario seleccionar un jugador existente para eliminarlo de la mesa de ruleta.

**PanelGanancias**: Muestra las ganancias obtenidas por los jugadores después de un giro de la ruleta. Este panel proporciona una vista detallada de las ganancias de cada jugador.

### Controlador
**AñadirListenerJugador**: Maneja eventos relacionados con la adición de jugadores al juego de ruleta, como la interacción con el botón de agregar jugador en la interfaz.

**EliminarListenerJugador**: Gestiona eventos relacionados con la eliminación de jugadores del juego de ruleta, como la interacción con el botón de eliminar jugador en la interfaz.

**FichaListener**: Se encarga de manejar eventos relacionados con las fichas utilizadas en las apuestas, como la interacción con las fichas en la mesa de ruleta.

**RuletaListener**: Maneja eventos relacionados con la ruleta en sí misma, como la interacción con el botón de girar la ruleta en la interfaz.

**SeleccionJugadorListener**: Gestiona eventos relacionados con la selección de jugadores en la interfaz, como la interacción con la lista de jugadores disponibles.


    

































#### Adrian Potenciano Vila 1ºDAM