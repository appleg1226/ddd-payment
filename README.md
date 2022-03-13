# Payment System with DDD

## 1. Project Settings
### - Module Guide
본 프로젝트는 CQRS 패턴을 이용하여 구현되어 있다.
이에 따라 gradle을 이용하여 모듈이 둘로 나뉘어져 있는 디렉토리 구조를 확인할 수 있다. 
서비스를 위해서는 `payment-command` 모듈과 `payment-query` 모듈을 각각 실행해야 한다.

### - Infra Used
```
1. MySQL 8.0.21
2. Kafka
```
위의 인프라는 로컬 테스트를 위해서 docker-compose를 이용하여 간단하게 실행할 수 있도록 되어 있다.
```
docker-compose up -d
```
spring boot autoconfigure 덕분에 kafka는 위의 docker-compose 파일을 이용하여 접근할 경우, 
따로 설정이 필요가 없다. 로컬 테스트용 설정이기 때문에 간단하게 

<hr>