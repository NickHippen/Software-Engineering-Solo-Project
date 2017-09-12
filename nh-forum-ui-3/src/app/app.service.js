export default class {

  constructor($http) {
    'ngInject';
    angular.extend(this, {$http});
  }

  getPosts() {
    return this.$http({
      method: 'GET',
      url: `http://localhost:8080/nh-forum-rest/MyServlet`
    });
  }

}
