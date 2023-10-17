'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    'notice',
    [
      {
        id: 1,
        name: '원티드랩',
        country: '한국',
        city: '서울',
        position: '백엔드 주니어 개발자',
        award: 1500000,
        detail: '',
        tech: 'Python',
      },
      {
        id: 2,
        name: '네이버',
        country: '한국',
        city: '판교',
        position: 'Django 백엔드 개발자',
        award: 1000000,
        detail: '',
        tech: 'Django',
      },
    ]
  },

  async down (queryInterface, Sequelize) {
    await queryInterface.bulkDelete('notice', null, {});
  }
};
