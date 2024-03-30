[![Build status](https://ci.appveyor.com/api/projects/status/3wvxeod64scvjrey?svg=true)](https://ci.appveyor.com/project/DaniyaKurm/diplom-3-l0232)
[![Build and Test](https://github.com/DaniyaKurm/Diplom-3/actions/workflows/gradle.yml/badge.svg)](https://github.com/DaniyaKurm/Diplom-3/actions/workflows/gradle.yml)

**Дипломный проект по профессии «Тестировщик»**


**ДОКУМЕНТАЦИЯ**

1. <a href="https://github.com/DaniyaKurm/Diplom-3/blob/main/Documentation/Task.md" style="font-size: 18px">Задача</a> <br>
2. <a href="https://github.com/DaniyaKurm/Diplom-3/blob/main/Documentation/Plan.md" style="font-size: 18px">План автоматизации
   тестирования</a> <br>
3. <a href="https://github.com/DaniyaKurm/Diplom-3/blob/main/Documentation/Report.md" style="font-size: 18px">Отчет по итогам
   тестирования</a> <br>
4. <a href="https://github.com/DaniyaKurm/Diplom-3/blob/main/Documentation/Summary.md" style="font-size: 18px">Отчет по итогам
   автоматизации</a> <br>


**Подготовка тестового окружения для запуска автотестов**

**Установить приложения**

1. IntelliJ IDEA Community Edition 2023.2.2
1. Docker Desktop
1. Chromedriver Version: 122.0.6261.95
1. Браузер Google Chrome. Версия 122.0.6261.95 (Официальная сборка), (64 бит)

**Процедура запуска автотестов**

**MySQL**

1. Открыть проект в IntelliJ IDEA
1. Запустить Docker Desktop
1. В терминале IDEA набрать docker compose up --build
1. Ждем запуска контейнеров node-app, mysql, postgres
1. Во втором терминале запустить приложение aqa-shop.jar командой
   java -jar ./artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app
1. В отдельном терминале запустить тесты командой
   ./gradlew clean test -DdbUrl=jdbc:mysql://localhost:3306/app
1. Остановить приложение: перейти в терминал, в котором оно запущено, и нажать CTRL + C
1. Остановить контейнеры командой docker compose down

**PostgreSQL**

1. Открыть проект в IntelliJ IDEA
1. Запустить Docker Desktop
1. В терминале IDEA набрать docker compose up --build
1. Ждем запуска контейнеров node-app, mysql, postgres
1. Во втором терминале запустить приложение aqa-shop.jar командой  
   java -jar ./artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app
1. В отдельном терминале запустить тесты командой
   ./gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app
1. Остановить приложение: перейти в терминал, в котором оно запущено, и нажать CTRL + C
1. Остановить контейнеры командой docker compose down 


