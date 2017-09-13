export default class {

  constructor($log, AppService) {
    'ngInject';
    angular.extend(this, {$log, AppService});
    AppService.findPosts().then(response => {
      this.posts = response.data;
    });
  }

}
