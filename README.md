curl -X POST "http://localhost:8080/store" -d '{"id":12,"storeName":"manhattan"}' -H "Content-Type: application/json"
{"id":12,"storeName":"manhattan"}                                                                                                                                                                                      
curl -X GET "http://localhost:8080/store/12"                                                                         
{"id":12,"storeName":"manhattan"}                                                                                                                                                                                      
curl -X GET "http://localhost:8080/store/all"
[{"id":12,"storeName":"manhattan"}]