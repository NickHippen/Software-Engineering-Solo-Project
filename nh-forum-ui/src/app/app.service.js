const BASE_URL = 'http://nhippen.ddns.net';

export default class {

  constructor($http) {
    'ngInject';
    angular.extend(this, {$http});
  }

  findPosts() {
    return this.$http({
      method: 'GET',
      url: `${BASE_URL}:8080/nh-forum-rest/listPosts`
    });
  }

  getPost(postId) {
    return this.$http({
      method: 'GET',
      url: `${BASE_URL}:8080/nh-forum-rest/post/${postId}`
    });
  }

  createPost(title, body, userId) {
    return this.$http({
      method: 'GET',
      url: `${BASE_URL}:8080/nh-forum-rest/createPost`,
      params: {title, body, userId}
    });
  }

  createComment(postId, body, userId) {
    return this.$http({
      method: 'GET',
      url: `${BASE_URL}:8080/nh-forum-rest/createComment`,
      params: {postId, body, userId}
    });
  }

}
