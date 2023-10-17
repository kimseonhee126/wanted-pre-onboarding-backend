'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class notice extends Model {}
  
  notice.init({
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    name: DataTypes.STRING,
    country: DataTypes.STRING,
    city: DataTypes.STRING,
    position: DataTypes.STRING,
    award: DataTypes.INTEGER,
    tech: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'notice',
  });
  return notice;
};