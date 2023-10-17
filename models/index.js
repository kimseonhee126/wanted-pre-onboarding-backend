const Sequelize = require('sequelize');
const config = require('../config/config.json');

// const { database, host, passwd } = config.development;
const sequelize = new Sequelize('company', 'root', 'wktlr011226!', {
  host: '127.0.0.1',
  dialect: 'mysql',
  port: 8080,
});

const cooperate = require('./cooperate')(sequelize, Sequelize.DataTypes);
const notice = require('./notice.js')(sequelize, Sequelize.DataTypes);

const db = {};
db.cooperate = cooperate;
db.notice = notice;

module.exports = db;