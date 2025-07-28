#!/bin/bash

# start.sh

ENV=${1:-local}

echo "🔧 Activando perfil Spring: $ENV"

if [[ "$ENV" == "docker" ]]; then
  echo "🐳 Iniciando en entorno Docker..."
  exec java -Dspring.profiles.active=docker -jar target/*.jar
elif [[ "$ENV" == "local" ]]; then
  echo "💻 Iniciando en entorno local..."
  exec mvn spring-boot:run -Dspring-boot.run.profiles=local
else
  echo "⚠️ Perfil desconocido: $ENV"
  echo "Usa: ./start.sh [local|docker]"
  exit 1
fi
