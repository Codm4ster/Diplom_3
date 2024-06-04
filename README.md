# Diplom_3

## Веб-приложение Stellar Burgers

### Реализованны следующие тесты:
1. Регистрация.
2. Вход через кнопку.
3. Переход в личный кабинет.
4. Переход из личного кабинета в конструктор.
5. Выход из аккаунта.
6. Раздел «Конструктор».

### Проект использует следующие зависимости:

- JUnit 4.13.2
- Selenium 4.18.1
- Rest-assured 5.4.0
- Allure 2.15.0

## запуск в Google Chrome

```bash
mvn test
```

## запуск в Yandex

```bash
mvn -Dbrowser=yandex -Ddriver.version=122.0.6261.128 -Dwebdriver.yandex.bin=C:\\Users\\adm2721\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe test
```

## Запуск отчёта Allure

```bash
mvn allure:serve
```


