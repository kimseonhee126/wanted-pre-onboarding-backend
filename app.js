// express 사용
const express = require('express');

// app 변수 활용
const app = express();

// models에 정의한 db 내용 가져오기
const db = require('./models/index');

// cooperate model 활용하기
const { cooperate } = db;

// notice model 활용하기
const { notice } = db;

// JSON 파싱을 위한 미들웨어
app.use(express.json());

// 있지는 않지만...메인화면
app.get('/', async(req, res) => {
    res.send('메인 화면');
});

// 요구사항 4. 채용공고 목록을 가져옵니다.
app.get('/register', async(req, res) => {
    
    // try - catch 구문을 사용했습니다.
    // 모든 채용공고(notice) 목록을 가져와 변수에 담고, response로 보내줍니다.
    try {
        const allCooperate = await notice.findAll();
        res.send(allCooperate);
    }
    catch (error) {
        res.status(404).send('Error!!');
    }
});

// 요구사항 1. 채용 공고를 등록합니다
app.post('/register', async(req, res) => {
    /*
    JSON 형식으로
    {    
    "id": 2,
    "position": "백엔드 주니어 개발자",
    "award": 1000000,
    "detail": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "tech": "Python"
    }

    이렇게 request의 body가 요청이 날아오면 try 부분을 실행합니다
     */
    const newCooperate = req.body;

    try {
        // newCooperate을 cooperate 모델에 알맞게 생성합니다.
        const cooperates = cooperate.build(newCooperate);
        // cooperates를 저장하여 mysql에도 적용되게 합니다.
        await cooperates.save();
        // response로 cooperates를 보내줍니다.
        res.send(cooperates);
    }
    catch (error) {
        console.error('Error: ', error);
        res.status(500).send('Error');
    }
});

// 요구사항 2. 채용 공고를 수정합니다
app.put('/register/:id', async(req, res) => {
    /* 
    JSON 형식으로
    {    
    "id": 1,
    "position": "백엔드 주니어 개발자",
    "award": 2500000,
    "detail": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "tech": "Django"
    }

    수정하고 싶은 공고의 id를 params로, 수정하고 싶은 내용을 body로 request 보내면
    */
    const { id } = req.params;
    const newCooperate = req.body;

    // 해당 id를 가진 공고를 찾는다
    const cooperates = await cooperate.findOne({
        where: { id },
    });

    // 만약 해당 id를 가진 공고가 존재한다면, 수정하고 싶은 내용(body) 부분으로 수정한다
    if (cooperates)
    {
        // 
        Object.keys(newCooperate).forEach((prop) => {
            cooperates[prop] = newCooperate[prop];
        });

        // .save()하여 mysql에 저장한다
        await cooperates.save();
        res.send(cooperates);
    }
});

// 요구사항 3. 채용공고를 삭제합니다.
app.delete('/register/:id', async(req, res) => {
    //
    const { id } = req.params;

    const deleteCooperate = await cooperate.destroy({
        where: { id },
    });

    if (deleteCooperate)
    {
        res.send({ message: 'delete success!!' });
    }
    else
    {
        res.status(404).send({ message: 'Cannot found!!' });
    } 
});

// 
app.post('/recruit', async(req, res) => {
    const newNotices = req.body;

    try {
        const notices = notice.build(newNotices);
        await notices.save();
        res.send(notices);
    }
    catch (error) {
        console.error('Error: ', error);
        res.status(500).send('Error');
    }
});

// Server is running on 3000...
app.listen(3000, async(req, res) => {
    console.log('3000 Server is running');
});