export default class {

  constructor($stateParams, AppService) {
    'ngInject';
    angular.extend(this, {$stateParams, AppService});
    // TODO Use getPostBody()
    this.post = {
      postId: 1234,
      title: 'Sample forum post',
      author: 'nhippen',
      body: 'Woo yay its a working forum post!',
      comments: [] // TODO
    };
  }

  getPostBody() {
    this.AppService.getPost($stateParams.postId).then((response) => {
      this.post = response.data;
    });
  }

}
