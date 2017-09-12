export default class {

  constructor($http) {
    'ngInject';
    angular.extend(this, {$http});
  }

  findPosts() {
    return this.$http({
      method: 'GET',
      url: `http://localhost:8080/nh-forum-rest/listPosts`
    });
  }

  getPost(postId) {
    return this.$http({
      method: 'GET',
      url: `http://localhost:8080/nh-forum-rest/post/${postId}`
    });
  }

}
