The project consists of 5 services.

To run the application correctly, you must observe the launch order:
1. cloud-config-server
2. eureka-server

Before proceeding, you need to make sure that the configuration server has registered with eureka:
At http://127.0.0.1:8082/ you should see the line "CLOUD-CONFIG-SERVER"

After checking the presence of this line, other services can be started simultaneously.
-zuul-server
-water-warehouse-service
-bottle-store-service

http://127.0.0.1:8081 - cloud-config-server
http://127.0.0.1:8082 - eureka-server
http://127.0.0.1:8080 - zuul-server

water-warehouse-service:
http://127.0.0.1:8083
http://127.0.0.1:8080/warehouse

bottle-store-service:
http://127.0.0.1:8084
http://127.0.0.1:8080/store

Сalling the service "store" returns a random bottle, requesting it by id from the service "warehouse"