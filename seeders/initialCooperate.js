'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.bulkInsert(
      'cooperate',
      [
        {
          id: 1,
          position: '백엔드 주니어 개발자',
          award: 1000000,
          detail: '원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..',
          tech: 'Python',
        },
      ]
    )
  },

  async down (queryInterface, Sequelize) {
    await queryInterface.bulkDelete('cooperate', null, {});
  },
};
