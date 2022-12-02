# Text Occurences Finder
Сервис для поиска вхождений одного текста в другой текст

# Запуск сервиса в Docker-контейнере

#### 1. Клонировать репозиторий
```
git clone https://github.com/MaksimZotov/text-occurences-finder.git
```

#### 2. Перейти в папку проекта
```
cd text-occurences-finder
```

#### 3. Построить образ
```
docker build -t tof .  
```

#### 4. Запуск
```
docker run -p 8080:8080 tof
```

# Примеры работы

Будем посылать `POST`-запросы по адресу `http://localhost:8080/api/find/`.
В тело запросов будем помещать `JSON`-объект, содержащий основной и искомый тексты

#### Пример 1
Тело запроса
```
{
    "main_text": "ffff",
    "find_text": "fffff"
}
```
Тело ответа
```
{
    "description": "Искомый текст больше основного"
}
```

#### Пример 2
Тело запроса
```
{
    "main_text": "abcd",
    "find_text": "dc"
}
```
Тело ответа
```
{
    "description": "Вхождений не найдено"
}
```

#### Пример 3
Тело запроса
```
{
    "main_text": "111122211112211",
    "find_text": "22"
}
```
Тело ответа
```
{
    "indexes": [
        {
            "first": 4,
            "second": 5
        },
        {
            "first": 11,
            "second": 12
        }
    ],
    "percent": 0.26666668
}
```

#### Пример 4
Тело запроса
```
{
    "main_text": "fffffff",
    "find_text": "ff"
}
```
Тело ответа
```
{
    "indexes": [
        {
            "first": 0,
            "second": 1
        },
        {
            "first": 2,
            "second": 3
        },
        {
            "first": 4,
            "second": 5
        }
    ],
    "percent": 0.85714287
}
```