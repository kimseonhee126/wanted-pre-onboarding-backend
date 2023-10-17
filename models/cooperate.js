'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class cooperate extends Model {}

  cooperate.init({
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    position: DataTypes.STRING,
    award: DataTypes.INTEGER,
    detail: DataTypes.STRING,
    tech: DataTypes.STRING
  }, {
    sequelize,
    modelName: 'cooperate',
  });
  return cooperate;
};