const Sequelize = require('sequelize');
const config = require('../config/config.json');

// const { database, host, passwd } = config.development;
const sequelize = new Sequelize('####', '####', '####', {
  host: '127.0.0.1',
  dialect: 'mysql',
  port: "####",
});

// cooperate, notice 모델을 가져옵니다.
const cooperate = require('./cooperate')(sequelize, Sequelize.DataTypes);
const notice = require('./notice.js')(sequelize, Sequelize.DataTypes);

// db에 객체를 넣어 export 하여 다른 .js 파일에서도 cooperate, notice 모델을 사용할 수 있게 합니다.
const db = {};
db.cooperate = cooperate;
db.notice = notice;

module.exports = db;