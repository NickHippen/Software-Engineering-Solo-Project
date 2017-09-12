export default class {

  constructor($log, AppService) {
    'ngInject';
    angular.extend(this, {$log, AppService});
    AppService.findPosts().then(response => {
      $log.info(response);
    });
    this.posts = [
      {
        author: 'nhippen',
        title: 'Sample forum post 1'
      },
      {
        author: 'nhippen',
        title: 'Sample forum post 2'
      }
    ];
  }

}
