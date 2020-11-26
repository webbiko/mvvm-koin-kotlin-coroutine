# mvvm-koin-kotlin-coroutine

In order to execute this project it is needed to execute a json server as backend. Below follow the steps to configure:

Pre-requirement: Have npm installed.

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
