'use strict';
/** @type {import('sequelize-cli').Migration} */
module.exports = {
  up: async(queryInterface, Sequelize) => {
    await queryInterface.createTable('notices', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      name: {
        type: Sequelize.STRING(25)
      },
      country: {
        type: Sequelize.STRING(10)
      },
      city: {
        type: Sequelize.STRING(20)
      },
      position: {
        type: Sequelize.STRING(25)
      },
      award: {
        type: Sequelize.INTEGER
      },
      detail: {
        type: Sequelize.STRING(150)
      },
      tech: {
        type: Sequelize.STRING(20)
      },
      createdAt: {
        allowNull: false,
        type: Sequelize.DATE,
        defaultValue: Sequelize.fn('now'),
      },
      updatedAt: {
        allowNull: false,
        type: Sequelize.DATE,
        defaultValue: Sequelize.fn('now'),
      }
    });
  },
  down: async(queryInterface, Sequelize) => {
    await queryInterface.dropTable('notices');
  }
};