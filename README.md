Конфигурация вынесена во внешний репозиторий:  
https://github.com/Ogr2049/user-service-config




Микросервисная платформа для управления пользователями с использованием Spring Cloud паттернов.

1)Архитектура:проект состоит из 4 микросервисов:
- Discovery Server(Eureka) - Service Discovery
- Config Server - External Configuration  
- API Gateway - Gateway API
- User Service - основной бизнес-сервис

2)External Configuration: Конфигурация вынесена во внешний репозиторий:  
https://github.com/Ogr2049/user-service-config 

Это реализует паттерн External Configuration (отделение кода от настроек).

3)Быстрый запуск:
```bash
docker-compose up --build