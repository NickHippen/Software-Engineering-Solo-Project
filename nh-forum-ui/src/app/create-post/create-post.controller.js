export default class {

  constructor($state, AppService) {
    'ngInject';
    angular.extend(this, {$state, AppService});
  }

  createPost() {
    if (!this.title || !this.body || !this.userId) {
      return;
    }
    this.AppService.createPost(this.title, this.body, this.userId).then(() => {
      this.$state.go('app');
    });
  }

}
