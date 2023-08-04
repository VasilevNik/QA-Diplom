# Автоматизация тестирования веб-сервиса "Путешествие дня".
**Описание**: Веб-сервис предлагает купить тур по определённой цене двумя способами:

- Обычная оплата по дебетовой карте.
- Уникальная технология: выдача кредита по данным банковской карты.

**Ключевая цель**: Автоматизировать позитивные и негативные сценарии покупки тура.

## Начало работы

1. Запустить **браузер, Intellij IDEA, Docker Desktop**. Информация для установки дана в разделе "Prerequisites"
2. Скопировать проект по [ссылке](https://github.com/VasilevNik/QA-Diplom)

## Prerequisites

- Установить **браузер**(наиболее популярные **[Google Chrome](https://www.google.com/intl/ru/chrome/browser-tools/), [Яндекс.Браузер](https://browser.yandex.ru/), [Safari](https://www.apple.com/ru/safari/), [Opera](https://www.opera.com/ru/browsers/opera), [Firefox](https://www.mozilla.org/ru/firefox/new/)** для открытия [веб-сервиса](http://localhost:8080/)
- Установить **[IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/)**
- Установить **[Git](https://desktop.github.com/)**
- Установить **[Docker Desktop](https://www.docker.com/products/docker-desktop/)**


## Запуск приложения и тестов

1. По [ссылке](https://github.com/VasilevNik/QA-Diplom) клонировать репозиторий к себе на ПК командой `git clone`
2. Открыть проект в **IntelliJ IDEA**
3. Через терминал запустить **MySQL, PostgreSQL, NodeJS** командой: `docker-compose up`
4. В новой вкладке терминала запустить приложение:
- для **MySQL**: `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
- для **PostgreSQL**: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
5. Проверить доступность приложения по адресу http://localhost:8080/
6. В новой вкладке терминала запустить тесты:
- для **MySQL**: `.\gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`
- для **PostgreSQL**: `.\gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`
7. Остановка приложения Ctrl+C

## Формирование отчета
В новой вкладке терминала ввести .\gradlew allureReport

