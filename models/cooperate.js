'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class cooperate extends Model {}

  cooperate.init({
    // primary key: 고유 아이디
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    // 포지션
    position: DataTypes.STRING,
    // 보상금
    award: DataTypes.INTEGER,
    // 내용
    detail: DataTypes.STRING,
    // 기술
    tech: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'cooperate',
  });
  return cooperate;
};