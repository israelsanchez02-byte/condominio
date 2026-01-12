
Sistema de Gestión de Condominios
Control administrativo, financiero y de cobranza

Aplicación de escritorio desarrollada en Java (Swing + SQLite) para la administración integral de condominios.
El sistema está orientado a administradores que requieren control de cuotas, pagos, gastos y reportes claros en un solo lugar, sin depender de servicios externos.

---

CARACTERÍSTICAS PRINCIPALES

* Gestión de condominios, torres y departamentos
* Control de cuotas de mantenimiento
* Registro de pagos y control de adeudos
* Estados de cuenta por departamento en PDF
* Reportes financieros mensuales
* Dashboard con gráficas de ingresos y gastos
* Roles de usuario (Administrador, Auxiliar, Consulta)
* Exportación de datos a PDF y Excel
* Respaldos automáticos de la base de datos
* Interfaz moderna con FlatLaf

---

¿A QUIÉN VA DIRIGIDO?

* Administradores de condominios
* Proyectos académicos de nivel profesional
* Desarrolladores que buscan un sistema base en Java
* Pequeñas y medianas administraciones residenciales

---

ARQUITECTURA DEL SISTEMA

El proyecto utiliza el patrón MVC (Model – View – Controller):

src/
app/
controller/
dao/
model/
view/
util/
Main.java

Model: Entidades del dominio (Condominio, Departamento, Usuario, Pago, Gasto).
View: Interfaces gráficas desarrolladas con Swing.
Controller: Lógica de negocio y validaciones.
DAO: Acceso a datos mediante SQLite.
Util: Exportadores PDF/Excel, validaciones y utilidades generales.

---

TECNOLOGÍAS UTILIZADAS

* Java JDK 17 o superior
* Swing
* FlatLaf
* SQLite
* JDBC
* JFreeChart
* iText PDF
* Apache POI (Excel)

---

REQUISITOS DEL SISTEMA

* Sistema operativo Windows, macOS o Linux
* Java JDK 17 o superior instalado
* 4 GB de RAM recomendados
* No requiere servidor ni conexión a internet

---

INSTALACIÓN Y EJECUCIÓN

1. Clonar el repositorio
   git clone [https://github.com/tu-usuario/tu-repositorio.git](https://github.com/tu-usuario/tu-repositorio.git)

2. Abrir el proyecto en Visual Studio Code

* Abrir la carpeta del proyecto
* Instalar la extensión "Java Extension Pack"

3. Agregar librerías externas
   Agregar todos los archivos .jar contenidos en la carpeta /lib al classpath del proyecto:

* sqlite-jdbc
* flatlaf
* itext
* apache-poi
* jfreechart

4. Ejecutar el proyecto
   Ejecutar la clase principal:
   app.Main

---

USUARIOS DE PRUEBA

Usuario: admin
Contraseña: admin123
Rol: Administrador

Usuario: aux
Contraseña: aux123
Rol: Auxiliar

---

BASE DE DATOS

* El sistema utiliza SQLite
* La base de datos se encuentra en la carpeta /data
* Las tablas se crean automáticamente si no existen
* Incluye función de respaldo automático

---

EXPORTACIONES

* PDF: Estados de cuenta y reportes financieros
* Excel (.xlsx): Exportación de tablas y reportes

---

ROADMAP (MEJORAS FUTURAS)

* Envío automático de estados de cuenta por correo o WhatsApp
* Soporte multi-condominio
* Control multi-moneda
* Facturación electrónica
* Versión web del sistema

---

AUTOR

Israel Sánchez
Desarrollador de Software

Proyecto enfocado en una solución real para la administración de condominios.

---

LICENCIA

Este proyecto puede utilizarse con fines académicos y comerciales.
Para uso comercial, contactar al autor.

