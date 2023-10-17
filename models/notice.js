'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class notice extends Model {}
  
  notice.init({
    // primary key: 고유 아이디
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    // 회사 이름
    name: DataTypes.STRING,
    // 회사 국가
    country: DataTypes.STRING,
    // 회사 지역
    city: DataTypes.STRING,
    // 포지션
    position: DataTypes.STRING,
    // 보상금
    award: DataTypes.INTEGER,
    // 사용 기술
    tech: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'notice',
  });
  return notice;
};