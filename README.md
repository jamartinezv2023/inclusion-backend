# 🧠 Proyecto TEAC | Backend de Inclusión Educativa

Sistema backend modular, seguro y escalable para la gestión de inclusión educativa, desarrollado con Spring Boot 3, RabbitMQ, PostgreSQL, WebSocket, Docker y JWT. Listo para producción y observabilidad.

---

## 📌 Tecnologías Principales

- ☕ Java 21
- 🌱 Spring Boot 3 (Web, JPA, Security, WebSocket)
- 🔐 JWT (JSON Web Tokens)
- 🐘 PostgreSQL + MongoDB (soporte dual)
- 🐇 RabbitMQ (eventos asincrónicos)
- 🌐 WebSocket (alertas en tiempo real)
- 📦 Docker + Docker Compose
- 📈 Spring Actuator + Prometheus
- 📄 SpringDoc OpenAPI (Swagger UI)

---

## ⚙️ Estructura del Repositorio

inclusion-backend/
├── src/
│ ├── config/ # Seguridad, WebSocket, JWT, Swagger
│ ├── controllers/ # Endpoints REST
│ ├── services/ # Lógica de negocio
│ ├── models/ # Entidades JPA / DTOs
│ ├── repositories/ # Interfaces de acceso a datos
│ └── ...
├── application.yml # Configuración multi-perfil
├── Dockerfile # Imagen Docker
├── docker-compose.yml # Servicios contenedorizados
├── .env # Variables de entorno
└── README.md # Este documento


---

## 🚀 ¿Cómo ejecutar el proyecto?

### 1️⃣ Clona el repositorio y configura entorno

```bash
git clone https:https://github.com/jamartinezv2023/inclusion-backend.git
cd inclusion
cp .env.example .env

2️⃣ Levanta todo con Docker Compose

docker-compose up --build

Esto levantará:
Servicio	URL	Puerto
Backend API	http://localhost:8080	8080
Swagger UI	http://localhost:8080/swagger-ui.html	Swagger
PostgreSQL	localhost:5432	5432
RabbitMQ	http://localhost:15672	15672
WebSocket	ws://localhost:8080/ws	WebSocket
📡 Endpoints REST comunes
Método	Ruta	Descripción
POST	/api/auth/login	Autenticación con JWT
GET	/api/users	Obtener lista de usuarios
GET	/api/roles	Obtener lista de roles
🔐 Seguridad JWT

    Header: Authorization: Bearer <token>

    Algoritmo: HS256

    Clave: definida en .env como JWT_SECRET

    Expiración configurable vía JWT_EXPIRATION_MS

📊 Métricas con Prometheus + Actuator
Endpoint	Descripción
/actuator/health	Estado de la app
/actuator/info	Información general
/actuator/prometheus	Métricas en formato Prometheus
📬 RabbitMQ

    Acceso: http://localhost:15672

    Usuario: guest

    Contraseña: guest

🧪 Ejecutar pruebas

mvn clean test

📄 Documentación con Swagger UI (SpringDoc)

La documentación de los endpoints está disponible automáticamente en:

    http://localhost:8080/swagger-ui.html

    Basado en SpringDoc OpenAPI 3

🌍 Variables de entorno (.env)

SPRING_PROFILES_ACTIVE=local
APP_PORT=8080

POSTGRES_DB=inclusion_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_HOST=localhost
POSTGRES_PORT=5432

JWT_SECRET=clave-muy-segura
JWT_EXPIRATION_MS=86400000

RABBITMQ_DEFAULT_USER=guest
RABBITMQ_DEFAULT_PASS=guest
RABBITMQ_HOST=localhost
RABBITMQ_PORT=5672

🛡️ Despliegue en Producción (NGINX + HTTPS)
1. Construye la imagen backend

docker build -t inclusion-backend-prod .

2. Configura NGINX como reverse proxy

server {
    listen 80;
    server_name backend.teac.edu;

    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}

3. Agrega HTTPS con Certbot

sudo apt install certbot python3-certbot-nginx
sudo certbot --nginx -d backend.teac.edu

☁️ Opcional: Despliegue en Azure, AWS o Vercel
Azure Web App for Containers

az webapp create --resource-group <group> --plan <plan> --name teac-api \
  --deployment-container-image-name inclusion-backend-prod

AWS ECS + RDS

    Crea clúster ECS

    Crea base de datos RDS PostgreSQL

    Configura secretos en AWS Secrets Manager

    Usa ECS Task Definition para el contenedor backend

📚 Roadmap

Seguridad JWT con expiración

WebSocket en tiempo real

Integración con RabbitMQ

Documentación Swagger UI

CI/CD con GitHub Actions

Deploy automático a Azure / AWS

    Módulo de IA para inclusión (Fase 2)

👨‍💻 Autor y Créditos

Proyecto TEAC 2025 — Inclusión Educativa
Doctorado en Tecnología Educativa Aplicada al Conocimiento
Universidad de Alicante

Desarrollado por: José Alfredo Martínez Valdés
📧 jose.alfredo@ejemplo.edu
📎 LinkedIn | GitHub
📝 Licencia

Este proyecto está licenciado bajo la MIT License.
