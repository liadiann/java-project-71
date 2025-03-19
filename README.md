# Вычислитель отличий

[![Actions Status](https://github.com/liadiann/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/liadiann/java-project-71/actions)
[![my-workflow](https://github.com/liadiann/java-project-71/actions/workflows/my-workflow.yml/badge.svg)](https://github.com/liadiann/java-project-71/actions/workflows/my-workflow.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/7a82d5d0d038c3c2b1d2/maintainability)](https://codeclimate.com/github/liadiann/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/7a82d5d0d038c3c2b1d2/test_coverage)](https://codeclimate.com/github/liadiann/java-project-71/test_coverage)

Программа, определяющая разницу между двумя структурами данных. Используется, например, при выводе
тестов или при автоматическом отслеживании изменений в конфигурационных файлах.

Может работать с файлами формата .json и .yaml(.yml). Имеется 3 форматтера:
1. Stylish (форматтер по умолчанию),
2. Plain,
3. Json.

Программу можно использовать как Cli-утилиту и библиотеку.
## Установка
1. Клонирование репозитория
```bash
git@github.com:liadiann/java-project-71.git
```
2. Переход в директорию app
```bash
cd app
```
3. Установка проекта
```bash
./gradlew installDist
```
4. Запуск приложения. Пример:
```bash
./build/install/app/bin/app file1.json file2.json
```
или
```bash
make run-dist filepath1=file1.json filepath2=file2.json
```
## Использование

Пример запуска сравнения json файлов: [asciinema](https://asciinema.org/a/ndWCfLdXn5YEBTKMwZeepeazE)
####
Пример запуска сравнения yaml файлов: [asciinema](https://asciinema.org/a/hdVDyIsd6QfAMsgy5e1v4vOnj)
####
Пример запуска сравнения файлов со вложенными структурами: [asciinema](https://asciinema.org/a/kscUYObEi71vltH93tSmr4hqj)
####
Пример запуска сравнения файлов в формате plain: [asciinema](https://asciinema.org/a/4xqQJdIOdCQJN4dhYfVw87K34)
####
Пример запуска сравнения файлов в формате json: [asciinema](https://asciinema.org/a/jkag7fi85tvEHYVnJhT7WTRte)
