export default class {

  constructor($state, $stateParams, AppService) {
    'ngInject';
    angular.extend(this, {$state, $stateParams, AppService});
    if (angular.isUndefined(this.$stateParams.postId)) {
      throw new Error('No post id in parameters');
    }
    this.getPostBody();
  }

  getPostBody() {
    this.AppService.getPost(this.$stateParams.postId).then(response => {
      this.post = response.data;
    });
  }

  submitComment() {
    if (!this.commentBody || !this.commentUserId) {
      return;
    }
    this.AppService.createComment(this.$stateParams.postId, this.commentBody, this.commentUserId).then(() => {
      this.$state.reload();
    });
  }

}
