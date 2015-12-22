
# use java RMI

## set rmiRegistry

rmiregistry -J-Djava.rmi.server.codebase=file:///<projectRoot>/rmiObject/build/classes/main/ 1099

## run server(consumer)

./gradlew :rmiServer:run

## run client(producer)

./gradlew :rmiClient:run

## result

you can see message from client to server.