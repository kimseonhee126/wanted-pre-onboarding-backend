##  wanted-pre-onboarding-backend
> 원티드 프리 온보딩 사전과제입니다.

> 해당 과제는 Node.Js와 MySQL을 사용해서 수행했습니다.

## ORM과 Sequelize
Node.JS와 MySQL 사이에는 ORM 방식을 사용하여 객체형 언어(Js)와 관계형 데이터베이스(MySQL)가 연결될 수 있게 수행했습니다.

```
npm install mysql2 sequelize-sequelize-cli
```
```
npx sequelize init
```
다음 명령어들을 통해 Node.Js와 MySQL이 연결될 수 있도록 도와주는 파일과 폴더들을 생성했습니다.

## package.json
개발자가 사용한 모듈의 version을 확인할 수 있습니다.

```
npm init -y
```
해당 명령어를 사용하여 현재 디렉토리명으로 패키지를 만들었습니다

## 디렉토리 설명
### config
> 데이터베이스 접속에 관한 설정들이 들어 있는 폴더입니다.
> development 객체, test 객체, production 객체가 있고, 개발할 때는 development 객체를 사용합니다

### migration, models
> migration은 mysql에 테이블을 만들 때 사용하는 폴더입니다.

> model을 생성합니다.

> 각 테이블의 컬럼에 대한 자세한 설정을 할 수 있습니다.

> 데이터베이스 안에서 일어나는 모든 변경사항을 반영할 수 있습니다

데이터베이스(DB) 생성
```
npx sequelize db:create --env development
```

model과 table 생성
```
npx sequelize model:generate --name [테이블명] --attributes [컬럼명]:[데이터타입]...
```

table 실행
```
npx sequelize db:migrate
```

### seeders
seeder 파일 생성
```
npx sequelize seed:generate --name initialCooperate
```
```
npx sequelize seed:generate --name initialNotice
```

seed 모든 데이터 삽입
```
npx sequelize db:seed:all
```

seed 모든 데이터 삭제
```
npx sequelize db:seed:undo:all
```


## app.js
실제 뒤에서 동작하는 코드를 작성하는 부분입니다.

