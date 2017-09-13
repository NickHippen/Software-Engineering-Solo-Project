export default function routesConfig($stateProvider) {
  'ngInject';

  $stateProvider
    .state('create-post', {
      url: '/createPost',
      component: 'createPost'
    });
}
