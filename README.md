# Library API - Docker

Este proyecto utiliza **Docker** para ejecutar una base de datos MySQL y la aplicación Spring Boot en contenedores.

## Prerrequisitos

- Docker instalado
- Docker Desktop (Windows/Mac) o Docker Engine (Linux)

---

## 1. Crear la red de Docker

Crear una red para que los contenedores puedan comunicarse entre sí.

```bash
docker network create library-network
```

---

## 2. Descargar la imagen de MySQL

```bash
docker pull mysql:8
```

---

## 3. Crear el contenedor de MySQL

```bash
docker run --name mysql-db \
--network library-network \
-e MYSQL_ROOT_PASSWORD=admin \
-e MYSQL_DATABASE=library \
-p 3306:3306 \
-d mysql:8
```

Este comando crea:

- **Usuario:** root
- **Contraseña:** admin
- **Base de datos:** library

---

## 4. Construir la imagen de la aplicación

Ubícate en la carpeta donde se encuentra el `Dockerfile` y ejecuta:

```bash
docker build --no-cache -t calobo-library .
```

---

## 5. Ejecutar el contenedor de la aplicación

```bash
docker run --name calobo-library \
--network library-network \
-p 8080:8080 \
-e DB_URI="jdbc:mysql://mysql-db:3306/library?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" \
-e DB_USER="root" \
-e DB_PASSWORD="admin" \
-e DB_DRIVER="com.mysql.cj.jdbc.Driver" \
-d calobo-library
```

---

## Verificar los contenedores

```bash
docker ps
```

Deberías ver dos contenedores en ejecución:

- `mysql-db`
- `calobo-library`

---

## Detener los contenedores

```bash
docker stop mysql-db
docker stop calobo-library
```

---

## Iniciar nuevamente los contenedores

```bash
docker start mysql-db
docker start calobo-library
```

---

## Eliminar los contenedores

```bash
docker rm -f mysql-db
docker rm -f calobo-library
```

---

## Acceso a la aplicación

Una vez ambos contenedores estén en ejecución, la API estará disponible en:

```
http://localhost:8080
```

La base de datos MySQL estará disponible en:

- **Host:** localhost
- **Puerto:** 3306
- **Base de datos:** library
- **Usuario:** root
- **Contraseña:** admin
