docker image build -t inventario-api:latest .
docker container run -p 8080:8080 -d --name inventario-container inventario-api
