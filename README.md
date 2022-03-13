# Payment System with DDD

## 1. Project Settings
### - Module Guide
본 프로젝트는 CQRS 패턴을 이용하여 구현되어 있다.
이에 따라 gradle을 이용하여 모듈이 둘로 나뉘어져 있는 디렉토리 구조를 확인할 수 있다. 
서비스를 위해서는 `payment-command` 모듈과 `payment-query` 모듈을 각각 실행해야 한다.

#### payment-command 모듈
CRUD 중에서 CUD 만을 담당하는 모듈이다.
본인의 테이블에 DB를 저장하며, 해당 이벤트를 Kafka에 발행하여 Query 모듈에 알려준다.
DDD의 핵심 도메인들은 이곳에 구현이 된다.

#### payment-query 모듈
CRUD 중에서 R 만을 담당하는 모듈이다.
payment-command에서 발행한 이벤트를 Kafka로부터 consume하여 본인의 DB를 업데이트 한다.
이 모듈은 DDD의 핵심 도메인 중심이 아닌, 클라이언트에게 필요한 정보를 제공한다. 위의 command 모듈과는 다르게 조회의 효율성, 클라이언트의 호출과 관련하여 조회에 유연하게 구성해야 한다.

### - Infra Used
```
1. MySQL 8.0.21 for Command
2. MySQL 8.0.21 for Query
3. Kafka
```
위의 인프라는 로컬 실행을 위해서 docker-compose를 이용하였다.
```
docker-compose up -d
```
CQRS에서 DB를 분리하는 방법은 여러가지가 있지만, 가장 보편적인(?) 방식인 물리 DB를 나누는 방식을 이용하였다.
command와 query 모듈은 각각 다른 DB를 보게된다. 

kafka의 경우 application.yaml에 특별한 설정 없이도 kafka에 자동으로 붙게 설정이 되어 있다.(autoconfigure 덕분에)
이외의 운영을 위한 상세 설정은 생략했다.

