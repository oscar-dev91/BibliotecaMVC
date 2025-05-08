# 📚 Sistema de Gestión de Biblioteca

Este proyecto es una aplicación Java para gestionar diferentes elementos de una biblioteca, como libros, revistas y tesis. Permite registrar, consultar, modificar y eliminar información relacionada con estos elementos.

## 🧱 Tecnologías utilizadas

- Java 8+
- JDBC
- MySQL (o cualquier base de datos relacional)
- IDE recomendado: IntelliJ IDEA, Eclipse o NetBeans

## 📁 Estructura del proyecto

```bash
com.biblioteca
├── model
│ ├── ElementoBiblioteca.java
│ ├── Libro.java
│ ├── Revista.java
│ └── Tesis.java
├── dao
│ ├── ElementoBibliotecaDAO.java
│ ├── LibroDAO.java
│ ├── RevistaDAO.java
│ └── TesisDAO.java
├── ui
│ └── MenuPrincipal.java
└── Main.java
```


## 🗃️ Modelo de datos

### Tabla: ElementoBiblioteca

| Campo            | Tipo         | Descripción                          |
|------------------|--------------|--------------------------------------|
| id               | INT (PK)     | Identificador único                  |
| titulo           | VARCHAR      | Título del elemento                  |
| autor            | VARCHAR      | Autor del elemento                   |
| ano_publicacion  | INT          | Año de publicación                   |
| tipo             | VARCHAR      | Tipo (LIBRO, REVISTA, TESIS)         |

### Tabla: Libro

| Campo            | Tipo         |
|------------------|--------------|
| id               | INT (FK)     |
| genero           | VARCHAR      |
| numero_paginas   | INT          |

### Tabla: Revista

| Campo            | Tipo         |
|------------------|--------------|
| id               | INT (FK)     |
| numero_edicion   | INT          |
| categoria        | VARCHAR      |

### Tabla: Tesis

| Campo            | Tipo         |
|------------------|--------------|
| id               | INT (FK)     |
| universidad      | VARCHAR      |
| resumen          | TEXT         |

## ⚙️ Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/nombre-del-repo.git
   ```
2. Importa el proyecto en tu IDE favorito.
3. Asegúrate de tener configurada una base de datos MySQL y crea las tablas necesarias (ver sección anterior o usa el script SQL incluido).
4. Configura la conexión JDBC en el archivo correspondiente (por ejemplo, ConexionBD.java):
   ```
   private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
   private static final String USER = "root";
   private static final String PASSWORD = "tu_contraseña";
   ```
5. Ejecuta la clase Main.java.

## ✨ Funcionalidades

* Agregar nuevos elementos (libros, revistas, tesis)
* Buscar por título, autor o tipo
* Actualizar información
* Eliminar registros
* Mostrar todos los elementos de la biblioteca