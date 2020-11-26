# mvvm-koin-kotlin-coroutine

In order to execute this project it is needed to execute a json server as backend. Below follow the steps to configure:

Pre-requirement: npm installed.

1) create a backend folder;
2) access the new backend folder;
3) Type command : npm init -y;
4) Type command : npm i json-server;
5) create a db.json file with the following structure:

```json
{
    "todos": [
        {
            "id": 1,
            "task": "Adding base structure"
        },
        {
            "id": 2,
            "task": "Setting up backend server"
        }
    ]
}
```
6) Type the command: json-server --host <your-ip-address> --watch db.json

## Technologies and libraries

* [Kotlin](https://kotlinlang.org/docs/reference/)
* [Koin (DI)](https://insert-koin.io/)
* [MVVM (Architecture)](https://github.com/MindorksOpenSource/MVVM-Architecture-Android-Beginners)
* [Retrofit (Network)](https://square.github.io/retrofit/)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html)

## Reference

* **[Json server reference](https://www.npmjs.com/package/json-server)**
